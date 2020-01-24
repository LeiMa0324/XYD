package com.seu.xyd.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.seu.xyd.system.XYD;
import com.tn17.util.CommonUtil;

public class PicDownloadServlet extends HttpServlet {

    private static final long serialVersionUID = 616231795879494057L;

    @Override
    protected final void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	String folderName = XYD.root + "sample_pics/"; 
	String fileName = UIUtil.getParam(request, XYDWebParam.FILE_NAME);
	
	File file = new File(folderName, fileName);
	if(!file.isFile()) {
	    throw new ServletException("Illegal File:" + file.getName());
	}
	
	OutputStream out = null;
	FileInputStream in = null;
	
	try {
	    out = response.getOutputStream();
	    byte b[] = new byte[1024];
	    
	    if(fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
		response.setContentType("image/img");
	    } else {
		assert false;
	    }

	    response.setHeader("Content_Length", file.length()+"");

	    in = new FileInputStream(file);
	    int n = 0;
	    while ((n = in.read(b)) != -1) {
		out.write(b, 0, n);
	    }
	    out.flush();
	} finally {
	    CommonUtil.closeSafely(in);
	    CommonUtil.closeSafely(out);
	}
    }
    
    @Override
    protected final void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	doGet(request, response);
    }

}
