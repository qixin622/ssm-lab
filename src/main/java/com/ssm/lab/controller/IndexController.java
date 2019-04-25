package com.ssm.lab.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.*;
import com.ssm.lab.common.Constants;
import com.ssm.lab.dto.WorkloadForm;
import com.ssm.lab.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("indexController")
public class IndexController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ArticleService articleService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private PracticeCourseService practiceCourseService;
    @Autowired
    private CourseItemService courseItemService;
    @Autowired
    private LabInfoService labInfoService;

    @RequestMapping("/article/show/{id}")
    public String articleShow(@PathVariable("id")Long id,Model model) {
        Article article = articleService.getByid(id);
        Integer cid = article.getCategoryId();
        articleService.editHints(id);

        Article prev_article = articleService.getPrevArticleById(id, cid);
        Article next_article = articleService.getNextArticleById(id, cid);

        model.addAttribute("article", article);
        model.addAttribute("prev_article", prev_article);
        model.addAttribute("next_article", next_article);
        menuList(model);
        return "portal/article_show";
    }

    @RequestMapping("/article/list")
    public String articleList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                        @RequestParam(value = "cid", required = false) Integer cid,
                        @RequestParam(value = "type", required = false) String type,
                        @RequestParam(value = "keywords", required = false)String keywords,
                        Model model){
        PageHelper.startPage(pn, 15);
        PageHelper.startPage(pn, 10);
        if (StringUtils.isNotBlank(keywords)) {
            keywords=keywords.trim();
        }
        PageInfo page = new PageInfo(articleService.getByTypeAndCid(cid, type, keywords), 5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("cid",cid);
        model.addAttribute("type", type);
        model.addAttribute("keywords", keywords);
        menuList(model);
        return "portal/article";
    }

    @RequestMapping("/course/list")
    public String courseList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                              @RequestParam(value = "type", required = false) String type,
                              @RequestParam(value = "keywords", required = false)String keywords,
                              Model model){
        PageHelper.startPage(pn, 10);
        if (StringUtils.isNotBlank(keywords)) {
            keywords=keywords.trim();
        }
        PageInfo page = new PageInfo(courseService.getByType(type, keywords), 5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("type", type);
        model.addAttribute("keywords", keywords);
        menuList(model);
        return "portal/course";
    }

    @RequestMapping("/course/show/{id}")
    public String courseShow(@PathVariable("id")Integer id,Model model) {
        Course course = courseService.getByid(id);
        Course prev_course = courseService.getByid(id - 1);
        Course next_course = courseService.getByid(id + 1);


        model.addAttribute("course", course);
        model.addAttribute("prev_course", prev_course);
        model.addAttribute("next_course", next_course);
        menuList(model);
        return "portal/course_show";
    }

    @RequestMapping("/courseItem/show/{id}")
    public String courseItemShow(@PathVariable("id")Integer id,Model model) {
        CourseItem courseItem = courseItemService.getByid(id);
        Course course = courseService.getByid(courseItem.getCid());

        model.addAttribute("course", course);
        model.addAttribute("courseItem", courseItem);
        menuList(model);
        return "portal/courseitem_show";
    }

    @RequestMapping("/labinfo/show/{id}")
    public String labInfoShow(@PathVariable("id")Integer id,Model model) {
        LabInfo labInfo = labInfoService.getByid(id);
        model.addAttribute("labInfo", labInfo);
        menuList(model);
        return "portal/labinfo_show";
    }

    @RequestMapping("/pcourse/list")
    public String pcourseList(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             @RequestParam(value = "type", required = false) String type,
                             @RequestParam(value = "keywords", required = false)String keywords,
                             Model model){
        PageHelper.startPage(pn, 10);
        if (StringUtils.isNotBlank(keywords)) {
            keywords=keywords.trim();
        }
        PageInfo page = new PageInfo(practiceCourseService.getByType(type, keywords), 5);
        model.addAttribute("pageInfo",page);
        model.addAttribute("type", type);
        model.addAttribute("keywords", keywords);
        menuList(model);
        return "portal/practice_course";
    }

    @RequestMapping("/pcourse/show/{id}")
    public String pcourseShow(@PathVariable("id")Integer id,Model model) {
        PracticeCourse course = practiceCourseService.getByid(id);
        PracticeCourse prev_course = practiceCourseService.getByid(id - 1);
        PracticeCourse next_course = practiceCourseService.getByid(id + 1);

        model.addAttribute("course", course);
        model.addAttribute("prev_course", prev_course);
        model.addAttribute("next_course", next_course);
        menuList(model);
        return "portal/practice_course_show";
    }

    //菜单实验室信息及文章资料分类菜单列表
    private void menuList(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("labInfoList", labInfoService.getAll());
    }
}
