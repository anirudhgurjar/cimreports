// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoreConfig.java

package com.anirudh.core;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;

// Referenced classes of package com.anirudh.core:
//            Report, ReportInputField

public class CoreConfig
{

    public CoreConfig()
    {
        reportMap = new HashMap();
    }

    public final String getElementValue(Node elem)
    {
        if(elem != null && elem.hasChildNodes())
        {
            for(Node node = elem.getFirstChild(); node != null; node = node.getNextSibling())
                if(node.getNodeType() == 3)
                    return node.getNodeValue();

        }
        return "";
    }

    public void retrieveValue(Node node, int index)
    {
        String nodeName = node.getNodeName();
        String nodeValue = getElementValue(node);
        StringBuffer buffer = new StringBuffer();
        Report report = null;
        ReportInputField inputField = null;
        if(nodeName.equalsIgnoreCase("Report"))
        {
            report = new Report();
            String reportName = node.getAttributes().getNamedItem("name").getNodeValue();
            report.setName(reportName);
            report.setTitle(node.getAttributes().getNamedItem("title").getNodeValue());
            reportMap.put(reportName, report);
        }
        if(nodeName.equalsIgnoreCase("Field"))
        {
            inputField = new ReportInputField();
            inputField.setName(node.getAttributes().getNamedItem("name").getNodeValue());
            inputField.setTitle(node.getAttributes().getNamedItem("title").getNodeValue());
            String parentNode = node.getParentNode().getParentNode().getAttributes().getNamedItem("name").getNodeValue();
            Report report1 = (Report)reportMap.get(parentNode);
            if(report1 != null)
                report1.getInputFields().add(inputField);
        }
        if(nodeName.equalsIgnoreCase("SQL"))
        {
            String parentNode = node.getParentNode().getAttributes().getNamedItem("name").getNodeValue();
            Report report1 = (Report)reportMap.get(parentNode);
            if(report1 != null)
                report1.setSqlString(nodeValue);
        }
        NodeList children = node.getChildNodes();
        for(int i = 1; i < children.getLength(); i++)
        {
            Node child = children.item(i);
            if(child.getNodeType() == 1)
                retrieveValue(child, index + 2);
        }

    }

    public HashMap initConfig()
        throws Exception
    {
        File f = new File(getClass().getResource("Report.xml").toURI());
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
        Document doc = docBuilder.parse(f);
        Node root = doc.getDocumentElement();
        retrieveValue(root, 0);
        return reportMap;
    }

    private HashMap reportMap;
}
