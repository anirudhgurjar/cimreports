<%-- 
    Document   : index
    Created on : Feb 7, 2012, 11:31:47 PM
    Author     : ANIRUDHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CIM Reports</title>
        <link rel="stylesheet" href="css/screen.css" type="text/css" />
    <script type="text/javascript">
        <jsp:include page="js/formValidate.js"/>
    </script>

    </head>
    <div  align="Center">
    
        <br><br><br><br>
        <h1><font color="RED">ROGERS - CIM Reporting Portal</font></h1><hr>
        <form name="inputForm" action=".\LoginAction" method="post" onsubmit="return validateForm();">
            <table style='border:1px none #000;width:25%'>
                <tr>
                    <td>
                        Login ID :
                    </td>
                    <td>
                        <input title="Login ID" type="text" name="user_name">
                    </td>
                </tr>
                <tr>
                    <td>
                        Password :
                    </td>
                    <td>
                        <input   title="Password" type="password" name="password">
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td align="right">
                        <input align="right" type="submit"  value="Login" />
                    </td>
                </tr>

            </table>
        </form>
    </div>
</html>
