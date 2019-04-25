package com.ssm.lab.dto;

import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.bean.PracticeWorkloadItem;

import java.util.List;

public class PracticeWorkloadInfo {

    private PracticeWorkload workload;
    private List<PracticeWorkloadItem> items;

    public PracticeWorkload getWorkload() {
        return workload;
    }

    public void setWorkload(PracticeWorkload workload) {
        this.workload = workload;
    }

    public List<PracticeWorkloadItem> getItems() {
        return items;
    }

    public void setItems(List<PracticeWorkloadItem> items) {
        this.items = items;
    }
}
