package com.ty.school.service;

import java.util.List;

import com.ty.school.dao.StudentDao;
import com.ty.school.dto.Student;

public class StudentService {

	public Student createStudent(Student student) {

		StudentDao dao = new StudentDao();
		return dao.saveStudent(student);
	}

	public List<Student> getAllStudents() {
		StudentDao dao = new StudentDao();
		return dao.getAllStudents();
	}

	public Student getStudentById(int id) {
		StudentDao dao = new StudentDao();
		return dao.getStudentById(id);
	}

	public void removeStudentById(int id) {
		StudentDao dao = new StudentDao();
		Student student = getStudentById(id);

		if (student != null) {
			dao.removeStudentById(id);
		}
	}

	public void updateStudentById(int id, Student studentFromForm) {
		StudentDao dao = new StudentDao();
		Student studentFromDB = getStudentById(id);

		// setting updated form data to already existing student to update
		studentFromDB.setName(studentFromForm.getName());
		studentFromDB.setMarks(studentFromForm.getMarks());
		studentFromDB.setMobile(studentFromForm.getMobile());
		studentFromDB.setEmail(studentFromForm.getEmail());
		dao.updateStudent(studentFromDB);
	}
}
