package com.ssm.lab.test;


import com.ssm.lab.bean.ExperimentWorkloadItem;
import com.ssm.lab.bean.PracticeWorkloadItem;
import com.ssm.lab.dao.ExperimentWorkloadItemMapper;
import com.ssm.lab.dao.PracticeWorkloadItemMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class PracticeWorkloadItemMapperTest {

	@Autowired
    PracticeWorkloadItemMapper mapper;



//    @Test
//    public void getAll() {
//        List<ExperimentWorkloadItem> items = mapper.selectByExample(null);
//        for (ExperimentWorkloadItem item : items) {
//            System.out.println(item.getTeacher().getUserName() + " " + item.getTeacherWorkload());
//        }
//    }
//
//    @Test
//    public void getById() {
//        ExperimentWorkloadItem item = mapper.selectByPrimaryKey(1);
//        System.out.println(item.getTeacher().getUserName() + " " + item.getTeacherWorkload());
//    }

    @Test
    public void getByExperimentWorkloadId() {
        List<PracticeWorkloadItem> items = mapper.selectByPracticeWorkloadId(1);
        for (PracticeWorkloadItem item : items) {
            System.out.println(item.getTeacher().getUserName() + " " + item.getTeacherWorkload());
        }
    }


}
