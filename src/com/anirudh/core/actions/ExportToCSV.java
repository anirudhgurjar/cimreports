// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ExportToCSV.java

package com.anirudh.core.actions;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ExportToCSV extends HttpServlet
{

    public ExportToCSV()
    {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out;
        response.setContentType("text/csv");
        response.setHeader("Content-Disposition", "attachment; filename=Export.csv");
        out = response.getWriter();
        ArrayList colHeaders = (ArrayList)request.getSession().getAttribute("reportCols");
        ArrayList colData = (ArrayList)request.getSession().getAttribute("reportData");
        int totalCols = colHeaders.size();
        StringBuffer colBuffer = new StringBuffer();
        for(int i = 0; i < totalCols; i++)
            colBuffer.append((String)colHeaders.get(i)).append(",");

        colBuffer.deleteCharAt(colBuffer.length() - 1);
        out.print(colBuffer.toString());
        colBuffer = new StringBuffer();
        String rowData[] = null;
        for(int idx = 0; idx < colData.size() - 1; idx++)
        {
            colBuffer.append("\n");
            rowData = (String[])(String[])colData.get(idx);
            for(int i = 0; i < totalCols; i++)
                colBuffer.append(String.valueOf(rowData[i])).append(",");

            colBuffer.deleteCharAt(colBuffer.length() - 1);
        }

        out.print(colBuffer.toString());
        out.close();
        break MISSING_BLOCK_LABEL_265;
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
