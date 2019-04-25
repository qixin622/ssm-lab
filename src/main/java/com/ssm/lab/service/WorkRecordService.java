package com.ssm.lab.service;

import com.ssm.lab.bean.WorkRecord;

import java.util.List;

public interface WorkRecordService {

    WorkRecord getByid(Integer id);

    List<WorkRecord> getAll();

    int remove(Integer id);

    int add(WorkRecord record);

    int edit(WorkRecord record);

    List<WorkRecord> getByType(String startTime, String endTime, String type, String keywords);

}
