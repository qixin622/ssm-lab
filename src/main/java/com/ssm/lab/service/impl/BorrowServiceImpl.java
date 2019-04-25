package com.ssm.lab.service.impl;

import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.BorrowExample;
import com.ssm.lab.dao.BorrowMapper;
import com.ssm.lab.service.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service("borrowService")
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowMapper borrowMapper;


    @Override
    public Borrow getByid(Integer id) {
        return borrowMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Borrow> getAll() {
        BorrowExample example = new BorrowExample();
        example.setOrderByClause("id desc");
        return borrowMapper.selectByExample(example);
    }

    public int remove(String id) {
        List<String> stringList = Arrays.asList(id.split(","));
        List<Integer> integerList = new ArrayList<>();
        for (String str : stringList) {
            integerList.add(Integer.parseInt(str));
        }

        BorrowExample example = new BorrowExample();
        example.or().andIdIn(integerList);
        return borrowMapper.deleteByExample(example);
    }

    @Override
    public int add(Borrow borrow) {
        borrow.setBorrowTime(new Date());
        String[] split = borrow.getBorrowSn().split(" ");
        borrow.setBorrowSn(split[0]);
        return borrowMapper.insertSelective(borrow);
    }

    @Override
    public int edit(Borrow borrow) {
        String[] split = borrow.getBorrowSn().split(" ");
        borrow.setBorrowSn(split[0]);
        return borrowMapper.updateByPrimaryKeySelective(borrow);
    }

    @Override
    public int editBack(Borrow borrow) {
        //更新归还时间和状态
        borrow.setReturnTime(new Date());
        borrow.setFlag("1");
        return borrowMapper.updateByPrimaryKeySelective(borrow);
    }

    @Override
    public List<Borrow> getByType(String type, String keywords) {
        return borrowMapper.selectByType(type, keywords);
    }

}
