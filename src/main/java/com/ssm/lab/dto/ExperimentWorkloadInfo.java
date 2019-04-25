package com.ssm.lab.dto;

import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadItem;

import java.util.List;

public class ExperimentWorkloadInfo {

    private ExperimentWorkload workload;
    private List<ExperimentWorkloadItem> items;

    public ExperimentWorkload getWorkload() {
        return workload;
    }

    public void setWorkload(ExperimentWorkload workload) {
        this.workload = workload;
    }

    public List<ExperimentWorkloadItem> getItems() {
        return items;
    }

    public void setItems(List<ExperimentWorkloadItem> items) {
        this.items = items;
    }
}
