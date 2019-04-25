package com.ssm.lab.service;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.dto.ExperimentWorkloadInfo;

import java.util.List;

public interface ExperimentWorkloadService {

    ExperimentWorkload getByid(Integer id);

    List<ExperimentWorkload> getAll();

    int remove(String id);

    int add(ExperimentWorkload workload);

    void save(ExperimentWorkload workload, List<ExperimentWorkloadItem> items);

    void edit(ExperimentWorkload workload, List<ExperimentWorkloadItem> items);

    List<String> getAllTerm();

    List<ExperimentWorkloadItem> getItems(Integer id);

    List<ExperimentWorkload> getByType(String term, String workloadType, String type, String keywords);

}
