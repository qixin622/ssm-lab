package com.ssm.lab.test;


import com.ssm.lab.dao.WorkloadVoMapper;
import com.ssm.lab.dto.WorkloadVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class WorkloadVoMapperTest {

	@Autowired
    WorkloadVoMapper workloadVoMapper;


	@Test
	public void getAllTerm(){
		List<String> allTerm = workloadVoMapper.selectAllTerm();
        for (String s : allTerm) {
            System.out.println(s);
        }
    }


    @Test
    public void getByCondition() {
        String term = "2018-2019-1";
        String workloadType = null;
        String type = "sn";
        String keywords = "19970016";
        List<WorkloadVo> workloads = workloadVoMapper.selectByExperimentCondition(term,workloadType,type,keywords);
        for (WorkloadVo workload : workloads) {
            System.out.println(workload.getTerm() + " " + workload.getWorkloadType() + " " +
                    workload.getCno() + " " + workload.getCname() + " " +
                    workload.getTeacherSn() + " " + workload.getUserName() + "" +
                    workload.getTeacherWorkload());
        }

    }



}
