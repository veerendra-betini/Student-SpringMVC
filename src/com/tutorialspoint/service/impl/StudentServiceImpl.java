package com.tutorialspoint.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutorialspoint.model.StudentEntity;
import com.tutorialspoint.service.StudentService;
import com.tutorialspoint.dao.StudentDao;

@Service("StudentService")
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentDao studentDao;

	// StudentDao studentDao = new StudentDaoImpl();
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	@Transactional
	/*
	 * @Transactional annotation has several properties like readOnly,
	 * isolation, propagation,rollbackFor, no Rollback For etc that can be used
	 * to control how one transaction behaves and communicate with other
	 * transactions.
	 */
	public void addStudent(StudentEntity st) {
		studentDao.addStudent(st);
	}

	@Override
	@Transactional
	public List<StudentEntity> getAllStudents() {
		return studentDao.getAllStudents();
	}

	@Override
	@Transactional
	public void deleteStudent(Integer studentId) {
		studentDao.deleteStudent(studentId);
	}

	@Override
	@Transactional
	public StudentEntity getStudent(Integer studentId) {
		return studentDao.getStudent(studentId);
	}
}
