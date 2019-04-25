package com.ssm.lab.service;

import com.ssm.lab.bean.LabInfo;
import com.ssm.lab.bean.LabInfo;

import java.util.List;

public interface LabInfoService {

    LabInfo getByid(Integer id);

    List<LabInfo> getAll();

    int remove(Integer id);

    int add(LabInfo labInfo);

    int edit(LabInfo labInfo);

}
