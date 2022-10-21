package com.deloitte.Servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deloitte.dao.QuestionDAO;
import com.deloitte.entities.questionEntity;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userOperation =request.getParameter("operation");
		System.out.println("loginServlet");
		
		if(("addQuestion".equalsIgnoreCase(userOperation))) {
			if(request.getParameter("userName").equals("Admin")&& request.getParameter("password").equals("password"))
			{
				HttpSession userSession = request.getSession();	
				userSession.setAttribute("UserAdmin", "Admin");
				request.getRequestDispatcher("admin.jsp").forward(request, response);
			}
			else
			{
				request.setAttribute("Details", "Invalid");
				request.getRequestDispatcher("index.jsp").forward(request, response);;
			}
				
           //response.getWriter().append("Served at: ").append(request.getContextPath());
	    }
		else
		{
			
			System.out.println("user");
			HttpSession userSession = request.getSession();
			//userSession.setAttribute("UserScore", 0);
			userSession.setAttribute("UserName", request.getParameter("usernameinput"));
			
			QuestionDAO questiondao=new QuestionDAO();
     		
     		List<Character> answers=new ArrayList<Character>();
     		userSession.setAttribute("userAnswers", answers);
			questionEntity question=new questionEntity();
			question=questiondao.getSingleQuestion(1);
			request.setAttribute("question", question);
			List<questionEntity> questionList=questiondao.getAllQuestions();
			userSession.setAttribute("totalQuestions", questionList.size());
			request.getRequestDispatcher("test.jsp").forward(request, response);
			
			
//		    char ans[]=new char[questionList.size()];
//		    userSession.setAttribute("userAnswers", ans);
		    
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
