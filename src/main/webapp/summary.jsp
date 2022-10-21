<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
    <head>
        <title>Summary screen</title>
        <style type="text/css">   
        
        body{
        margin-top: 9%;
        border-style: solid;
        margin-left: 30%;
        margin-right: 30%;
        }

        table{
            line-height: 200%
        }

        td{
            width: 25%;
        }

        header{
            margin-right: 25.5%;
            font-size: 16pt;
            font: bold;
            margin-bottom: 2%;
        }
        </style>
    </head>

    <body>
        <center>
            <form class="box" action="index.jsp" method="post">
                <header>Summary</header>
                <table>
                    <tr>
                        <td>Name</td>
                        <td><%=request.getAttribute("name") %></td>
                    </tr>
                    <tr>
                        <td>Correct answers</td>
                        <td><%=request.getAttribute("score") %> out of <%=request.getAttribute("outOf") %></td>
                    </tr>
                    <tr>
                        <td>Percentage</td>
                        <td><%=request.getAttribute("percentage") %></td>
                    </tr>
                    <tr>
                       <td>  <a href="index.jsp">click here to go back to login page</a></td>
                    </tr>
                </table>            
            </form>
        </center>
    </body>
</html>
