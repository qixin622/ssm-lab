package com.ssm.lab.controller.admin;

import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.bean.PracticeWorkloadItem;
import com.ssm.lab.common.Constants;
import com.ssm.lab.dto.PracticeWorkloadInfo;
import com.ssm.lab.dto.WorkloadForm;
import com.ssm.lab.service.PracticeCourseService;
import com.ssm.lab.service.PracticeWorkloadService;
import com.ssm.lab.service.UserService;
import com.ssm.lab.utils.PoiUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller("practiceWorkloadController")
@RequestMapping("/manage/practice/workload")
public class PracticeWorkloadController {

    @Autowired
    private PracticeWorkloadService practiceWorkloadService;
    @Autowired
    private UserService userService;
    @Autowired
    private PracticeCourseService practiceCourseService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("terms", practiceWorkloadService.getAllTerm());
        model.addAttribute("users", userService.getSnAndName());
        model.addAttribute("workloadTypes", Constants.getWorkloadType());
        model.addAttribute("praticeTypes", Constants.getPraticeType());
        model.addAttribute("workloadProperties", Constants.getWorkloadProperty());
        model.addAttribute("courses", practiceCourseService.getAll());
        model.addAttribute("info", new PracticeWorkloadInfo());
        return "admin/practice_workload_add";
    }

    @RequestMapping("/add")
    public String add(PracticeWorkloadInfo info, RedirectAttributes attr) {
        attr.addFlashAttribute("term", info.getWorkload().getTerm());
        attr.addFlashAttribute("workloadType", info.getWorkload().getWorkloadType());
        practiceWorkloadService.save(info.getWorkload(), info.getItems());
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("terms", practiceWorkloadService.getAllTerm());
        model.addAttribute("users", userService.getSnAndName());
        model.addAttribute("workloadTypes", Constants.getWorkloadType());
        model.addAttribute("praticeTypes", Constants.getPraticeType());
        model.addAttribute("workloadProperties", Constants.getWorkloadProperty());
        model.addAttribute("courses", practiceCourseService.getAll());
        PracticeWorkloadInfo info = new PracticeWorkloadInfo();
        info.setWorkload(practiceWorkloadService.getByid(id));
        info.setItems(practiceWorkloadService.getItems(id));
        model.addAttribute("info", info);
        return "admin/practice_workload_update";
    }

    @RequestMapping("update")
    public String update(PracticeWorkloadInfo info,RedirectAttributes attr) {
        attr.addFlashAttribute("term", info.getWorkload().getTerm());
        attr.addFlashAttribute("workloadType", info.getWorkload().getWorkloadType());
        practiceWorkloadService.edit(info.getWorkload(), info.getItems());
        return "redirect:list";
    }


    @RequestMapping("/list")
    public String list(WorkloadForm workloadForm,
                       @ModelAttribute("term")String term,
                       @ModelAttribute("workloadType")String workloadType,
                       Model model){
        List<String> terms = practiceWorkloadService.getAllTerm();
        List<PracticeWorkload> workloads;
        List<String> workloadTypes = Constants.getWorkloadType();
        workloadTypes.add(0,"所有");

        model.addAttribute("workloadForm", workloadForm);
        model.addAttribute("workloadTypes", workloadTypes);
        model.addAttribute("terms", terms);
        if (StringUtils.isNotBlank(term)) {
            workloadForm.setTerm(term);
        }
        if (StringUtils.isNotBlank(workloadType)) {
            workloadForm.setWorkloadType(workloadType);
        }
        if (StringUtils.isBlank(workloadForm.getTerm()) && StringUtils.isBlank(workloadForm.getWorkloadType()) && StringUtils.isBlank(workloadForm.getType()) && StringUtils.isBlank(workloadForm.getKeywords())) {
            if (terms.size() > 0) {
                //如果是首次访问工作量列表，则显示最新一学期工作量列表
                workloads = practiceWorkloadService.getByType(terms.get(0), null, null, null);
            } else {
                workloads = practiceWorkloadService.getByType(null, null, null, null);
            }
        } else {
            if (StringUtils.isBlank(workloadForm.getKeywords())) {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    workloads = practiceWorkloadService.getByType(workloadForm.getTerm(), null, null, null);
                } else {
                    workloads = practiceWorkloadService.getByType(workloadForm.getTerm(), workloadType, null, null);
                }
            } else {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    workloads = practiceWorkloadService.getByType(workloadForm.getTerm(), null, workloadForm.getType(), workloadForm.getKeywords());
                } else {
                    workloads = practiceWorkloadService.getByType(workloadForm.getTerm(), workloadForm.getWorkloadType(), workloadForm.getType(), workloadForm.getKeywords());
                }
            }

        }
        model.addAttribute("workloads", workloads);
        return "admin/practice_workload_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(String id){
        practiceWorkloadService.remove(id);
        return "redirect:list";
    }

    /**
     * 工作量导出
     */
    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void exportUsers(@RequestParam(value = "term") String term,
                            @RequestParam(value = "workloadType") String workloadType,
                            HttpServletRequest request,
                            HttpServletResponse response) {
        List<PracticeWorkload> workloads;
        if ("所有".equals(workloadType)) {
            workloads = practiceWorkloadService.getByType(term, null, null, null);
        } else {
            workloads = practiceWorkloadService.getByType(term, workloadType, null, null);
        }
        //单元格表头
        String[] excelHeader = {"学期","工作量类型","实践类型","工作量性质","课程编号","课程名称",
                                "周数","人数","班级数","总工作量","分配明细","扣除准备工作量"};
        //字段名称
        String[] fileds = {"term", "workloadType", "practiceType", "workloadProperty","cno", "cname",
                           "weekNumbers","stuNumbers","classNumbers","totalWorkload","detail","preWorkload"};
        //单元格宽度内容格式 14列
        int[] formats = {1, 1, 1, 1, 1, 1, 5, 4, 5, 5, 1, 5};
        //单元格宽度
        int[] widths = {256 * 14, 256* 14, 256* 14, 256* 14, 256* 14, 500* 14, 150* 14, 150* 14, 150* 14, 256* 14, 600* 14, 256* 14};
        try {
            List<Map<String, Object>> excelData = new ArrayList<Map<String, Object>>();
            if (CollectionUtils.isNotEmpty(workloads)) {
                for (PracticeWorkload workload : workloads) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("term", workload.getTerm());
                    map.put("workloadType", workload.getWorkloadType());
                    map.put("practiceType", workload.getPracticeType());
                    map.put("workloadProperty", workload.getWorkloadProperty());
                    map.put("cno", workload.getCourse().getCno());
                    map.put("cname", workload.getCourse().getCname());
                    map.put("weekNumbers", workload.getWeekNumbers());
                    map.put("stuNumbers", workload.getStuNumbers());
                    map.put("classNumbers", workload.getClassNumbers());
                    map.put("totalWorkload", workload.getTotalWorkload());
                    List<PracticeWorkloadItem> items = workload.getItems();
                    String detail = "";
                    for (PracticeWorkloadItem item : items) {
                        detail += item.getTeacher().getUserName() + ": " + item.getTeacherWorkload();
                        detail += " ";
                    }
                    map.put("detail",  detail);
                    map.put("preWorkload", workload.getPreWorkload());
                    excelData.add(map);
                }
            }
            String excelName = "实践工作量_" + term + "_" + workloadType;
            PoiUtil.exportFile(excelName, excelHeader, fileds, formats, widths, excelData, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
