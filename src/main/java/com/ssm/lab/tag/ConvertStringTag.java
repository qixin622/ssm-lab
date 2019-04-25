package com.ssm.lab.tag;

import com.ssm.lab.utils.StringUtil;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 将长文本标题截止指定长度
 * @author Administrator
 */
public class ConvertStringTag extends SimpleTagSupport {

    private String content;
    private int size;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }


    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(StringUtil.convertString(StringUtil.convertHtmlToString(content), size));

    }

}
