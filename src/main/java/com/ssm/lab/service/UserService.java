package com.ssm.lab.service;

import com.ssm.lab.bean.User;

import java.io.File;
import java.util.List;

public interface UserService {
    User login(String sn, String password);

    User getBySn(String sn);

    List<User> getAll();

    List<User> getSnAndName();

    List<User> getByType(String type,String keywords);

    int remove(String sn);

    int add(User user);

    int edit(User user);

    /**
     * 根据excel导入用户记录
     *
     * @param file
     * @return
     */
    int importUsersByExcelFile(File file);
}
