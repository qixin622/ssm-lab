package com.ssm.lab.service.impl;

import com.ssm.lab.bean.User;
import com.ssm.lab.bean.UserExample;
import com.ssm.lab.common.Constants;
import com.ssm.lab.utils.DateTimeUtil;
import com.ssm.lab.utils.MD5Util;
import com.ssm.lab.utils.PoiUtil;
import com.ssm.lab.dao.UserMapper;
import com.ssm.lab.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String sn, String password) {
        User user = userMapper.selectByPrimaryKey(sn);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public User getBySn(String sn) {
        return userMapper.selectByPrimaryKey(sn);
    }

    @Override
    public List<User> getAll() {
        return userMapper.selectByExample(null);
    }

    @Override
    public List<User> getSnAndName() {
        return userMapper.selectSnAndName(null);
    }

    @Override
    public List<User> getByType(String type, String keywords) {
        return userMapper.selectByType(type, keywords);
    }

    @Override
    public int remove(String sn) {
        List<String> result = Arrays.asList(sn.split(","));
        UserExample example = new UserExample();
        example.or().andSnIn(result);
        return userMapper.deleteByExample(example);
    }

    @Override
    public int add(User user) {
        user.setPassword(MD5Util.MD5EncodeUtf8(Constants.DEFAULT_PASSWORD));
        userMapper.insertSelective(user);
        return 0;
    }

    @Override
    public int edit(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int importUsersByExcelFile(File file) {
        XSSFSheet xssfSheet = null;
        try {
            //读取file对象并转换为XSSFSheet类型对象进行处理
            xssfSheet = PoiUtil.getXSSFSheet(file);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        List<User> users = new ArrayList<>();
        //第一行是表头因此默认从第二行读取
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            //按行读取数据
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null) {
                //实体转换
                User user = convertXSSFRowToUser(xssfRow);
                //用户验证 用户已存在不进行insert操作
                if (getBySn(user.getSn()) == null) {
                    users.add(user);
                }
            }
        }
        //判空
        if (!CollectionUtils.isEmpty(users)) {
            //users用户列表不为空则执行批量添加sql
            return userMapper.insertUsersBatch(users);
        }
        return 0;
    }

    /**
     * 方法抽取
     * 将解析的行转换为User对象
     *
     * @param xssfRow
     * @return
     */
    private User convertXSSFRowToUser(XSSFRow xssfRow) {
        User user = new User();
        //用户名
        XSSFCell sn = xssfRow.getCell(0);
        //姓名
        XSSFCell userName = xssfRow.getCell(1);
        //密码
        XSSFCell password = xssfRow.getCell(2);
        //性别
        XSSFCell sex = xssfRow.getCell(3);
        //出生日期
        XSSFCell birthday = xssfRow.getCell(4);
        //职称
        XSSFCell technical = xssfRow.getCell(5);
        //教师类别
        XSSFCell type = xssfRow.getCell(6);
        //电话号码
        XSSFCell phone = xssfRow.getCell(7);
        //电子邮件
        XSSFCell email = xssfRow.getCell(8);
        //照片
        XSSFCell photo = xssfRow.getCell(9);
        // 角色
        XSSFCell role = xssfRow.getCell(10);
        //设置User属性
        user.setSn(PoiUtil.getValue(sn).trim());
        user.setUserName(PoiUtil.getValue(userName).trim());
        user.setPassword(PoiUtil.getValue(password).trim());
        user.setSex(PoiUtil.getValue(sex));
        user.setBirthday(DateTimeUtil.strToDate(PoiUtil.getValue(birthday).trim()));
        user.setTechnical(PoiUtil.getValue(technical).trim());
        user.setType(PoiUtil.getValue(type).trim());
        user.setPhone(PoiUtil.getValue(phone).trim());
        user.setEmail(PoiUtil.getValue(email).trim());
        user.setPhoto(PoiUtil.getValue(photo).trim());
        if (StringUtils.equals(PoiUtil.getValue(role), "系统管理员")) {
            user.setRole("1");
        } else {
            user.setRole("0");
        }

        return user;
    }

}
