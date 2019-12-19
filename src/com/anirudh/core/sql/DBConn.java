// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DBConn.java

package com.anirudh.core.sql;

import java.sql.*;

// Referenced classes of package com.anirudh.core.sql:
//            ReadDBConfig

public class DBConn
{

    public DBConn()
    {
    }

    public static void initConn()
    {
        try
        {
            String driverName = "oracle.jdbc.driver.OracleDriver";
            Class.forName(driverName);
            ReadDBConfig dBConfig = new ReadDBConfig();
            String serverName = dBConfig.getServerName();
            String portNumber = dBConfig.getPortNumber();
            String sid = dBConfig.getSid();
            String url = (new StringBuilder()).append("jdbc:oracle:thin:@").append(serverName).append(":").append(portNumber).append(":").append(sid).toString();
            String username = dBConfig.getUsername();
            String password = dBConfig.getPassword();
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
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static Connection getDbConnection()
    {
        return connection;
    }

    private static Connection connection = null;

}
