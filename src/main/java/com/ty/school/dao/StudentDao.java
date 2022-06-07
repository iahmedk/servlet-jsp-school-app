package com.ty.school.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.school.dto.Student;

public class StudentDao {

	public Student saveStudent(Student s) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.persist(s);
		entityTransaction.commit();
		return s;
	}

	public List<Student> getAllStudents() {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();

		String jpql = "SELECT s from Student s";
		Query query = entityManager.createQuery(jpql);
		return query.getResultList();
	}

	public Student getStudentById(int id) {
		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		return entityManager.find(Student.class, id);
	}

	public void removeStudentById(int id) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		String jpql = "delete from Student s where s.id = ?1";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, id);
		entityTransaction.begin();
		query.executeUpdate();
		entityTransaction.commit();
	}

	public void updateStudent(Student student) {

		EntityManager entityManager = Persistence.createEntityManagerFactory("Imtiyaz").createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		entityTransaction.begin();
		entityManager.merge(student);
		entityTransaction.commit();

	}
}
