package com.ssm.lab.controller;

import com.ssm.lab.bean.User;
import com.ssm.lab.common.CodeCaptchaServlet;
import com.ssm.lab.common.Result;
import com.ssm.lab.common.ResultGenerator;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.service.CategoryService;
import com.ssm.lab.service.LabInfoService;
import com.ssm.lab.service.UserService;
import com.ssm.lab.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller("globalController")
public class GloablController {
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private LabInfoService labInfoService;

    //后台首页
    @RequestMapping("/manage/home")
    public String home(){
        return "admin/home";
    }

    //前台首页
    @RequestMapping(value = {"/index","/"})
    public String index(Model model){
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("labInfoList", labInfoService.getAll());
        model.addAttribute("articleList", articleService.getTopN(10));
        model.addAttribute("articleListWithImage", articleService.getTopNWithImage(5));
        return "portal/index";
    }

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(Model model, HttpSession session,@RequestParam String sn,@RequestParam String password){
        if (StringUtils.isBlank(sn) || StringUtils.isBlank(password)) {
            model.addAttribute("error","请输入用户名或密码!");
            return "login";
        }
        //盐值加密
        password = MD5Util.MD5EncodeUtf8(password);
        User user = userService.login(sn, password);
        if (user == null) {
            model.addAttribute("error","您的用户名或密码错误!");
            return "login";
        }
        session.setAttribute("user",user);
        if (StringUtils.equals(user.getRole(), "1")) {
            return "redirect:manage/home";
        } else {
            return "redirect:index";
        }
    }

    @RequestMapping("/logout")
    public String quit(HttpSession session){
        session.setAttribute("user",null);
        return "redirect:/index";
    }

    /**
     * 判断验证码是否正确
     *
     * @param code
     * @return
     */
    @RequestMapping("/login_checkCode")
    @ResponseBody
    public Map<String, Object> checkCode(HttpServletRequest request, String code) {
        Map map = new HashMap<String, Object>();
        String vcode = (String) request.getSession().getAttribute(CodeCaptchaServlet.VERCODE_KEY);

        if (code.equals(vcode)) {
            //验证码正确
            map.put("getdata", "true");
        } else {
            //验证码错误
            map.put("getdata", "false");
        }
        return map;
    }



}
