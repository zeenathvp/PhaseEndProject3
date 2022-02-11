package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Student;
import com.simplilearn.util.HibernateUtil;

public class StudentDao {
	public void saveStudent(Student student) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(student);
		
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Student> getStudents(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();		
		TypedQuery<Student> query = session.createQuery("from Student");
		
		List<Student> StudentList = query.getResultList();
		return StudentList;
	}
	
}
