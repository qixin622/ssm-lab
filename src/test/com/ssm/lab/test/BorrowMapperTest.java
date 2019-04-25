package com.ssm.lab.test;


import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.BorrowExample;
import com.ssm.lab.dao.BorrowMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class BorrowMapperTest {
	
	@Autowired
    BorrowMapper borrowMapper;


	@Test
	public void getById(){
		Borrow borrow = borrowMapper.selectByPrimaryKey(1);
		System.out.println(borrow.getName());
		System.out.println("借用人:" + borrow.getBorrower().getUserName());
		System.out.println("借用经手人人:" + borrow.getBorrowHandler().getUserName());
		System.out.println("归还经手人:" + borrow.getReturnHanlder().getUserName());
	}

    @Test
    public void getAll() {
        BorrowExample example = new BorrowExample();
        example.or().andFlagEqualTo("1");
        List<Borrow> borrowList = borrowMapper.selectByExample(example);
        System.out.println(borrowList.size());
        for (Borrow borrow : borrowList) {
            System.out.println(borrow.getName());
            System.out.println("借用人:" + borrow.getBorrower().getUserName());
            System.out.println("借用经手人人:" + borrow.getBorrowHandler().getUserName());
            if(borrow.getReturnHanlder()!=null)
                System.out.println("归还经手人:" + borrow.getReturnHanlder().getUserName());
        }
    }

}
