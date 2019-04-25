package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Article;
import com.ssm.lab.bean.Category;
import com.ssm.lab.bean.User;
import com.ssm.lab.common.Constants;
import com.ssm.lab.service.ArticleService;
import com.ssm.lab.service.CategoryService;
import com.ssm.lab.service.UserService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Controller("articleController")
@RequestMapping("/manage/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("article", new Article());
        return "admin/article_add";
    }

    @RequestMapping("/add")
    public String add(Article article, HttpSession session, HttpServletRequest request) throws IOException {
        //文章作者为当前登录的用户
        User loginUser = (User) session.getAttribute("user");
        article.setUserSn(loginUser.getSn());
        saveFile(article, request);
        articleService.add(article);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Long id, Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("article", articleService.getByid(id));
        return "admin/article_update";
    }

    @RequestMapping("update")
    public String update(Article article,HttpServletRequest request) throws IOException {
        saveFile(article, request);
        articleService.edit(article);
        return "redirect:list";
    }

    //上传文件不为空，则保存到指定照片路径下
    private void saveFile(Article article,HttpServletRequest request) throws IOException {
        if (!article.getImage().isEmpty()) {
            //文件上传路径
            String path = request.getServletContext().getRealPath(Constants.CAROUSEL_PATH);
            //上传文件名
            String filename = article.getImage().getOriginalFilename();
            String suffix = filename.substring(filename.lastIndexOf("."));

            filename = System.currentTimeMillis() + suffix;
            File filepath = new File(path, filename);
            //判断路径是否存在
            if(!filepath.getParentFile().exists()){
                filepath.getParentFile().mkdirs();
            }
            //将上传文件保存到一个目标文件中
            article.getImage().transferTo(new File(path+File.separator+filename));
            article.setShowImage(Constants.CAROUSEL_PATH + "/" + filename);
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
            keywords=keywords.trim();
            PageInfo page = new PageInfo(articleService.getByType(type, keywords), 5);
            model.addAttribute("pageInfo",page);
        } else {
            PageInfo page = new PageInfo(articleService.getAll(), 5);
            model.addAttribute("pageInfo",page);
        }
        return "admin/article_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(String id,HttpServletRequest request){
        List<Article> articles = articleService.getAllDeleted(id);
        for (Article article : articles) {
            if (StringUtils.isNotBlank(article.getShowImage())) {
                String fileName = request.getServletContext().getRealPath(article.getShowImage());
                FileUtil.deleteFile(fileName);
            }
        }
        articleService.remove(id);
        return "redirect:list";
    }
}
