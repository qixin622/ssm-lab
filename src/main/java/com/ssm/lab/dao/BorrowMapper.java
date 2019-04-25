package com.ssm.lab.dao;

import com.ssm.lab.bean.Borrow;
import com.ssm.lab.bean.BorrowExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BorrowMapper {
    long countByExample(BorrowExample example);

    int deleteByExample(BorrowExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Borrow record);

    int insertSelective(Borrow record);

    List<Borrow> selectByExample(BorrowExample example);

    Borrow selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByExample(@Param("record") Borrow record, @Param("example") BorrowExample example);

    int updateByPrimaryKeySelective(Borrow record);

    int updateByPrimaryKey(Borrow record);

    List<Borrow> selectByType(@Param("type")String type, @Param("keywords")String keywords);
}