// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LoginAction.java

package com.anirudh.core.actions;

import com.anirudh.core.delegates.LoginValidator;
import com.anirudh.core.html.HtmlProcessor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class LoginAction extends HttpServlet
{

    public LoginAction()
    {
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        PrintWriter out;
        HttpSession session;
        response.setContentType("text/html;charset=UTF-8");
        out = response.getWriter();
        session = request.getSession(true);
        String userName = request.getParameter("user_name");
        String paswWord = request.getParameter("password");
        boolean isLoginSuccess = LoginValidator.login(userName, paswWord);
        if(!isLoginSuccess)
            throw new Exception("Invalid username or password, Please try again");
        if(isLoginSuccess)
        {
            session.setAttribute("loginStatus", "success");
            RequestDispatcher rd = request.getRequestDispatcher("./MainPage.jsp");
            rd.forward(request, response);
        }
        out.close();
        break MISSING_BLOCK_LABEL_156;
        Exception e;
        e;
        e.printStackTrace();
        out.print(HtmlProcessor.showError(e.getMessage()));
        out.print(HtmlProcessor.createNavigation("Try again", "./"));
        out.close();
        break MISSING_BLOCK_LABEL_156;
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
