// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QueryBuilder.java

package com.anirudh.core.sql;

import com.anirudh.core.ReportInputField;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class QueryBuilder
{

    public QueryBuilder()
    {
    }

    public ArrayList getInputField()
    {
        return inputFieldList;
    }

    public void setInputFieldList(ArrayList inputField)
    {
        inputFieldList = inputField;
    }

    public String getQueryString()
    {
        return queryString;
    }

    public void setQueryString(String queryString)
    {
        this.queryString = queryString;
    }

    public void buildQuery()
    {
        ReportInputField inputField = null;
        for(Iterator it = inputFieldList.iterator(); it.hasNext(); replaceToken(inputField.getName(), inputField.getValue()))
            inputField = (ReportInputField)it.next();

    }

    public void replaceToken(String token, String value)
    {
        System.out.println((new StringBuilder()).append(" Value=").append(value).toString());
        String pattern = (new StringBuilder()).append("#").append(token).toString();
        setQueryString(queryString.replace(pattern, value));
    }

    private ArrayList inputFieldList;
    private String queryString;
}
