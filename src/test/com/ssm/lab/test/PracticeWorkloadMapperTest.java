package com.ssm.lab.test;


import com.ssm.lab.bean.ExperimentWorkload;
import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.bean.PracticeWorkload;
import com.ssm.lab.bean.PracticeWorkloadItem;
import com.ssm.lab.dao.ExperimentWorkloadMapper;
import com.ssm.lab.dao.PracticeWorkloadMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PracticeWorkloadMapperTest {

	@Autowired
    PracticeWorkloadMapper mapper;


	@Test
	public void getAllTerm(){
		List<String> allTerm = mapper.selectAllTerm();
        for (String s : allTerm) {
            System.out.println(s);
        }
    }


    @Test
    public void getAll() {
        List<PracticeWorkload> workloads = mapper.selectByExample(null);
        for (PracticeWorkload workload : workloads) {
            System.out.println(workload.getTerm() + " " + workload.getCourse().getCname());
            List<PracticeWorkloadItem> items = workload.getItems();
            for (PracticeWorkloadItem item : items) {
                System.out.println(item.getTeacherSn() + " " + item.getTeacher().getUserName());
            }
        }
    }

    @Test
    public void getById() {
        PracticeWorkload workload = mapper.selectByPrimaryKey(1);
        if (workload != null) {
            System.out.println(workload.getTerm() + " " + workload.getCourse().getCname());
        }
    }


}
