package com.seu.xyd.servlet;

import javax.servlet.ServletException;

public class XYDSessionTimeout extends ServletException {

    private static final long serialVersionUID = 4091805260113582484L;
    public XYDSessionTimeout() {
        super("登录超时，请重新登录");
    }
}
