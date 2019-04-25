package com.ssm.lab.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.User;
import com.ssm.lab.bean.WorkRecord;
import com.ssm.lab.service.UserService;
import com.ssm.lab.service.WorkRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller("workRecordController")
@RequestMapping("/manage/workrecord")
public class WorkRecordController {

    @Autowired
    private WorkRecordService workRecordService;
    @Autowired
    private UserService userService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("userList", userService.getSnAndName());
        model.addAttribute("record", new WorkRecord());
        return "admin/work_record_add";
    }

    @RequestMapping("/add")
    public String add(WorkRecord record, HttpSession session) throws IOException {
        //当前登录的用户
        User loginUser = (User) session.getAttribute("user");
        record.setUserSn(loginUser.getSn());
        workRecordService.add(record);
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("userList", userService.getSnAndName());
        model.addAttribute("record", workRecordService.getByid(id));
        return "admin/work_record_update";
    }

    @RequestMapping("update")
    public String update(WorkRecord record) throws IOException {
        workRecordService.edit(record);
        return "redirect:list";
    }

    @RequestMapping("/list")
    public String list(@RequestParam(value = "pn", defaultValue = "1") Integer pn,
            @RequestParam(value = "startTime",required = false) String startTime,
            @RequestParam(value = "endTime",required = false) String endTime,
            @RequestParam(value = "type", required = false) String type,
            @RequestParam(value = "keywords", required = false)String keywords,
            Model model){
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

        return "admin/work_record_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(Integer id){
        workRecordService.remove(id);
        return "redirect:list";
    }
}
