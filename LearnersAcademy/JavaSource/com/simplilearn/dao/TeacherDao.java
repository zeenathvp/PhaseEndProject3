package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Teacher;
import com.simplilearn.util.HibernateUtil;

public class TeacherDao {
HibernateUtil hibernateUtil;
	
	public void createSubject(Teacher teacher) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(teacher);
		
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Teacher> getTeachers(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Teacher> query = session.createQuery("from Teacher");
		
		List<Teacher> TeacherList = query.getResultList();
		return TeacherList;
		
	}
	
	public Teacher getTeacherById(int TeacherId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Teacher teacher = session.get(Teacher.class, TeacherId); 
		session.close();
		return teacher;
	}
}
