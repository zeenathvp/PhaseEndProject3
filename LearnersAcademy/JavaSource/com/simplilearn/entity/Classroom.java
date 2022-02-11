package com.simplilearn.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int classId;
	private String className;
	@OneToMany(mappedBy="classroom")
	private List<Student> students;	
	
	
	public Classroom() {
		super();
	}
	public Classroom(String className) {
		super();
		this.className = className;
	}
	public Classroom(int classId) {
		super();
		this.classId = classId;
	}
	public Classroom(int classId, String className) {
		super();
		this.classId = classId;
		this.className = className;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
}
