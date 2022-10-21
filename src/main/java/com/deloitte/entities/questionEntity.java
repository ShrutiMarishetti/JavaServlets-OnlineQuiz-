package com.deloitte.entities;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.tools.javac.jvm.Gen;

@Entity
@Table(name="QUESTIONS")
public class questionEntity {
	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    int questionId;
	    @Column(name="QUESTION", length=100)
        String question;
	    @Column(name="ANS1", length=50)
        String ans1;
	    @Column(name="ANS2", length=50)
        String ans2;
	    @Column(name="ANS3", length=50)
        String ans3;
	    @Column(name="ANS4", length=50)
        String ans4;
	    @Column(name="ANS", length=1)
        char ans;
	    
		public int getQuestionId() {
			return questionId;
		}
		public void setQuestionId(int questionId) {
			this.questionId = questionId;
		}
		public char getAns() {
			return ans;
		}
		public void setAns(char ans) {
			this.ans = ans;
		}
		public String getQuestion() {
			return question;
		}
		public void setQuestion(String question) {
			this.question = question;
		}
		public String getAns1() {
			return ans1;
		}
		public void setAns1(String ans1) {
			this.ans1 = ans1;
		}
		public String getAns2() {
			return ans2;
		}
		public void setAns2(String ans2) {
			this.ans2 = ans2;
		}
		public String getAns3() {
			return ans3;
		}
		public void setAns3(String ans3) {
			this.ans3 = ans3;
		}
		public String getAns4() {
			return ans4;
		}
		public void setAns4(String ans4) {
			this.ans4 = ans4;
		}
        
        
}
