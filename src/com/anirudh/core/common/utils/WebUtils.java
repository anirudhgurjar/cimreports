// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WebUtils.java

package com.anirudh.core.common.utils;

import javax.servlet.http.HttpSession;

public class WebUtils
{

    public WebUtils()
    {
    }

    public static boolean isValidSession(HttpSession session)
    {
        boolean sessionAlive = false;
        String sessionString = (String)session.getAttribute("loginStatus");
        if(sessionString != null && sessionString.equalsIgnoreCase("success"))
            sessionAlive = true;
        return sessionAlive;
    }
}
