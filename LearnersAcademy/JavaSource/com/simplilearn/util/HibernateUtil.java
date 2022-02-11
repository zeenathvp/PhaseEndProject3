package com.simplilearn.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.simplilearn.entity.Class_Subject_Teacher;
import com.simplilearn.entity.Classroom;
import com.simplilearn.entity.Student;
import com.simplilearn.entity.Subject;
import com.simplilearn.entity.Teacher;

public class HibernateUtil {
private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		
		if(sessionFactory ==  null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties hibernateProperties = new Properties();
				hibernateProperties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				hibernateProperties.put(Environment.URL, "jdbc:mysql://localhost:3306/phaseEndProject");
				hibernateProperties.put(Environment.USER, "root");
				hibernateProperties.put(Environment.PASS, "Admin@123");
				hibernateProperties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
				hibernateProperties.put(Environment.SHOW_SQL, "true");
				hibernateProperties.put(Environment.FORMAT_SQL, "true");
				hibernateProperties.put(Environment.HBM2DDL_AUTO, "update");
				configuration.setProperties(hibernateProperties);
				
				configuration.addAnnotatedClass(Student.class);
				configuration.addAnnotatedClass(Classroom.class);
				configuration.addAnnotatedClass(Subject.class);
				configuration.addAnnotatedClass(Teacher.class);
				configuration.addAnnotatedClass(Class_Subject_Teacher.class);
				
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}

}
