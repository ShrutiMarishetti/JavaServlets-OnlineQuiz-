<!DOCTYPE html>
<html>
<head>
    <title>Login Screen</title>
    <style type="text/css">
       html{
        
        }  
    body{
       
        margin-top: 9%;
        border-style: solid;
        margin-left: 40%;
        margin-right: 40%;
        
    }
    header{
        width: 252px;
        font-size: 16px;
        font: initial;
        background-color:rgb(225, 231, 236);
        color: #000000;
    }

    .btn1{
        width: 55px;
        margin-left: 195%;
        font-size: 12px;
        border-style: solid;
    }

    .btn2{
        width: 55px;
        margin-left: 235%;
        font-size: 12px;
        border-style: solid;
    }

    input{
        width: 100px;
        size: 500%;
        margin-left: 8%;
        font-size: 69%;
    }

    .playerclass{
        margin-left: 16%;
        margin-right: 200%;
    }

    table{
        line-height: 200%;
        
    }

    td{
        border-spacing: 200%;
    }
    
    </style>
</head>
<body>
    <center>
    <form class="box" action=LoginServlet method="post" >
        <div><header>Quiz Administrator</header></div>
        <%
        if(null!=request.getAttribute("Details")){
        	%>
        	<h5>Invalid Credentials</h5>
        <%}
        %>
        <table>            
            <tr>
                <td>User name</td>
                <td> 
                    <input type="text" name="userName" placeholder="Enter username" id="user_name">
                </td>
            </tr>
            <tr>  
                <td>Password</td>
                <td>
                    <input type="password" name="password" placeholder="Enter password" id="pass_word" >
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn1" type="submit" name="operation" value="addQuestion">Submit</button>
                </td>
            </tr>
        </table>
        </form>
        <form class="box" action="LoginServlet" method="post">
        <div><header>Quiz Player</header></div>

        <table>
            <tr>
                <td class="playerclass">Name</td>
                <td>
                    <input class="playerclass" type="text"  name="usernameinput" placeholder="Enter your name" id="Player_name" required>
                </td>
            </tr>
            <tr>
                <td>
                    <button class="btn2" type="submit" name="operation" value="startTest">Start</button>
                </td>
            </tr>
        </table>
    </form>
    </center>
</body>
</html>