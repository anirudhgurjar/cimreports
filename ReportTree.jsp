<%-- 
    Document   : MainPanel
    Created on : Feb 16, 2012, 2:05:11 PM
    Author     : ANIRUDHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">


<%
        if (session.getAttribute("loginStatus") == null) {
            out.print(com.anirudh.core.html.HtmlProcessor.sessionTimeOut());
            return;
        }
%>

<html>

    <head>
        <title>Destroydrop &raquo; Javascripts &raquo; Tree</title>

        <link rel="StyleSheet" href="css/dtree.css" type="text/css" />
        <script type="text/javascript" src="js/dtree.js"></script>

    </head>

    
    <div class="dtree">
        <h1 style="margin: 0;padding: 0;font-size: 3em;background-repeat: no-repeat;list-style-type: none;"><font color="Red">ROGERS</font></h1>
        <br><a href="#" onclick="javascript:window.parent.close();">Logout</a><br>

        <p><a href="javascript: d.openAll();">Expand all</a> | <a href="javascript: d.closeAll();">Collepse all</a></p>

        <script type="text/javascript">
            <!--

            d = new dTree('d');
            d.add(0,-1,'My Home');

            d.add(1,0,'My Reports');
            d.add(2,1,'Case Reports');
            d.add(3,2,'Employee cases','ReportListEngine?reportName=csrCases','','content');
            d.add(4,2,'Account cases','ReportListEngine?reportName=AccountCase','','content');
            d.add(5,1,'Interaction Reports','#');
            d.add(6,5,'Employee interactions','#');
            d.add(7,5,'Account interactions','#');

            document.write(d);

            /*d.add(3,1,'Case Reports','example01.html');
        d.add(3,1,'Interaction Reports','example01.html');
        //d.add(5,3,'Node 1.1.1','example01.html');
        d.add(6,5,'Node 1.1.1.1','example01.html');
        d.add(7,0,'Node 4','example01.html');
        d.add(8,1,'Node 1.2','example01.html');
        d.add(9,0,'My Pictures','example01.html','Pictures I\'ve taken over the years','','','img/imgfolder.gif');
        d.add(10,9,'The trip to Iceland','example01.html','Pictures of Gullfoss and Geysir');
        d.add(11,9,'Mom\'s birthday','example01.html');
        d.add(12,0,'Recycle Bin','example01.html','','','img/trash.gif');
             */


            //-->
        </script>

    </div>

</html>
