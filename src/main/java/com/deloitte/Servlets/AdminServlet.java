package com.deloitte.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dao.QuestionDAO;
import com.deloitte.entities.questionEntity;

/**
 * Servlet implementation class AdminServlet
 */
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		questionEntity singleQuestion=new questionEntity();
		QuestionDAO questionDAO=new QuestionDAO();
		System.out.println("AdminServlet");
		singleQuestion.setQuestion(request.getParameter("question"));
		singleQuestion.setAns1(request.getParameter("option_a"));
		singleQuestion.setAns2(request.getParameter("option_b"));
		singleQuestion.setAns3(request.getParameter("option_c"));
		singleQuestion.setAns4(request.getParameter("option_d"));
		singleQuestion.setAns(request.getParameter("option").charAt(0));
		questionDAO.saveQuestionDetails(singleQuestion);
		String action=request.getParameter("button");
		if(action.equals("finish"))
		{
			request.getSession().invalidate();
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		else
		{
			request.getRequestDispatcher("admin.jsp").forward(request, response);
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
