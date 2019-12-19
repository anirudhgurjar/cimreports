// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReportInputDelegator.java

package com.anirudh.core.delegates;

import com.anirudh.core.*;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

public class ReportInputDelegator
{

    public ReportInputDelegator()
    {
    }

    public void setReportName(String reportName)
    {
        this.reportName = reportName;
    }

    public Report mapReport()
        throws Exception
    {
        CoreConfig coreConfig = new CoreConfig();
        HashMap reportMap = coreConfig.initConfig();
        Report report = (Report)reportMap.get(reportName);
        if(report == null)
            throw new Exception((new StringBuilder()).append("Report ").append(reportName).append(" not loaded").toString());
        else
            return report;
    }

    public Report mapInputsFromRequest(Report report, HttpServletRequest request)
        throws Exception
    {
        List requestParameterNames = Collections.list(request.getParameterNames());
        java.util.Enumeration e = request.getParameterNames();
        ArrayList inputFieldList = report.getInputFields();
        for(Iterator i$ = requestParameterNames.iterator(); i$.hasNext();)
        {
            String inputParamFromReq = (String)i$.next();
            Iterator it = inputFieldList.iterator();
            while(it.hasNext()) 
            {
                ReportInputField inputField = (ReportInputField)it.next();
                if(inputField.getName().equalsIgnoreCase(inputParamFromReq))
                    inputField.setValue(request.getParameter(inputParamFromReq));
            }
        }

        return report;
    }

    private String reportName;
}
