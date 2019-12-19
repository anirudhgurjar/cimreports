// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DBConfig.java

package com.anirudh.core;

import java.sql.*;

public class DBConfig
{

    public DBConfig()
    {
    }

    public static void initConn()
    {
        try
        {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            String serverName = "illin004";
            String portNumber = "1521";
            String sid = "RBTCRM78";
            String url = (new StringBuilder()).append("jdbc:oracle:thin:@").append(serverName).append(":").append(portNumber).append(":").append(sid).toString();
            String username = "sa";
            String password = "sa";
            connection = DriverManager.getConnection(url, username, password);
        }
        catch(ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getDbConnection()
    {
        return connection;
    }

    static Connection connection = null;

    static 
    {
        initConn();
    }
}
