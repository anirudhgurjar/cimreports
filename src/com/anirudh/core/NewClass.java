// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NewClass.java

package com.anirudh.core;

import java.io.*;
import java.util.ArrayList;

public class NewClass
{

    public NewClass()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        String fileName = "./Config_";
        DataOutputStream os = new DataOutputStream(new FileOutputStream("./Config_"));
        String s = "admin_admin9 anirudh_anirudh7 .";
        os.writeChars(s);
        os.close();
        DataInputStream din = new DataInputStream(new FileInputStream(fileName));
        StringBuffer loginCrd = null;
        loginCrd = new StringBuffer();
        ArrayList listOfUsers;
        try
        {
            do
            {
                char ch;
                while((ch = din.readChar()) == '.') ;
                loginCrd.append(ch);
            } while(true);
        }
        catch(EOFException e)
        {
            listOfUsers = new ArrayList();
        }
        String str = loginCrd.toString();
        String name[] = str.split(" ");
        for(int i = 0; i < name.length; i++)
            listOfUsers.add(name[i]);

        String user_name = "admin_admin9";
    }
}
