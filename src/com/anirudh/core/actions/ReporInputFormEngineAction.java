// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReporInputFormEngineAction.java

package com.anirudh.core.actions;

import com.anirudh.core.common.utils.WebUtils;
import com.anirudh.core.delegates.ReportInputDelegator;
import com.anirudh.core.html.HtmlProcessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ReporInputFormEngineAction extends HttpServlet
{

    public ReporInputFormEngineAction()
    {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out;
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        if(WebUtils.isValidSession(request.getSession()))
            break MISSING_BLOCK_LABEL_39;
        out.print(HtmlProcessor.sessionTimeOut());
        out.close();
        return;
        out.println("<html>");
        out.println("<head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div align=center>");
        String reportName = request.getParameter("reportName");
        ReportInputDelegator inputDelegator = new ReportInputDelegator();
        inputDelegator.setReportName(reportName);
        com.anirudh.core.Report matchReport = inputDelegator.mapReport();
        out.print(HtmlProcessor.generateHHtmlInputForm(matchReport));
        out.println("</body>");
        out.println("</html>");
        out.close();
        break MISSING_BLOCK_LABEL_160;
        Exception e;
        e;
        out.print(HtmlProcessor.showError(e.getMessage()));
        out.close();
        break MISSING_BLOCK_LABEL_160;
        Exception exception;
        exception;
        out.close();
        throw exception;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        processRequest(request, response);
    }

    public String getServletInfo()
    {
        return "Short description";
    }
}
