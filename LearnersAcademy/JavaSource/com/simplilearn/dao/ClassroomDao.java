package com.simplilearn.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.simplilearn.entity.Classroom;
import com.simplilearn.util.HibernateUtil;

public class ClassroomDao {
	HibernateUtil hibernateUtil;
	
	public void createClassRoom(Classroom classroom) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction trans = session.beginTransaction();
		session.save(classroom);
		
		trans.commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Classroom> getClassrooms(){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		TypedQuery<Classroom> query = session.createQuery("from Classroom");
		
		List<Classroom> ClassRoomList = query.getResultList();
		return ClassRoomList;
		
	}
	
	public Classroom getClassById(int ClassId){
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session=sessionFactory.openSession();
		Classroom classroom = session.get(Classroom.class, ClassId); 
		
		return classroom;
	}
}
