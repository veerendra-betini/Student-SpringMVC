package com.tutorialspoint.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorialspoint.dao.StudentDao;
import com.tutorialspoint.model.StudentEntity;

@Repository("StudentDao")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addStudent(StudentEntity student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	public void deleteStudent(Integer studentId) {
		StudentEntity std = (StudentEntity) sessionFactory.getCurrentSession()
				.load(StudentEntity.class, studentId);
		if (null != std) {
			sessionFactory.getCurrentSession().delete(std);
		}
		/*
		 * StudentEntity std = new StudentEntity(); std.setId(studentId);
		 * sessionFactory.getCurrentSession().delete(std);
		 */
		/*
		 * sessionFactory.getCurrentSession().createQuery(
		 * "DELETE FROM StudentEntity WHERE id = "+studentId).executeUpdate();
		 */
	}

	@Override
	public StudentEntity getStudent(Integer studentId) {
		/*
		 * Session session = this.sessionFactory.getCurrentSession(); Query
		 * query = session.createQuery("from StudentEntity where id =?");
		 * query.setParameter(0, studentId); List<StudentEntity> searchlist =
		 * query.list(); return searchlist;
		 */

		/*
		 * return (List<StudentEntity>)
		 * sessionFactory.getCurrentSession().createQuery
		 * ("from StudentEntity where id ="+studentId).list();
		 */
		return (StudentEntity) sessionFactory.getCurrentSession().get(
				StudentEntity.class, studentId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentEntity> getAllStudents() {
		return sessionFactory.getCurrentSession()
				.createQuery("from StudentEntity").list();
		/*
		 * return (List<StudentEntity>)
		 * sessionFactory.getCurrentSession().createCriteria
		 * (StudentEntity.class).list();
		 */
	}
}
