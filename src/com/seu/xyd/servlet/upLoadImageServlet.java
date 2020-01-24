package com.seu.xyd.servlet;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;  
import java.util.Date;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;  
import org.apache.commons.fileupload.servlet.ServletFileUpload;  
import org.apache.commons.fileupload.util.Streams;

import java.util.regex.Matcher;  
import java.util.regex.Pattern;  

import org.apache.commons.fileupload.FileItemIterator;  
import org.apache.commons.fileupload.FileItemStream;  
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.seu.xyd.system.XYD;

/**
 * Servlet implementation class upLoadImageServlet
 */
@WebServlet("/upLoadImageServlet")
public class upLoadImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
    public upLoadImageServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print( "aaaa");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Document doc = DocumentHelper.createDocument();
        Element root = doc.addElement("response");
        Element result = root.addElement("result");

        response.setCharacterEncoding("utf8");
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
        
        String realDir = request.getSession().getServletContext().getRealPath("");  
        String contextpath = request.getContextPath();  
        String basePath = request.getScheme() + "://"  
        + request.getServerName() + ":" + request.getServerPort()  
        + contextpath + "/";  
    	System.out.print("bbbbbb");
        try {  
        String filePath = "uploadfiles";  
        String realPath = XYD.root + "sample_pics/"; 
       // String folderName = XYD.root + "sample_pics/"; 
        System.out.print(realPath);
        //判断路径是否存在，不存在则创建  
        File dir = new File(realPath);  
        if(!dir.isDirectory())  
            dir.mkdir();  
  
        if(ServletFileUpload.isMultipartContent(request))
        {  
  
            DiskFileItemFactory dff = new DiskFileItemFactory();  
            dff.setRepository(dir);  
            dff.setSizeThreshold(1024000);  
            ServletFileUpload sfu = new ServletFileUpload(dff);  
            FileItemIterator fii = null;  
            fii = sfu.getItemIterator(request); 
            System.out.println("-----"+(fii==null?"true":"false"));
            String title = "";   //图片标题  
            String url = "";    //图片地址  
            String fileName = "";  
            String state="SUCCESS";  
            String realFileName="";
            System.out.print("cccccccccc");
            while(fii.hasNext())
            {  
            	System.out.print("asdaswqewqeqw");
                FileItemStream fis = fii.next();  
  
                try{  
                    if(!fis.isFormField() && fis.getName().length()>0)
                    {  
                        fileName = fis.getName();  
                        Pattern reg=Pattern.compile("[.]jpg|png|jpeg|gif$");  
                        Matcher matcher=reg.matcher(fileName);  
                        if(!matcher.find()) {  
                            state = "文件类型不允许！";  
                            break;  
                        }  
                        realFileName = new Date().getTime()+fileName.substring(fileName.lastIndexOf("."),fileName.length());  
                        url = realPath+realFileName;  
  
                        BufferedInputStream in = new BufferedInputStream(fis.openStream());//获得文件输入流  
                        FileOutputStream a = new FileOutputStream(new File(url));  
                        BufferedOutputStream output = new BufferedOutputStream(a);  
                        Streams.copy(in, output, true);//开始把文件写到你指定的上传文件夹  
                    }else{  
                        String fname = fis.getFieldName();  
  
                        if(fname.indexOf("pictitle")!=-1){  
                            BufferedInputStream in = new BufferedInputStream(fis.openStream());  
                            byte c [] = new byte[10];  
                            int n = 0;  
                            while((n=in.read(c))!=-1){  
                                title = new String(c,0,n);  
                                break;  
                            }  
                        }  
                    }  
  
                }catch(Exception e){  
                    e.printStackTrace();  
                }  
            }  
            System.out.print("dddddddddddddddddddddddd");
            response.setStatus(200);  
            String retxt ="{\"url\":\"PicDownloadServlet?file_name="+realFileName+"\"}";  
            result.addAttribute("file_name", "model.csv");
            PrintWriter writer = response.getWriter(); 
            writer.write(retxt);
            writer.flush();
            writer.close();
        }  
        }catch(Exception ee) {  
            ee.printStackTrace();  
        } 
	}
		// TODO Auto-generated method stub
	}


