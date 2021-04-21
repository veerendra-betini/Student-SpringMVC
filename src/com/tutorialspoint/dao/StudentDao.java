package com.tutorialspoint.dao;

import java.util.List;

import com.tutorialspoint.model.StudentEntity;

public interface StudentDao {
	public void addStudent(StudentEntity st);

	public List<StudentEntity> getAllStudents();

	public void deleteStudent(Integer studentId);

	public StudentEntity getStudent(Integer studentId);
}
