package com.tutorialspoint.service;

import java.util.List;

import com.tutorialspoint.model.StudentEntity;

public interface StudentService {
	public void addStudent(StudentEntity st);

	public List<StudentEntity> getAllStudents();

	public void deleteStudent(Integer studnetId);

	public StudentEntity getStudent(Integer studentId);
}
