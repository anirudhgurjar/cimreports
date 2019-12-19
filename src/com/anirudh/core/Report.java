// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Report.java

package com.anirudh.core;

import java.util.ArrayList;

public class Report
{

    public Report()
    {
        inputFields = new ArrayList();
    }

    public String getSqlString()
    {
        return sqlString;
    }

    public void setSqlString(String sqlString)
    {
        this.sqlString = sqlString;
    }

    public ArrayList getInputFields()
    {
        return inputFields;
    }

    public void setInputFields(ArrayList inputFields)
    {
        this.inputFields = inputFields;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTreeNodeCategory()
    {
        return treeNodeCategory;
    }

    public void setTreeNodeCategory(String treeNodeCategory)
    {
        this.treeNodeCategory = treeNodeCategory;
    }

    private String sqlString;
    private ArrayList inputFields;
    private String name;
    private String title;
    private String treeNodeCategory;
}
