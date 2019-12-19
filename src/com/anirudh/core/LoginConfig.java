// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginConfig.java

package com.anirudh.core;

import java.io.*;
import java.util.ArrayList;

public class LoginConfig
{

    public LoginConfig()
        throws Exception
    {
        listOfUsers = new ArrayList();
        loadUserDetails();
    }

    private void loadUserDetails()
        throws IOException, Exception
    {
        try
        {
            DataInputStream din = new DataInputStream(getClass().getClassLoader().getResourceAsStream("./Config_"));
            StringBuffer loginCrd = null;
            loginCrd = new StringBuffer();
            do
            {
                char ch;
                while((ch = din.readChar()) != '.') 
                    loginCrd.append(ch);
                String str = loginCrd.toString();
                String name[] = str.split(" ");
                int i = 0;
                while(i < name.length) 
                {
                    listOfUsers.add(name[i]);
                    i++;
                }
            } while(true);
        }
        catch(EOFException e) { }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList getListOfUsers()
    {
        return listOfUsers;
    }

    private ArrayList listOfUsers;
    private static final String CONFIG_FILE = "./Config_";
}
