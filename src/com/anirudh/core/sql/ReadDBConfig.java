// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReadDBConfig.java

package com.anirudh.core.sql;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadDBConfig
{

    public ReadDBConfig()
    {
        loadConfig(true);
    }

    public void loadConfig(boolean reload)
    {
        if(!reload)
            return;
        Properties dbProps = new Properties();
        try
        {
            dbProps.load(getClass().getResourceAsStream("db_con.properties"));
            serverName = dbProps.getProperty("serverName");
            portNumber = dbProps.getProperty("portNumber");
            sid = dbProps.getProperty("sid");
            username = dbProps.getProperty("username");
            password = dbProps.getProperty("password");
            System.out.println(dbProps.getProperty("dbUser"));
        }
        catch(IOException ex)
        {
            Logger.getLogger(com/anirudh/core/sql/ReadDBConfig.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toString()
    {
        System.out.println(username);
        System.out.println(password);
        System.out.println(serverName);
        System.out.println(sid);
        System.out.println(portNumber);
        return super.toString();
    }

    public static void main(String args[])
    {
        ReadDBConfig readDBConfig = new ReadDBConfig();
        System.out.print(readDBConfig.toString());
    }

    public String getServerName()
    {
        return serverName;
    }

    public String getPortNumber()
    {
        return portNumber;
    }

    public String getSid()
    {
        return sid;
    }

    public String getUsername()
    {
        return username;
    }

    public String getPassword()
    {
        return password;
    }

    private String serverName;
    private String portNumber;
    private String sid;
    private String username;
    private String password;
}
