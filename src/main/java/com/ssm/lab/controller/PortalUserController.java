package com.ssm.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.User;
import com.ssm.lab.common.Constants;
import com.ssm.lab.common.Result;
import com.ssm.lab.common.ResultGenerator;
import com.ssm.lab.service.CategoryService;
import com.ssm.lab.service.LabInfoService;
import com.ssm.lab.service.UserService;
import com.ssm.lab.service.WorkRecordService;
import com.ssm.lab.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller("portalUserController")
public class PortalUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LabInfoService labInfoService;
    @Autowired
    private WorkRecordService workRecordService;

    //前台首页
    @RequestMapping("/user/list/{show}")
    public String userList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                           @RequestParam(value = "type", required = false) String type,
                           @RequestParam(value = "keywords", required = false)String keywords,
                           @PathVariable("show")String show,
                           Model model){
        PageHelper.startPage(pn, 15);
        if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)){
            keywords=keywords.trim();
            PageInfo page = new PageInfo(userService.getByType(type,keywords), 5);
            model.addAttribute("pageInfo",page);
        } else {
            PageInfo page = new PageInfo(userService.getAll(), 5);
            model.addAttribute("pageInfo",page);
        }
        model.addAttribute("type", type);
        model.addAttribute("keywords", keywords);
        menuList(model);

        if (StringUtils.equals(show, "table")) {
            return "portal/user_table";
        } else {
            return "portal/user_frame";
        }

    }

    //前台用户更改密码
    @RequestMapping("/user/to_change_password")
    public String toChangePassword(HttpSession session, Model model){
        menuList(model);
        User loginUser = (User)session.getAttribute("user");
        if (loginUser == null) {
            return "redirect:/index";
        }
        return "portal/change_password";
    }

    @ResponseBody
    @RequestMapping("/user/change_password")
    public Result changePassword(HttpSession session, String oldpass, String newpass ,String renewpass){
        Result result = ResultGenerator.genFailResult("登录失败");
        if (StringUtils.isEmpty(oldpass) || StringUtils.isEmpty(newpass) || StringUtils.isEmpty(renewpass)) {
            result.setMessage("请输入你的原始密码或新密码！");
            return result;
        }
        User loginUser = (User)session.getAttribute("user");

        //盐值加密
        oldpass = MD5Util.MD5EncodeUtf8(oldpass);
        User user = userService.login(loginUser.getSn(), oldpass);
        if (user == null) {
            result.setMessage("您的原始密码错误！");
            return result;
        }

        if (newpass.equals(renewpass)) {
            //更新密码
            user.setPassword(MD5Util.MD5EncodeUtf8(renewpass));
            userService.edit(user);
            result = ResultGenerator.genSuccessResult(user);
        } else {
            result.setMessage("两次输入密码不一致！");
        }
        return result;
    }

    @RequestMapping("/user/to_update")
    public String toUpdate(HttpSession session,Model model) {
        menuList(model);
        User loginUser = (User)session.getAttribute("user");
        if (loginUser == null) {
            return "redirect:/index";
        } else {
            model.addAttribute("user", userService.getBySn(loginUser.getSn()));
            model.addAttribute("technicalList", Constants.getTechnicals());
            model.addAttribute("typeList", Constants.getTypes());
            return "portal/user_update";
        }
    }

    @RequestMapping("/user/update")
    public String update(HttpSession session,User user, HttpServletRequest request) throws IOException {
        saveFile(user, request);
        userService.edit(user);
        session.setAttribute("user",user);
        return "redirect:/index";
    }
    //上传文件不为空，则保存到指定照片路径下
    private void saveFile(User user,HttpServletRequest request) throws IOException {
        if (!user.getImage().isEmpty()) {
            //文件上传路径
            String path = request.getServletContext().getRealPath(Constants.AVATARS_PATH);
            //上传文件名
            String filename = user.getImage().getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));
            filename = user.getSn() + suffix;
            File filepath = new File(path, filename);
            //判断路径是否存在
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件中
            user.getImage().transferTo(new File(path+File.separator+filename));
            user.setPhoto(Constants.AVATARS_PATH + "/" + filename);
        }
    }

    @RequestMapping("/user/workrecord/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                       @RequestParam(value = "startTime",required = false) String startTime,
                       @RequestParam(value = "endTime",required = false) String endTime,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "keywords", required = false)String keywords,
                       Model model,HttpSession session){
        menuList(model);
        User loginUser = (User)session.getAttribute("user");
        if (loginUser == null) {
            return "redirect:/index";
        }

        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        if(StringUtils.isNotBlank(startTime) && StringUtils.isNotBlank(endTime)){
            if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)) {
                keywords = keywords.trim();
                PageInfo page = new PageInfo(workRecordService.getByType(startTime, endTime, type, keywords), 5);
                model.addAttribute("pageInfo", page);
            } else {
                PageInfo page = new PageInfo(workRecordService.getByType(startTime, endTime, null, null), 5);
                model.addAttribute("pageInfo", page);
            }
        } else {
            if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)) {
                PageInfo page = new PageInfo(workRecordService.getByType(null, null, type, keywords), 5);
                model.addAttribute("pageInfo", page);
            } else {
                PageInfo page = new PageInfo(workRecordService.getAll(), 5);
                model.addAttribute("pageInfo",page);
            }
        }

        return "portal/work_record_list";
    }

    //菜单实验室信息及文章资料分类菜单列表
    private void menuList(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("labInfoList", labInfoService.getAll());
    }
}
