package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.User;
import com.ssm.lab.common.Constants;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.service.BorrowService;
import com.ssm.lab.service.CategoryService;
import com.ssm.lab.service.UserService;
import com.ssm.lab.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller("borrowController")
@RequestMapping("/manage/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;
    @Autowired
    private UserService userService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("userList", userService.getSnAndName());
        model.addAttribute("borrow", new Borrow());
        return "admin/borrow_add";
    }

    @RequestMapping("/add")
    public String add(Borrow borrow, HttpSession session) throws IOException {
        //当前登录的用户
        User loginUser = (User) session.getAttribute("user");
        borrow.setBorrowHandleSn(loginUser.getSn());
        borrowService.add(borrow);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("userList", userService.getSnAndName());
        model.addAttribute("borrow", borrowService.getByid(id));
        return "admin/borrow_update";
    }

    @RequestMapping("update")
    public String update(Borrow borrow) throws IOException {
        borrowService.edit(borrow);
        return "redirect:list";
    }

    @RequestMapping(value = "back", params = "id")
    public String back(Integer id,HttpSession session) throws IOException {
        User loginUser = (User) session.getAttribute("user");
        Borrow borrow = borrowService.getByid(id);
        borrow.setReturnHandleSn(loginUser.getSn());
        borrowService.editBack(borrow);
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "keywords", required = false)String keywords,
            Model model){
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)){
            keywords=keywords.trim();
            PageInfo page = new PageInfo(borrowService.getByType(type, keywords), 5);
            model.addAttribute("pageInfo",page);
        } else {
            PageInfo page = new PageInfo(borrowService.getAll(), 5);
            model.addAttribute("pageInfo",page);
        }

        return "admin/borrow_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(String id){
        borrowService.remove(id);
        return "redirect:list";
    }
}
