// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReportProcessor.java

package com.anirudh.core.delegates;

import com.anirudh.core.Report;
import java.util.ArrayList;

// Referenced classes of package com.anirudh.core.delegates:
//            ReportQueryDelegator

public class ReportProcessor
{

    public ReportProcessor()
    {
    }

    public void setReport(Report report)
    {
        this.report = report;
    }

    public void processReport()
        throws Exception
    {
        ReportQueryDelegator queryDelegator = new ReportQueryDelegator();
        queryDelegator.setReport(report);
        queryDelegator.buildQuery();
        queryDelegator.execQuery();
        reportCols = queryDelegator.getReportCols();
        reportData = queryDelegator.getReportData();
    }

    public ArrayList getReportCols()
    {
        return reportCols;
    }

    public void setReportCols(ArrayList reportCols)
    {
        this.reportCols = reportCols;
    }

    public ArrayList getReportData()
    {
        return reportData;
    }

    private Report report;
    private ArrayList reportCols;
    private ArrayList reportData;
}
