package com.ssm.lab.controller;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.common.Constants;
import com.ssm.lab.dto.WorkloadForm;
import com.ssm.lab.dto.WorkloadVo;
import com.ssm.lab.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller("portalWorkloadController")
public class PortalWorkloadController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private LabInfoService labInfoService;
    @Autowired
    private WorkloadVoService workloadVoService;
    @Autowired
    private ExperimentWorkloadService experimentWorkloadService;
    @Autowired
    private PracticeWorkloadService practiceWorkloadService;

    @RequestMapping("/experiment/workload/list")
    public String experiment_workload_list(@RequestParam(value = "term", required = false) String term,
                                           @RequestParam(value = "workloadType", required = false) String workloadType,
                                           @RequestParam(value = "type", required = false) String type,
                                           @RequestParam(value = "keywords", required = false)String keywords,
                                           Model model){
        List<String> terms = experimentWorkloadService.getAllTerm();
        List<ExperimentWorkload> workloads;

        WorkloadForm workloadForm = new WorkloadForm();
        workloadForm.setTerm(term);
        workloadForm.setWorkloadType(workloadType);
        workloadForm.setType(type);
        workloadForm.setKeywords(keywords);

        List<String> workloadTypes = Constants.getWorkloadType();
        workloadTypes.add(0,"所有");

        model.addAttribute("workloadForm", workloadForm);
        model.addAttribute("workloadTypes", workloadTypes);
        model.addAttribute("terms", terms);
        if (StringUtils.isBlank(term) && StringUtils.isBlank(workloadType) && StringUtils.isBlank(type) && StringUtils.isBlank(keywords)) {
            if (terms.size() > 0) {
                //如果是首次访问工作量列表，则显示最新一学期工作量列表
                workloads = experimentWorkloadService.getByType(terms.get(0), null, null, null);
            } else {
                workloads = experimentWorkloadService.getByType(null, null, null, null);
            }
        } else {
            if (StringUtils.isBlank(keywords)) {
                if ("所有".equals(workloadType)) {
                    workloads = experimentWorkloadService.getByType(term, null, null, null);
                } else {
                    workloads = experimentWorkloadService.getByType(term, workloadType, null, null);
                }
            } else {
                if ("所有".equals(workloadType)) {
                    workloads = experimentWorkloadService.getByType(term, null, type, keywords.trim());
                } else {
                    workloads = experimentWorkloadService.getByType(term, workloadType, type, keywords.trim());
                }
            }

        }
        model.addAttribute("workloads", workloads);
        menuList(model);
        return "portal/experiment_workload_list";
    }

    @RequestMapping("/practice/workload/list")
    public String practice_workload_list(@RequestParam(value = "term", required = false) String term,
                                         @RequestParam(value = "workloadType", required = false) String workloadType,
                                         @RequestParam(value = "type", required = false) String type,
                                         @RequestParam(value = "keywords", required = false)String keywords,
                                         Model model){
        List<String> terms = practiceWorkloadService.getAllTerm();
        List<PracticeWorkload> workloads;

        WorkloadForm workloadForm = new WorkloadForm();
        workloadForm.setTerm(term);
        workloadForm.setWorkloadType(workloadType);
        workloadForm.setType(type);
        workloadForm.setKeywords(keywords);

        List<String> workloadTypes = Constants.getWorkloadType();
        workloadTypes.add(0,"所有");

        model.addAttribute("workloadForm", workloadForm);
        model.addAttribute("workloadTypes", workloadTypes);
        model.addAttribute("terms", terms);
        if (StringUtils.isBlank(term) && StringUtils.isBlank(workloadType) && StringUtils.isBlank(type) && StringUtils.isBlank(keywords)) {
            if (terms.size() > 0) {
                //如果是首次访问工作量列表，则显示最新一学期工作量列表
                workloads = practiceWorkloadService.getByType(terms.get(0), null, null, null);
            } else {
                workloads = practiceWorkloadService.getByType(null, null, null, null);
            }
        } else {
            if (StringUtils.isBlank(keywords)) {
                if ("所有".equals(workloadType)) {
                    workloads = practiceWorkloadService.getByType(term, null, null, null);
                } else {
                    workloads = practiceWorkloadService.getByType(term, workloadType, null, null);
                }
            } else {
                if ("所有".equals(workloadType)) {
                    workloads = practiceWorkloadService.getByType(term, null, type, keywords.trim());
                } else {
                    workloads = practiceWorkloadService.getByType(term, workloadType, type, keywords.trim());
                }
            }

        }
        model.addAttribute("workloads", workloads);
        menuList(model);
        return "portal/practice_workload_list";
    }

    @RequestMapping("/summary/workload/list")
    public String summary_workload_list(WorkloadForm workloadForm, Model model){
        List<String> terms = workloadVoService.getAllTerm();
        List<WorkloadVo> experimentWorkloads;
        List<WorkloadVo> practiceWorkloads;

        List<String> workloadTypes = Constants.getWorkloadType();
        workloadTypes.add(0,"所有");

        model.addAttribute("workloadForm", workloadForm);
        model.addAttribute("workloadTypes", workloadTypes);
        model.addAttribute("terms", terms);
        if (StringUtils.isBlank(workloadForm.getTerm()) && StringUtils.isBlank(workloadForm.getWorkloadType()) && StringUtils.isBlank(workloadForm.getType()) && StringUtils.isBlank(workloadForm.getKeywords())) {
            if (terms.size() > 0) {
                //如果是首次访问工作量列表，则显示最新一学期工作量列表
                experimentWorkloads = workloadVoService.getByExperimentCondition(terms.get(0), null, null, null);
                practiceWorkloads = workloadVoService.getByPracticeCondition(terms.get(0), null, null, null);
            } else {
                experimentWorkloads = workloadVoService.getByExperimentCondition(null, null, null, null);
                practiceWorkloads = workloadVoService.getByPracticeCondition(null, null, null, null);
            }
        } else {
            if (StringUtils.isBlank(workloadForm.getKeywords())) {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    experimentWorkloads = workloadVoService.getByExperimentCondition(workloadForm.getTerm(), null, null, null);
                    practiceWorkloads = workloadVoService.getByPracticeCondition(workloadForm.getTerm(), null, null, null);
                } else {
                    experimentWorkloads = workloadVoService.getByExperimentCondition(workloadForm.getTerm(), workloadForm.getWorkloadType(), null, null);
                    practiceWorkloads = workloadVoService.getByPracticeCondition(workloadForm.getTerm(), workloadForm.getWorkloadType(), null, null);
                }
            } else {
                if ("所有".equals(workloadForm.getWorkloadType())) {
                    experimentWorkloads = workloadVoService.getByExperimentCondition(workloadForm.getTerm(), null, workloadForm.getType(), workloadForm.getKeywords().trim());
                    practiceWorkloads = workloadVoService.getByPracticeCondition(workloadForm.getTerm(), null, workloadForm.getType(), workloadForm.getKeywords().trim());
                } else {
                    experimentWorkloads = workloadVoService.getByExperimentCondition(workloadForm.getTerm(), workloadForm.getWorkloadType(), workloadForm.getType(), workloadForm.getKeywords().trim());
                    practiceWorkloads = workloadVoService.getByPracticeCondition(workloadForm.getTerm(), workloadForm.getWorkloadType(), workloadForm.getType(), workloadForm.getKeywords().trim());
                }
            }

        }
        model.addAttribute("experimentWorkloads", experimentWorkloads);
        model.addAttribute("practiceWorkloads", practiceWorkloads);
        menuList(model);
        return "portal/summary_workload_list";
    }

    //菜单实验室信息及文章资料分类菜单列表
    private void menuList(Model model) {
        model.addAttribute("categoryList", categoryService.getAll());
        model.addAttribute("labInfoList", labInfoService.getAll());
    }
}
