<%-- 
    Document   : MainPage
    Created on : Feb 22, 2012, 1:22:14 PM
    Author     : ANIRUDHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="ErrorPage.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
   <%
   if(session.getAttribute("loginStatus")==null){
   out.print(com.anirudh.core.html.HtmlProcessor.sessionTimeOut());
   return;
   }
     %>

<frameset cols="18%,82%" border="none">
   <frame src="ReportTree.jsp" FRAMEBORDER=NO FRAMESPACING=0 BORDER=1 />
   <frame src="welcomePage.html" name="content" FRAMEBORDER=NO FRAMESPACING=0 BORDER=1 />
</frameset>