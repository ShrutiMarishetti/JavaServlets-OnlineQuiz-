<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
            width: 50px;
            font-size: 12px;
            text-align-last: inherit;
            border-style: solid;
            display: unset;
            text-align-last: center;
            position: initial;
            margin-left: 20%;
        }
        .btn2{
            width: 50px;
            font-size: 12px;
            text-align-last: inherit;
            border-style: solid;
            display: unset;
            text-align-last: center;
            position: initial;
        }

        table{
            line-height: 200%
        }
        .q{
            width: 120%;
        }
        </style>
    </head>

    <body>
        <center>
            <form class="box" action="AdminServlet" method="post">
                <table>
                    <tr>
                        <td>Question</td>
                        <td>
                            <input class="q" type="text" name="question" placeholder="Enter the question" id="qn">
                        </td>
                    </tr>
                    <tr>
                        <td>Answer(a)</td>
                        <td>
                            <input class="q" type="text" name="option_a" placeholder="Enter the first option" id="optn1">
                        </td>
                    </tr>
                    <tr>
                        <td>Answer(b)</td>
                        <td>
                            <input class="q" type="text" name="option_b" placeholder="Enter the second option" id="optn2">
                        </td>
                    </tr>
                    <tr>
                        <td>Answer(c)</td>
                        <td>
                            <input class="q" type="text" name="option_c" placeholder="Enter the third option" id="optn3">
                        </td>
                    </tr>
                    <tr>
                        <td>Answer(d)</td>
                        <td>
                            <input class="q" type="text" name="option_d" placeholder="Enter the fourth option" id="optn4">
                        </td>
                    </tr>
                    <tr>
                        <td>Correct Option</td>
                        <td>
                            <label class="radio">
                                <input class="radio-one" type="radio" name="option" value='a'>
                                <span class="checkmark"></span>
                                (a)
                            </label>
                            <label class="radio">
                                <input class="radio-two" type="radio" name="option" value='b'>
                                <span class="checkmark"></span>
                                (b)
                            </label>
                            <label class="radio">
                                <input class="radio-three" type="radio" name="option" value='c'>
                                <span class="checkmark"></span>
                                (c)
                            </label>
                            <label class="radio">
                                <input class="radio-four" type="radio" name="option" value='d'>
                                <span class="checkmark"></span>
                                (d)
                            </label>
                        </td>
                    </tr>
                </table>            
                <button class="btn1" type="submit" name="button" value="finish">Finish</button>
                <button class="btn2" type="submit" name="button" value="next">Next</button>
            </form>
        </center>
    </body>
</html>