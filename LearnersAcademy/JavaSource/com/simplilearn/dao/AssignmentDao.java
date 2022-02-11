package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Class_Subject_Teacher;
import com.simplilearn.entity.Subject;
import com.simplilearn.util.HibernateUtil;

public class AssignmentDao {
	HibernateUtil hibernateUtil;
	
	public void assignclassSubjectTeacher(Class_Subject_Teacher classSubjectTeacher) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(classSubjectTeacher);
		
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Class_Subject_Teacher> getAssignmentList(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();		
		TypedQuery<Class_Subject_Teacher> query = session.createQuery("from Class_Subject_Teacher");
		
		List<Class_Subject_Teacher> AssignmentList = query.getResultList();
		return AssignmentList;
	}
	
	public List<Class_Subject_Teacher> getAssignmentById(int subjectId,int classId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		
		TypedQuery<Class_Subject_Teacher> query = session.createQuery("from Class_Subject_Teacher where subjectId="+subjectId+" and classId="+classId);
		List<Class_Subject_Teacher> AssignmentList = query.getResultList();
		session.close();
		return AssignmentList;
	}
	
	public void updateclassSubjectTeacher(Class_Subject_Teacher classSubjectTeacher) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.update(classSubjectTeacher);
		
		trans.commit();
		session.close();
	}
}
