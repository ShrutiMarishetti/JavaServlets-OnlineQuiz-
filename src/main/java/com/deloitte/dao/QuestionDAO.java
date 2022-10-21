package com.deloitte.dao;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import com.deloitte.entities.questionEntity;
import com.deloitte.util.HibernateSessionFactoryUtil;


public class QuestionDAO {
	
	public questionEntity saveQuestionDetails(questionEntity qEntry)
	{
		
		
		questionEntity returnQuestionValues =null;
		
		try {
			Session dbSession = HibernateSessionFactoryUtil.getSessionFactoryInstance().openSession();
			Transaction dbTransaction = dbSession.beginTransaction();
			dbSession.save(qEntry);
			dbTransaction.commit();
			dbSession.close();
			System.out.println("saved question");
			returnQuestionValues = qEntry;
		}catch(Exception ex) {
			
			ex.printStackTrace();
			System.out.println("Error while saving cat registration details ==>"+ ex.getMessage());
			
		}
		return returnQuestionValues;

}

	public List<questionEntity> getAllQuestions() {
		// TODO Auto-generated method stub
		List<questionEntity> questionList=null;
		try {
			 
			Session dbSession= HibernateSessionFactoryUtil.getSessionFactoryInstance().openSession();
			
			 CriteriaBuilder criteriaBuilder = dbSession.getCriteriaBuilder();
			 CriteriaQuery <questionEntity>criteriaQuery =  criteriaBuilder.createQuery(questionEntity.class); 
			 Root<questionEntity> rootUserCategories =	  criteriaQuery.from(questionEntity.class);
			  
			 criteriaQuery.select(rootUserCategories);
			  
			 Query<questionEntity>hibQuery = dbSession.createQuery(criteriaQuery);
			 questionList = hibQuery.getResultList();
			 return questionList;
			
		}
		catch(Exception ex)
		{
			System.out.println("Error while retrieving cat details");
			
		}
		
		return questionList;
	}

	public questionEntity getSingleQuestion(int i) {
		// TODO Auto-generated method stub
		questionEntity question=null;
		  try { 
				 
		  Session hibSession =  HibernateSessionFactoryUtil.getSessionFactoryInstance().openSession();
		  
		  CriteriaBuilder criteriaBuilder = hibSession.getCriteriaBuilder();
		  CriteriaQuery<questionEntity>criteriaQuery =  criteriaBuilder.createQuery(questionEntity.class); 
		  Root<questionEntity> rootUser =	  criteriaQuery.from(questionEntity.class);
		  
		  criteriaQuery.select(rootUser).where(criteriaBuilder.equal(rootUser.get("questionId"), i));
		  
		  Query<questionEntity>hibQuery = hibSession.createQuery(criteriaQuery);
		  question = hibQuery.getSingleResult(); 
		  return question;
		  }catch(Exception ex) {
		  
			  	System.out.println("Error while retrieving question details ==>"+ex.getMessage());
		  }
		
		return question;
	}
}
