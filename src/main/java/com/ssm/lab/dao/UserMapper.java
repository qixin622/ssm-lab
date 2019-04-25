package com.ssm.lab.dao;

import com.ssm.lab.bean.User;
import com.ssm.lab.bean.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(String sn);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(String sn);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 按类型和关键字查找数据
     * @param type
     * @param keywords
     * @return
     */
    List<User> selectByType(@Param("type")String type,@Param("keywords")String keywords);

    /**
     * 批量新增用户记录
     *
     * @return
     */
    int insertUsersBatch(@Param("users") List<User> users);

    List<User> selectSnAndName(UserExample example);

}