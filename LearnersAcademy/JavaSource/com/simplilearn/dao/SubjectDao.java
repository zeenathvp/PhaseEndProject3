package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

public class SubjectDao {
HibernateUtil hibernateUtil;
	
	public void createSubject(Subject subject) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(subject);
		
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Subject> getSubjects(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Subject> query = session.createQuery("from Subject");
		
		List<Subject> SubjectList = query.getResultList();
		session.close();
		return SubjectList;
		
	}
		
	public Subject getSubjectById(int SubjectId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Subject subject = session.get(Subject.class, SubjectId); 
		session.close();
		return subject;
	}
}
