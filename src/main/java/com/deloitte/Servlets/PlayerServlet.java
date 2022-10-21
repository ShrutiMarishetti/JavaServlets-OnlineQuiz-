package com.deloitte.Servlets;

import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deloitte.dao.QuestionDAO;
import com.deloitte.entities.questionEntity;

/**
 * Servlet implementation class PlayerServlet
 */
public class PlayerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		QuestionDAO questiondao=new QuestionDAO();
		questionEntity question=new questionEntity();
		int questionId,score=0;
		char ans=ans=request.getParameter("option").charAt(0);//a;
		List<Character> userAnswers=(List<Character>)request.getSession().getAttribute("userAnswers");
		//displaying answrs
		
		if(null!=request.getParameter("next"))
		{

			questionId=Integer.parseInt(request.getParameter("next"));
			System.out.println("total answers "+userAnswers.size());
			System.out.println("questionId "+questionId);
			if(userAnswers.size()==questionId-1)//first time you are saving that question
			{
				 userAnswers.add(questionId-1, ans);
			}	
			else
			{

				if(userAnswers.size()>questionId)//going to next saved question 3>2
				{
					request.setAttribute("check",userAnswers.get(questionId) );
				}
				else
				{
					if( null==userAnswers.get(questionId-1))
					{
						 userAnswers.add(questionId-1, ans);
					}
					else//overwriting the option
					{
						userAnswers.remove(questionId-1);
						userAnswers.add(questionId-1, ans);
					}
				}
			}
			request.getSession().setAttribute("userAnswers", userAnswers);

			question=questiondao.getSingleQuestion(questionId+1);
			request.setAttribute("question", question);
			request.getRequestDispatcher("test.jsp").forward(request, response);
		}
		else if(null!=request.getParameter("submit")){//calculate the score
			{
				//System.out.println(request.getParameter("submit"));
				int total=(int)request.getSession().getAttribute("totalQuestions");
				if( total>userAnswers.size())
				{
					 userAnswers.add(total-1, ans);
				}
				else//overwriting the option
				{
					userAnswers.remove(total-1);
					userAnswers.add(total-1, ans);
				}
				//userAnswers.add(total-1, ans);
			   if("finish".equals((String)request.getParameter("submit")))
			   {
					
					for(int i=0;i<userAnswers.size();i++)
					{
						System.out.println(userAnswers.get(i));
						if(userAnswers.get(i)==questiondao.getSingleQuestion(i+1).getAns())
						        score++;
					}
					float percentage=(score*100/(total));
					request.setAttribute("score", score);
					request.setAttribute("percentage",percentage );
					request.setAttribute("outOf",total );
					request.setAttribute("name",request.getSession().getAttribute("UserName"));
					request.getSession().invalidate();
					request.getRequestDispatcher("summary.jsp").forward(request, response);
			   }
			   else
			   {
				   System.out.println("stay here");
				   question=questiondao.getSingleQuestion(total);
				   request.setAttribute("question", question);
				   request.setAttribute("check",userAnswers.get(total-1) );
				   request.getRequestDispatcher("test.jsp").forward(request, response);
			   }
			}
			
		}
		else if(null!=request.getParameter("previous"))
		{
			questionId=Integer.parseInt(request.getParameter("previous"));

			if(userAnswers.size()==questionId-1)//first time you are entering into that question
			{
				 //a
				 userAnswers.add(questionId-1, ans);
				
			}
			question=questiondao.getSingleQuestion(questionId-1);
			request.setAttribute("question", question);
			//String s="option"+Character.toString(userAnswers.get(questionId-2));
			//System.out.println(s);
			//request.setAttribute(s, "checked");//option a must be checked
			request.setAttribute("check",userAnswers.get(questionId-2) );
			request.getRequestDispatcher("test.jsp").forward(request, response);
			
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
