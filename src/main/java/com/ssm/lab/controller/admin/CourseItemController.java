package com.ssm.lab.controller.admin;

import com.ssm.lab.bean.CourseItem;
import com.ssm.lab.common.Constants;
import com.ssm.lab.service.CourseItemService;
import com.ssm.lab.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller("courseItemController")
@RequestMapping("/manage/courseitem")
public class CourseItemController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseItemService courseItemService;

    @RequestMapping(value = "/to_add", params = "cid")
    public String toAdd(Integer cid, Model model){
        model.addAttribute("course", courseService.getByid(cid));
        model.addAttribute("expdemandList", Constants.getExpdemand());
        model.addAttribute("exptypeList", Constants.getExptype());
        model.addAttribute("courseitem", new CourseItem());
        return "admin/courseitem_add";
    }

    @RequestMapping(value = "/add")
    public String add(CourseItem courseitem){
        courseItemService.add(courseitem);
        return "redirect:/manage/course/list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        CourseItem courseItem = courseItemService.getByid(id);
        model.addAttribute("expdemandList", Constants.getExpdemand());
        model.addAttribute("exptypeList", Constants.getExptype());
        model.addAttribute("courseitem", courseItem);
        return "admin/courseitem_update";
    }

    @RequestMapping("update")
    public String update(CourseItem courseItem) {
        courseItemService.edit(courseItem);
        return "redirect:/manage/course/list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id){
        courseItemService.remove(id);
        return "redirect:/manage/course/list";
    }

}
