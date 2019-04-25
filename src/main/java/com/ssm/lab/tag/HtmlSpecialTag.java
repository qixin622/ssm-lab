package com.ssm.lab.tag;

import com.ssm.lab.utils.StringUtil;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
/**
 *
 * @author Administrator
 */
public class HtmlSpecialTag extends SimpleTagSupport {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.print(StringUtil.convertHtmlToString(content));

    }

}
