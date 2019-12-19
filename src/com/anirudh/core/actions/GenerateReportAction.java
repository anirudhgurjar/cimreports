// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GenerateReportAction.java

package com.anirudh.core.actions;

import com.anirudh.core.Report;
import com.anirudh.core.common.utils.WebUtils;
import com.anirudh.core.delegates.ReportInputDelegator;
import com.anirudh.core.delegates.ReportProcessor;
import com.anirudh.core.html.HtmlProcessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class GenerateReportAction extends HttpServlet
{

    public GenerateReportAction()
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
        String reportName = request.getParameter("reportName");
        ReportInputDelegator inputDelegator = new ReportInputDelegator();
        inputDelegator.setReportName(reportName);
        Report report = inputDelegator.mapReport();
        report = inputDelegator.mapInputsFromRequest(report, request);
        ReportProcessor reportProcessor = new ReportProcessor();
        reportProcessor.setReport(report);
        reportProcessor.processReport();
        java.util.ArrayList reportCols = reportProcessor.getReportCols();
        java.util.ArrayList reportData = reportProcessor.getReportData();
        request.getSession().setAttribute("reportTitle", report.getTitle());
        request.getSession().setAttribute("reportCols", reportCols);
        request.getSession().setAttribute("reportData", reportData);
        request.setAttribute("startPage", Integer.valueOf(0));
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShowReport.jsp");
        dispatcher.forward(request, response);
        out.close();
        break MISSING_BLOCK_LABEL_256;
        Exception ex;
        ex;
        ex.printStackTrace();
        out.print((new StringBuilder()).append("Error").append(HtmlProcessor.showError(ex.getMessage())).toString());
        out.close();
        break MISSING_BLOCK_LABEL_256;
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
