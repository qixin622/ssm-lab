package com.ssm.lab.test;


import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.dao.ExperimentWorkloadMapper;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class ExperimentWorkloadMapperTest {

	@Autowired
    ExperimentWorkloadMapper mapper;


	@Test
	public void getAllTerm(){
		List<String> allTerm = mapper.selectAllTerm();
        for (String s : allTerm) {
            System.out.println(s);
        }
    }

    @Test
    public void getByType() {
	    String term = "2017-2018-1";
	    String workloadType = null;
	    String type = "cname";
	    String keywords = "计算机网络";
        List<ExperimentWorkload> workloads = mapper.selectByType(term, workloadType, type, keywords);
        for (ExperimentWorkload workload : workloads) {
            System.out.println(workload.getTerm() + " " + workload.getCourse().getCname());
            List<ExperimentWorkloadItem> items = workload.getItems();
            for (ExperimentWorkloadItem item : items) {
                System.out.println(item.getTeacherSn() + " " + item.getTeacher().getUserName());
            }
        }
    }

    @Test
    public void getAll() {
        List<ExperimentWorkload> workloads = mapper.selectByExample(null);
        for (ExperimentWorkload workload : workloads) {
            System.out.println(workload.getTerm() + " " + workload.getCourse().getCname());
            List<ExperimentWorkloadItem> items = workload.getItems();
            for (ExperimentWorkloadItem item : items) {
                System.out.println(item.getTeacherSn() + " " + item.getTeacher().getUserName());
            }
        }
    }

    @Test
    public void getById() {
	    ExperimentWorkload workload = mapper.selectByPrimaryKey(1);
        if (workload != null) {
            System.out.println(workload.getTerm() + " " + workload.getCourse().getCname());
        }
    }


}
