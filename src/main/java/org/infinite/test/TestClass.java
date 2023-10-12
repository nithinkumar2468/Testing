package org.infinite.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.infinite.dbutils.HibernateUtil;
import org.infinite.pojo.Student;

public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Date now=new Date();
		
		
		student.setUsername("ganesh");
		student.setPassword("ganesh123");
		student.setTime(now);
		
		
		//student.setTime();

		Transaction tx = null;
		//Get the session object.
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
	          //Start hibernate session.
		      tx = session.beginTransaction();

	          //Insert a new student record in the database.
		      session.save(student);

	          //Commit hibernate transaction if no exception occurs.
		      tx.commit();
		  }catch (HibernateException e) {
		     if(tx!=null){
	             //Roll back if any exception occurs. 
		         tx.rollback();
		     }
		     e.printStackTrace(); 
		  }finally {
	         //Close hibernate session.
		     session.close(); 
		  }
		}

	}
