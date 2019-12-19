<%-- 
    Document   : ShowReport
    Created on : Feb 12, 2012, 3:17:31 AM
    Author     : ANIRUDHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
 <%
   if(session.getAttribute("loginStatus")==null){
   out.print(com.anirudh.core.html.HtmlProcessor.sessionTimeOut());
   return;
   }
     %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><% out.print(session.getAttribute("reportTitle"));%></title>
        <link rel="stylesheet" href="css/screen.css" type="text/css" />
    </head>

    <div align="Center">
        <hr>
        <h1><%out.print(String.valueOf(session.getAttribute("reportTitle")));%></h1>
        <hr>
        <%
        java.util.ArrayList colHeaders = (java.util.ArrayList) session.getAttribute("reportCols");
        java.util.ArrayList colData = (java.util.ArrayList) session.getAttribute("reportData");
        final int defaultPageSize = 15;
        int totalPages = (colData.size() / defaultPageSize);
        if (colData.size() % defaultPageSize != 0) {
            totalPages++;
        }


        String startPageStr = (String) request.getParameter("startPage");
        if (startPageStr == null) {
            startPageStr = "0";
        }
        int startPage = Integer.parseInt(startPageStr);
        int fromRowNum = startPage * defaultPageSize;
        int toRowNum = fromRowNum + defaultPageSize;
        toRowNum = (toRowNum > colData.size()) ? colData.size() : toRowNum;
      //out.println("Rows: " + (fromRowNum + 1) + " to " + toRowNum);
        out.print("<table>");
        out.print("<thead>");
        int totalCols = colHeaders.size();
        for (int i = 0; i < totalCols; i++) {
            out.print("<th>");
            out.print((String) colHeaders.get(i));
            out.print("</th>");
        }
        out.print("</thead>");
        String rowData[] = null;
        // out.print(colData.size());
        String rowClass = "even";
        for (int idx = fromRowNum; idx < toRowNum; idx++) {
            if ((idx % 2) == 0) {
                rowClass = "odd";
            } else {
                rowClass = "even";
            }
            out.print("<tr class=\"" + rowClass + "\">");
            rowData = (String[]) colData.get(idx);
            for (int i = 0; i < totalCols; i++) {
                out.print("<td>");
                out.print((String.valueOf(rowData[i])));
                out.print("</td>");
            }
            out.print("</tr>");
        }





        out.print("</table>");

        out.println("Page: " + (startPage + 1) + " of " + totalPages);
        //out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");



        out.print("<br><br>");

        if (!(startPage <= 0)) {

            out.print("&nbsp;");
            //out.print("<input align=right type=button value=Back onclick=\"window.location.href='ShowReport.jsp?startPage=" + (startPage - 1) + "'\"/>");
            out.print("<a href='#' onclick=\"window.location.href='ShowReport.jsp?startPage=" + (startPage - 1) + "'\"><b>&lt Prev Page</b></a>");
            out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");

        }
        if ((startPage < totalPages - 1)) {
            // out.print("<td align=left colspan=" + (totalCols / 2) + ">");
            
            //out.print("<input align=left type=button value=Next onclick=\"window.location.href='ShowReport.jsp?startPage=" + (startPage + 1) + "'\"/>");
            out.print("<a href='#' onclick=\"window.location.href='ShowReport.jsp?startPage=" + (startPage + 1) + "'\"><b>Next Page &gt</b></a>");

        }
        out.print("<br><br><hr>");
        out.print("<a href='./ExportToCSV'><b>Export</a>");

        %>

    </div>





</html>
