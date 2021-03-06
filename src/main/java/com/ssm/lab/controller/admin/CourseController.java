package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.Course;
import com.ssm.lab.bean.User;
import com.ssm.lab.common.Constants;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.service.CategoryService;
import com.ssm.lab.service.CourseService;
import com.ssm.lab.utils.FileUtil;
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
import java.util.List;
import java.util.UUID;

@Controller("courseController")
@RequestMapping("/manage/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("propertyList", Constants.getProperties());
        model.addAttribute("course", new Course());
        return "admin/course_add";
    }

    @RequestMapping("/add")
    public String add(Course course, HttpSession session, HttpServletRequest request) throws IOException {
        saveFile(course, request);
        courseService.add(course);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("propertyList", Constants.getProperties());
        model.addAttribute("course", courseService.getByid(id));
        return "admin/course_update";
    }

    @RequestMapping("update")
    public String update(Course course,HttpServletRequest request) throws IOException {
        saveFile(course, request);
        courseService.edit(course);
        return "redirect:list";
    }

    //上传文件不为空，则保存到指定路径下
    private void saveFile(Course course,HttpServletRequest request) throws IOException {
        if (!course.getDlurlFile().isEmpty()) {
            //大纲文件上传路径
            String outlinePath = request.getServletContext().getRealPath(Constants.OUTLINE_PATH);
            //上传文件名
            String filename = course.getDlurlFile().getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));

            filename = System.currentTimeMillis() + suffix;
            File filepath = new File(outlinePath, filename);
            //判断路径是否存在
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件中
            course.getDlurlFile().transferTo(new File(outlinePath+File.separator+filename));
            course.setDlurl(Constants.OUTLINE_PATH + "/" + filename);
        }
        if (!course.getBookurlFile().isEmpty()) {
            //指导书文件上传路径
            String bookPath = request.getServletContext().getRealPath(Constants.LABBOOK_PATH);
            //上传文件名
            String filename = course.getBookurlFile().getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));

            filename = System.currentTimeMillis() + suffix;
            File filepath = new File(bookPath, filename);
            //判断路径是否存在
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件中
            course.getBookurlFile().transferTo(new File(bookPath+File.separator+filename));
            course.setBookurl(Constants.LABBOOK_PATH + "/" + filename);
        }
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "keywords", required = false)String keywords,
            Model model){
        PageHelper.startPage(pn, 10);
        if(StringUtils.isNotBlank(type) && StringUtils.isNotBlank(keywords)){
            keywords=keywords.trim();
            PageInfo page = new PageInfo(courseService.getByType(type, keywords), 5);
            model.addAttribute("pageInfo",page);
        } else {
            List<Course> courses = courseService.getAll();
            PageInfo page = new PageInfo(courses, 5);
            model.addAttribute("pageInfo",page);
        }

        return "admin/course_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id,HttpServletRequest request){
        Course course = courseService.getByid(id);
        if (StringUtils.isNotBlank(course.getDlurl())) {
            String fileName = request.getServletContext().getRealPath(course.getDlurl());
            FileUtil.deleteFile(fileName);
        }
        if (StringUtils.isNotBlank(course.getBookurl())) {
            String fileName = request.getServletContext().getRealPath(course.getBookurl());
            FileUtil.deleteFile(fileName);
        }
        courseService.remove(id);
        return "redirect:list";
    }

}
