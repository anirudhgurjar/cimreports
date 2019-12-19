// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReportQueryDelegator.java

package com.anirudh.core.delegates;

import com.anirudh.core.Report;
import com.anirudh.core.sql.DBConn;
import com.anirudh.core.sql.QueryBuilder;
import java.io.PrintStream;
import java.sql.*;
import java.util.ArrayList;

public class ReportQueryDelegator
{

    public ReportQueryDelegator()
    {
    }

    public void setReport(Report rpt)
    {
        report = rpt;
    }

    public void buildQuery()
    {
        QueryBuilder queryBuilder = new QueryBuilder();
        queryBuilder.setInputFieldList(report.getInputFields());
        queryBuilder.setQueryString(report.getSqlString());
        queryBuilder.buildQuery();
        report.setSqlString(queryBuilder.getQueryString());
    }

    public void execQuery()
        throws SQLException
    {
        DBConn.initConn();
        Connection dbConnection = DBConn.getDbConnection();
        if(dbConnection == null)
        {
            throw new SQLException("Error in getting Exception");
        } else
        {
            Statement pstmt = dbConnection.createStatement();
            ResultSet resultSet = pstmt.executeQuery(report.getSqlString());
            System.out.println((new StringBuilder()).append("quwery Executed=").append(report.getSqlString()).toString());
            System.out.println((new StringBuilder()).append("Rows fetched:").append(resultSet.getRow()).toString());
            populateReportData(resultSet);
            return;
        }
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

    public void setReportData(ArrayList reportData)
    {
        this.reportData = reportData;
    }

    private void populateReportData(ResultSet resultSet)
        throws SQLException
    {
        ResultSetMetaData metaData = resultSet.getMetaData();
        reportCols = new ArrayList();
        int noOfReportCols = metaData.getColumnCount();
        for(int i = 1; i <= noOfReportCols; i++)
            reportCols.add(new String(metaData.getColumnLabel(i)));

        populateReportData(resultSet, noOfReportCols);
    }

    private void populateReportData(ResultSet resultSet, int noOfReportCols)
        throws SQLException
    {
        reportData = new ArrayList();
        String colsNames[] = (String[])(String[])reportCols.toArray(new String[noOfReportCols]);
        for(int totalRows = 0; resultSet.next(); totalRows++)
        {
            String rowData[] = new String[noOfReportCols];
            for(int i = 0; i < colsNames.length; i++)
                rowData[i] = resultSet.getString(colsNames[i]);

            reportData.add(rowData);
        }

    }

    private Report report;
    private ArrayList reportCols;
    private ArrayList reportData;
}
