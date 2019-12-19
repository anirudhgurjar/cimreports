// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginValidator.java

package com.anirudh.core.delegates;

import com.anirudh.core.LoginConfig;
import java.util.ArrayList;

public class LoginValidator
{

    private LoginValidator()
    {
    }

    public static LoginConfig getLoginConf()
        throws Exception
    {
        if(validator == null)
        {
            validator = new LoginValidator();
            loginConfig = new LoginConfig();
        }
        return loginConfig;
    }

    public static boolean login(String username, String password)
        throws Exception
    {
        loginConfig = getLoginConf();
        boolean loginSuccess = false;
        if(loginConfig.getListOfUsers().contains(new String((new StringBuilder()).append(username).append("_").append(password).toString())))
            loginSuccess = true;
        return loginSuccess;
    }

    private static LoginValidator validator;
    private static LoginConfig loginConfig;
}
