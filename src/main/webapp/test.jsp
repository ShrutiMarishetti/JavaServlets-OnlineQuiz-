<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.List"%>
    <%@page import="com.deloitte.entities.questionEntity"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz Administration</title>
        <style type="text/css">  
  
        body{
        margin-top: 9%;
        border-style: solid;
        margin-left: 30%;
        margin-right: 30%;
                }

        tr{
            margin-right: 10%;
        }

        .btn1{
            width: 80px;
            font-size: 12px;
            text-align-last: inherit;
            border-style: solid;
            display: unset;
            text-align-last: center;
            position: initial;
            margin-left: 50%;
        }
        .btn2{
            width: 60px;
            font-size: 12px;
            text-align-last: inherit;
            border-style: solid;
            display: unset;
            text-align-last: center;
            position: initial;
            margin-left: 2%;
        }

        table{
            line-height: 200%;
        }
        </style>
    </head>
    <% questionEntity question=null; %>
    <script>
		function myfunction() {
		  
		 //alert('sure want to submit?');
		 var r = window.confirm("Sure want to submit?");
	     if (r == true) {
			  document.getElementById("submit").value="finish";
		  } else {
			  document.getElementById("submit").value="hold";
		  } 
		   
		}
</script>

    <body>
        <%
        int n=0;
        if(null!=request.getSession().getAttribute("totalQuestions"))
        {
        	n=(int)request.getSession().getAttribute("totalQuestions");
        }
       
        if(null!=request.getAttribute("question"))
        {
        	question=(questionEntity)request.getAttribute("question");
        }
        char c=0;
        if(null!=request.getAttribute("check")){
        	c=(char) request.getAttribute("check");
        }
        %>
        <center>
            <form class="box" action="PlayerServlet" method="post">
                <table>
                    <tr>
                        <td>Question <%=question.getQuestionId()%>.</td>
                        <td>
                            <%=question.getQuestion() %>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="radio">
                                <input class="radio-one" type="radio" name="option" value='a' required  <% if(c=='a'){ %>  checked <%}%>>
                                <span class="checkmark"></span>
                                <%=question.getAns1() %>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="radio">
                                <input class="radio-two" type="radio" name="option" value='b' required <% if(c=='b'){ %>  checked <%}%>>
                                <span class="checkmark"></span>
                                <%=question.getAns2() %>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="radio">
                                <input class="radio-three" type="radio" name="option" value='c' required <% if(c=='c'){ %>  checked <%}%>>
                                <span class="checkmark"></span>
                                <%=question.getAns3() %>
                            </label>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label class="radio">
                                <input class="radio-four" type="radio" name="option" value='d' required <% if(c=='d'){ %>  checked <%}%>>
                            
                                <span class="checkmark"></span>
                                <%=question.getAns4() %>
                            </label>
                        </td>
                    </tr>
                </table>            
                <%
                if(question.getQuestionId()!=1)
                {%>
                	<button class="btn1" type="submit" name="previous" value=<%=question.getQuestionId() %>>Previous</button>
              <%  }
                %>
                
                <%
                if(n!=question.getQuestionId()){
                %>
                <button class="btn2" type="submit" name="next" value=<%=question.getQuestionId() %>>Next</button>
                <%}
                else
                {%>
               <!--  <button class="btn2" type="submit" name="submit" onclick="myfunction()" id="submit" >Submit</button> -->
                <button class="btn2" onclick="myfunction()" name="submit" id="submit" >Submit</button>
                	
                <%}%>
           
           
            </form>
        </center>
    </body>
</html>