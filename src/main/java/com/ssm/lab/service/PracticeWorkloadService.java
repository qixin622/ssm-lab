package com.ssm.lab.service;

import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.bean.PracticeWorkloadItem;

import java.util.List;

public interface PracticeWorkloadService {

    PracticeWorkload getByid(Integer id);

    List<PracticeWorkload> getAll();

    int remove(String id);

    int add(PracticeWorkload workload);

    void save(PracticeWorkload workload, List<PracticeWorkloadItem> items);

    void edit(PracticeWorkload workload, List<PracticeWorkloadItem> items);

    List<String> getAllTerm();

    List<PracticeWorkloadItem> getItems(Integer id);

    List<PracticeWorkload> getByType(String term, String workloadType, String type, String keywords);

}
