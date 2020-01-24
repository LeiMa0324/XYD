package com.seu.xyd.servlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tn17.logic.LogicException;
import com.tn17.mysql.DBProcessException;

public abstract class XYDServlet  extends HttpServlet{

    private static final long serialVersionUID = 568745186218140871L;

    public void init() throws ServletException {
    }

    abstract String process(HttpServletRequest request) throws LogicException, DBProcessException, ServletException;

    @Override
    protected final void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //logger.warningLog("doGet occurs in servlet.");
        doPost(request, response);
    }

    @Override
    protected final void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf8");
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        
        try {
            String str = process(request);
            UIUtil.sendResponse(response, str);
        } catch (LogicException e) {
            //logger.debugLog(e.getMessage(), "servlet");
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage()); 
        } catch (DBProcessException e) {
                //logger.debugLog(e.getMessage(), "servlet");
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        } catch (ServletException e) {
            //logger.debugLog(e.getMessage(), "servlet");
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        }
    }
}
