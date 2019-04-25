package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.User;
import com.ssm.lab.common.*;
import com.ssm.lab.service.UserService;
import com.ssm.lab.utils.DateTimeUtil;
import com.ssm.lab.utils.FileUtil;
import com.ssm.lab.utils.MD5Util;
import com.ssm.lab.utils.PoiUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("userController")
@RequestMapping("/manage/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/to_add")
    public String toAdd(Map<String,Object> map){
        map.put("user",new User());
        map.put("technicalList", Constants.getTechnicals());
        map.put("typeList", Constants.getTypes());
        return "admin/user_add";
    }

    @RequestMapping("/add")
    public String add(User user, HttpServletRequest request) throws IOException {
        saveFile(user, request);
        userService.add(user);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "sn")
    public String toUpdate(String sn, Map<String,Object> map) {
        map.put("user", userService.getBySn(sn));
        map.put("technicalList", Constants.getTechnicals());
        map.put("typeList", Constants.getTypes());
        return "admin/user_update";
    }

    @RequestMapping("update")
    public String update(User user, HttpServletRequest request) throws IOException {
        saveFile(user, request);
        userService.edit(user);
        return "redirect:list";
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
            // TODO: 2019/3/16 测试创建文件夹功能是否正确
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件中
            user.getImage().transferTo(new File(path+File.separator+filename));
            user.setPhoto(Constants.AVATARS_PATH + "/" + filename);
        }
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "keywords", required = false)String keywords,
                       Model model){
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)){
            PageInfo page = new PageInfo(userService.getByType(type,keywords), 5);
            model.addAttribute("pageInfo",page);
        } else {
            PageInfo page = new PageInfo(userService.getAll(), 5);
            model.addAttribute("pageInfo",page);
        }
        model.addAttribute("type", type);
        model.addAttribute("keywords", keywords);
        return "admin/user_list";
    }

    @RequestMapping(value = "/remove",params = "sn")
    public String remove(String sn,HttpServletRequest request){
        User user = userService.getBySn(sn);
        if (StringUtils.isNotBlank(user.getPhoto()) && !user.getPhoto().endsWith("photo.jpg")) {
            String fileName = request.getServletContext().getRealPath(user.getPhoto());
            FileUtil.deleteFile(fileName);
        }
        userService.remove(sn);
        return "redirect:list";
    }

    /**
     * 检查职工编号是否可用
     * @param sn
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkSn")
    public Map<String, Object> checkSn(@RequestParam("sn") String sn){
        //数据库编号重复校验
        Map map = new HashMap<String, Object>();
        User user = userService.getBySn(sn);
        if(user!=null){
            map.put("getdata", "false");
        }else{
            map.put("getdata", "true");
        }
        return map;
    }

    /**
     * 批量导入用户(直接导入)
     */
    @RequestMapping(value = "/import", method = RequestMethod.POST)
    @ResponseBody
    public Result saveByExcelFileV1(@RequestParam("file") MultipartFile multipartFile) {
        File file = FileUtil.convertMultipartFileToFile(multipartFile);
        if (file == null) {
            return ResultGenerator.genFailResult("文件导入失败");
        }
        int importResult = userService.importUsersByExcelFile(file);
        if (importResult >= 0) {
            Result result = ResultGenerator.genSuccessResult();
            result.setData(importResult);
            return result;
        } else {
            return ResultGenerator.genFailResult("文件导入失败");
        }
    }

    /**
     * 文件导出
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportUsers(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.getAll();
        //单元格表头
        String[] excelHeader = {"教工编号","教工姓名","教工密码","性别","出生日期","职称","教师类别","电话号码","电子邮件","照片","用户角色"};
        //字段名称
        String[] fileds = {"sn", "userName", "password", "sex", "birthday", "technical", "type", "phone", "email", "photo", "role"};
        //单元格宽度内容格式
        int[] formats = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        //单元格宽度
        int[] widths = {256 * 14, 256 * 14, 700 * 14, 128* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14};
        try {
            List<Map<String, Object>> excelData = new ArrayList<Map<String, Object>>();
            if (CollectionUtils.isNotEmpty(userList)) {
                for (User user : userList) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("sn", user.getSn());
                    map.put("userName", user.getUserName());
                    map.put("password", user.getPassword());
                    map.put("sex", user.getSex());
                    map.put("birthday", DateTimeUtil.dateToStr(user.getBirthday()));
                    map.put("technical", user.getTechnical());
                    map.put("type", user.getType());
                    map.put("phone", user.getPhone());
                    map.put("email", user.getEmail());
                    map.put("photo", user.getPhoto());
                    map.put("role",  StringUtils.equals(user.getRole(),"0") ? "普通用户" : "系统管理员");
                    excelData.add(map);
                }
            }
            String excelName = "用户数据_" + System.currentTimeMillis();
            PoiUtil.exportFile(excelName, excelHeader, fileds, formats, widths, excelData, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/to_change_password")
    public String toChangePassword(){
        return "admin/change_password";
    }
}
