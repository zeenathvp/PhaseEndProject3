package com.simplilearn.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Class_Subject_Teacher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int class_subject_teacher_id;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subjectId") 
	private Subject subject;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId") 
	private Classroom classroom;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherId") 
	private Teacher teacher;
	
	public Class_Subject_Teacher() {
		super();
	}

	public Class_Subject_Teacher(Subject subject, Classroom classroom) {
		super();
		this.subject = subject;
		this.classroom = classroom;
	}
	
	
	public Class_Subject_Teacher(Subject subject, Classroom classroom, Teacher teacher) {
		super();
		this.subject = subject;
		this.classroom = classroom;
		this.teacher = teacher;
	}

	public Class_Subject_Teacher(int class_subject_teacher_id, Subject subject, Classroom classroom, Teacher teacher) {
		super();
		this.class_subject_teacher_id = class_subject_teacher_id;
		this.subject = subject;
		this.classroom = classroom;
		this.teacher = teacher;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Classroom getClassroom() {
		return classroom;
	}

	public void setClassroom(Classroom classromm) {
		this.classroom = classromm;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public int getClass_subject_teacher_id() {
		return class_subject_teacher_id;
	}

	public void setClass_subject_teacher_id(int class_subject_teacher_id) {
		this.class_subject_teacher_id = class_subject_teacher_id;
	}
	
	
}
