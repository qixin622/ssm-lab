package com.ssm.lab.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {

    public static final int RESULT_CODE_SUCCESS = 200;  // 成功处理请求
    public static final int RESULT_CODE_BAD_REQUEST = 412;  // 请求错误
    public static final int RESULT_CODE_NOT_LOGIN = 402;  // 未登录
    public static final int RESULT_CODE_PARAM_ERROR = 406;  // 传参错误
    public static final int RESULT_CODE_SERVER_ERROR = 500;  // 服务器错误

    public static final String OUTLINE_PATH = "userfiles/outline";
    public static final String LABBOOK_PATH = "userfiles/labbook";
    public static final String CAROUSEL_PATH = "userfiles/carousel";
    public static final String AVATARS_PATH = "userfiles/avatars";

    public static final String DEFAULT_PASSWORD = "111111";


    //职称
    public static List<String> getTechnicals() {
        List<String> list = new ArrayList<String>();
        list.add("教授");
        list.add("副教授");
        list.add("讲师");
        list.add("助教");
        list.add("高级实验师");
        list.add("实验师");
        list.add("助理实验师");
        list.add("科长");
        list.add("副科长");
        list.add("处长");
        list.add("副处长");
        list.add("办事员");
        return list;
    }

    //教师类别
    public static List<String> getTypes() {
        List<String> list = new ArrayList<String>();
        list.add("理论教师");
        list.add("实验教师");
        list.add("管理人员");
        return list;
    }

    //头像
    public static List<String> getImgUrls() {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            list.add(i+".jpg");
        }
        return list;
    }


    //最高学历
    public static List<String> getQualification() {
        List<String> list = new ArrayList<String>();
        list.add("博士");
        list.add("硕士");
        list.add("本科");
        list.add("专科");
        list.add("中专");
        return list;
    }

    //最高学历
    public static List<String> getProperties() {
        List<String> list = new ArrayList<String>();
        list.add("公共基础课");
        list.add("学科基础课");
        list.add("专业基础课");
        list.add("专业方向课");
        return list;
    }

    //实验项目要求
    public static List<String> getExpdemand() {
        List<String> list = new ArrayList<String>();
        list.add("必做");
        list.add("选做");
        return list;
    }

    //实验项目类型
    public static List<String> getExptype() {
        List<String> list = new ArrayList<String>();
        list.add("演示性");
        list.add("验证性");
        list.add("综合性");
        list.add("设计性");
        list.add("创新性");
        return list;
    }

    //实验工作量类型
    public static List<String> getWorkloadType() {
        List<String> list = new ArrayList<String>();
        list.add("本部");
        list.add("科院");
        return list;
    }

    //实践类型
    public static List<String> getPraticeType() {
        List<String> list = new ArrayList<String>();
        list.add("课程设计");
        list.add("校内实习");
        list.add("校外实习");
        return list;
    }

    //实践工作量性质
    public static List<String> getWorkloadProperty() {
        List<String> list = new ArrayList<String>();
        list.add("正常");
        list.add("插班重修");
        return list;
    }
}
