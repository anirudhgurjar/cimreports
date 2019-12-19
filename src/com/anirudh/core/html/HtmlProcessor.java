// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HtmlProcessor.java

package com.anirudh.core.html;

import com.anirudh.core.Report;
import com.anirudh.core.ReportInputField;
import java.util.ArrayList;
import java.util.Iterator;

public class HtmlProcessor
{

    public HtmlProcessor()
    {
    }

    public static String createNavigation(String navText, String navLink)
    {
        StringBuffer htmlText = new StringBuffer();
        htmlText.append("<a href='").append(navLink).append("'>").append(navText).append("</a>");
        return htmlText.toString();
    }

    public static String sessionTimeOut()
    {
        StringBuffer htmlText = new StringBuffer();
        htmlText.append(createNavigation("Session Timout, Please ReLogin", "./"));
        return htmlText.toString();
    }

    public static String showError(String errText)
    {
        StringBuffer htmlText = new StringBuffer();
        htmlText.append("<H3>");
        htmlText.append(errText);
        htmlText.append("</H3>");
        return htmlText.toString();
    }

    public static String generateHHtmlInputForm(Report report)
    {
        StringBuffer htmlText = new StringBuffer();
        htmlText.append("<head>");
        htmlText.append("<link rel=\"stylesheet\" href=\"css/screen.css\" type=\"text/css\" />");
        htmlText.append("<script type='text/javascript' src='js/formValidate.js'></script>");
        htmlText.append("</head>");
        htmlText.append("<br>");
        htmlText.append("<H3>");
        htmlText.append(report.getTitle());
        htmlText.append("</H3>");
        htmlText.append("<br>");
        htmlText.append("<hr>");
        ArrayList fieldList = report.getInputFields();
        htmlText.append("<form name=inputForm onsubmit=\"return validateForm()\" action=./GenerateReportAction>");
        htmlText.append("<Table style='border:1px none #000;width:25%'>");
        for(Iterator it = fieldList.iterator(); it.hasNext(); htmlText.append("</tr>"))
        {
            ReportInputField inputField = (ReportInputField)it.next();
            htmlText.append("<div align=Center>");
            htmlText.append("<tr>");
            htmlText.append("<td>");
            htmlText.append(inputField.getTitle());
            htmlText.append("</td>");
            htmlText.append("<td>");
            htmlText.append("<input type=Text name=").append(inputField.getName()).append(" title='").append(inputField.getTitle()).append("'").append(" />");
            htmlText.append("</td>");
        }

        htmlText.append("<tr>");
        htmlText.append("<td>");
        htmlText.append("</td>");
        htmlText.append("<td align='right'>");
        htmlText.append("<input type=submit value='Get Report'>");
        htmlText.append("</td>");
        htmlText.append("</tr>");
        htmlText.append("</Table>");
        htmlText.append("<input type=hidden name=reportName value=").append(report.getName()).append(" />");
        htmlText.append("</div>");
        return htmlText.toString();
    }

    private static final String HEADING1_START = "<H3>";
    private static final String HEADING1_END = "</H3>";
    private static final String INPUT_FORM_START = "<form name=inputForm onsubmit=\"return validateForm()\" action=./GenerateReportAction>";
    private static final String FORM_END = "</form>";
    private static final String TABLE_START = "<Table style='border:1px none #000;width:25%'>";
    private static final String TABLE_END = "</Table>";
    private static final String TABLE_ROW_START = "<tr>";
    private static final String TABLE_ROW_END = "</tr>";
    private static final String TABLE_DATA_START = "<td>";
    private static final String TABLE_DATA_END = "</td>";
    private static final String FORM_INPUT_FIELD = "<input type=Text name=";
    private static final String FORM_INPUT_FIELD_CLOSE = " />";
    private static final String FORM_INPUT_HIDDEN = "<input type=hidden name=reportName value=";
    private static final String FORM_SUBMIT_BUTTON = "<input type=submit value='Get Report'>";
    private static final String DIV_CENTER_START = "<div align=Center>";
    private static final String DIV_CENTER_END = "</div>";
    private static final String HTML_BREAK_LINE = "<br>";
    private static final String HTML_HORZNTL_RULE = "<hr>";
    private static final String HTML_VERTICAL_RULE = "<div style='border-left:1px solid #000;height:500px'></div>";
    private static final String SCREEN_CSS = "<link rel=\"stylesheet\" href=\"css/screen.css\" type=\"text/css\" />";
    private static final String HTML_HEAD_START = "<head>";
    private static final String HTML_HEAD_END = "</head>";
    private static final String IMPORT_FRM_JS_VLDTN_SCRPT = "<script type='text/javascript' src='js/formValidate.js'></script>";
    private static final String HTML_NAV_START = "<a href='";
    private static final String HTML_NAV_TEXT = "'>";
    private static final String HTML_NAV_END = "</a>";
}
