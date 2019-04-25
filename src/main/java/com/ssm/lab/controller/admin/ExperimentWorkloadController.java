package com.ssm.lab.controller.admin;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.common.Constants;
import com.ssm.lab.dto.ExperimentWorkloadInfo;
import com.ssm.lab.dto.WorkloadForm;
import com.ssm.lab.service.CourseService;
import com.ssm.lab.service.ExperimentWorkloadService;
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

@Controller("experimentWorkloadController")
@RequestMapping("/manage/experiment/workload")
public class ExperimentWorkloadController {

    @Autowired
    private ExperimentWorkloadService experimentWorkloadService;
    @Autowired
    private UserService userService;
    @Autowired
    private CourseService courseService;

    @RequestMapping("/to_add")
    public String toAdd(Model model){
        model.addAttribute("terms", experimentWorkloadService.getAllTerm());
        model.addAttribute("users", userService.getSnAndName());
        model.addAttribute("workloadTypes", Constants.getWorkloadType());
        model.addAttribute("courses", courseService.getAll());
        model.addAttribute("info", new ExperimentWorkloadInfo());
        return "admin/experiment_workload_add";
    }

    @RequestMapping("/add")
    public String add(ExperimentWorkloadInfo info, RedirectAttributes attr) {
        attr.addFlashAttribute("term", info.getWorkload().getTerm());
        attr.addFlashAttribute("workloadType", info.getWorkload().getWorkloadType());
        experimentWorkloadService.save(info.getWorkload(), info.getItems());
        return "redirect:list";
    }

    @RequestMapping(value = "to_update", params = "id")
    public String toUpdate(Integer id, Model model) {
        model.addAttribute("terms", experimentWorkloadService.getAllTerm());
        model.addAttribute("users", userService.getSnAndName());
        model.addAttribute("workloadTypes", Constants.getWorkloadType());
        model.addAttribute("courses", courseService.getAll());
        ExperimentWorkloadInfo info = new ExperimentWorkloadInfo();
        info.setWorkload(experimentWorkloadService.getByid(id));
        info.setItems(experimentWorkloadService.getItems(id));
        model.addAttribute("info", info);
        return "admin/experiment_workload_update";
    }

    @RequestMapping("update")
    public String update(ExperimentWorkloadInfo info, RedirectAttributes attr) {
        attr.addFlashAttribute("term", info.getWorkload().getTerm());
        attr.addFlashAttribute("workloadType", info.getWorkload().getWorkloadType());
        experimentWorkloadService.edit(info.getWorkload(), info.getItems());
        return "redirect:list";
    }


    @RequestMapping("/list")
    public String list(WorkloadForm workloadForm,
                       @ModelAttribute("term")String term,
                       @ModelAttribute("workloadType")String workloadType,
                       Model model){
        List<String> terms = experimentWorkloadService.getAllTerm();
        List<ExperimentWorkload> workloads;
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
                workloads = experimentWorkloadService.getByType(terms.get(0), null, null, null);
            } else {
                workloads = experimentWorkloadService.getByType(null, null, null, null);
            }
        } else {
            if (StringUtils.isBlank(workloadForm.getKeywords())) {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    workloads = experimentWorkloadService.getByType(workloadForm.getTerm(), null, null, null);
                } else {
                    workloads = experimentWorkloadService.getByType(workloadForm.getTerm(), workloadForm.getWorkloadType(), null, null);
                }
            } else {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    workloads = experimentWorkloadService.getByType(workloadForm.getTerm(), null, workloadForm.getType(), workloadForm.getKeywords());
                } else {
                    workloads = experimentWorkloadService.getByType(workloadForm.getTerm(), workloadForm.getWorkloadType(), workloadForm.getType(), workloadForm.getKeywords());
                }
            }

        }
        model.addAttribute("workloads", workloads);
        return "admin/experiment_workload_list";
    }

    @RequestMapping(value = "/remove",params = "id")
    public String remove(String id){
        experimentWorkloadService.remove(id);
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
        List<ExperimentWorkload> workloads;
        if ("所有".equals(workloadType)) {
            workloads = experimentWorkloadService.getByType(term, null, null, null);
        } else {
            workloads = experimentWorkloadService.getByType(term, workloadType, null, null);
        }
        //单元格表头
        String[] excelHeader = {"学期","类型","课程编号","课程名称","课程类别","实验学时","班级","总人数","班级数",
                                "实验工作量","准备工作量","总工作量","分配明细","扣除准备工作量"};
        //字段名称
        String[] fileds = {"term", "workloadType", "cno", "cname", "property", "expperiod", "classes", "stuNumbers", "classNumbers",
                           "labWorkload","preWorkload","totalWorkload","detail","deductPreWorkload"};
        //单元格宽度内容格式 14列
        int[] formats = {1, 1, 1, 1, 1, 4, 1, 4, 5, 5, 5, 5, 1, 5};
        //单元格宽度
        int[] widths = {256 * 14, 256 * 14, 256 * 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 256* 14, 600* 14, 256* 14};
        try {
            List<Map<String, Object>> excelData = new ArrayList<Map<String, Object>>();
            if (CollectionUtils.isNotEmpty(workloads)) {
                for (ExperimentWorkload workload : workloads) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("term", workload.getTerm());
                    map.put("workloadType", workload.getWorkloadType());
                    map.put("cno", workload.getCourse().getCno());
                    map.put("cname", workload.getCourse().getCname());
                    map.put("property", workload.getCourse().getProperty());
                    map.put("expperiod", workload.getCourse().getExpperiod());
                    map.put("classes", workload.getClasses());
                    map.put("stuNumbers", workload.getStuNumbers());
                    map.put("classNumbers", workload.getClassNumbers());
                    map.put("labWorkload", workload.getLabWorkload());
                    map.put("preWorkload", workload.getPreWorkload());
                    map.put("totalWorkload", workload.getTotalWorkload());
                    List<ExperimentWorkloadItem> items = workload.getItems();
                    String detail = "";
                    for (ExperimentWorkloadItem item : items) {
                        detail += item.getTeacher().getUserName() + ": " + item.getTeacherWorkload();
                        detail += " ";
                    }
                    map.put("detail",  detail);
                    map.put("deductPreWorkload", workload.getDeductPreWorkload());
                    excelData.add(map);
                }
            }
            String excelName = "实验工作量_" + term + "_" + workloadType;
            PoiUtil.exportFile(excelName, excelHeader, fileds, formats, widths, excelData, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
