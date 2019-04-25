package com.ssm.lab.controller.admin;

import com.ssm.lab.bean.Category;
import com.ssm.lab.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("categoryController")
@RequestMapping("/manage/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("category", new Category());
        return "admin/category_add";
    }

    @RequestMapping("/add")
    public String add(Category category) {
        categoryService.add(category);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "cid")
    public String toUpdate(Integer cid, Model model) {
        model.addAttribute("category", categoryService.getByid(cid));
        return "admin/category_update";
    }

    @RequestMapping("update")
    public String update(Category category) {
        categoryService.edit(category);
        return "redirect:list";
    }


    @RequestMapping("/list")
    public String list(Model model){
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("categoryNum", categoryService.count());
        return "admin/category_list";
    }

    @RequestMapping(value = "/remove",params = "cid")
    public String remove(Integer cid){
        categoryService.remove(cid);
        return "redirect:list";
    }
}
