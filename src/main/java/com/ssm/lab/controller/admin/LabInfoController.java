package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.LabInfo;
import com.ssm.lab.bean.User;
import com.ssm.lab.service.BorrowService;
import com.ssm.lab.service.LabInfoService;
import com.ssm.lab.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("labInfoController")
@RequestMapping("/manage/labinfo")
public class LabInfoController {

    @Autowired
    private LabInfoService labInfoService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("labInfo", new LabInfo());
        return "admin/labinfo_add";
    }

    @RequestMapping("/add")
    public String add(LabInfo labInfo) throws IOException {
        labInfoService.add(labInfo);
        return "redirect:list";
    }

    @RequestMapping(value = "/to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("labInfo", labInfoService.getByid(id));
        return "admin/labinfo_update";
    }

    @RequestMapping("/update")
    public String update(LabInfo labInfo) throws IOException {
        labInfoService.edit(labInfo);
        return "redirect:list";
    }


    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
            Model model){
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 10);
        PageInfo page = new PageInfo(labInfoService.getAll(), 5);
        model.addAttribute("pageInfo",page);

        return "admin/labinfo_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id){
        labInfoService.remove(id);
        return "redirect:list";
    }
}
