package com.sms.service;

import java.util.List;

import com.sms.Repository.studentRepository;
import com.sms.module.Student;

public class StudentServiceImpl implements StudentService {

	private final studentRepository studentRepository;

	public StudentServiceImpl(studentRepository studentRepository) {

		this.studentRepository = studentRepository;
	}
	private void validate(Student s) {
		if(s == null || s.getStudentName() == null || s.getStudentName().isBlank() || 
				s.getEmail() == null || !s.getEmail().matches("`[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$`") ||
				s.getDepartment() == null ||s.getDepartment().isBlank() || 
				!s.getPhoneNumber().matches("`[0-9]{10,15}`") ) {
			throw new IllegalArgumentException("Enter valid student details.");
		}
	}

	@Override
	public boolean addStudent(Student student) {
		
		validate(student);
		return studentRepository.add(student);
	}

	@Override
	public List<Student> getAllStudents() {

		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(int id) {
		if(id <= 0) {
			throw new IllegalArgumentException("ID must be position.");
		}
		return studentRepository.findById(id);
	}

	@Override
	public boolean updateStudent(int id, Student student) {
	
		validate(student);
		return studentRepository.update(id, student);
	}

	@Override
	public boolean deleteStudent(int id) {
		
		if(id <= 0) {
			throw new IllegalArgumentException("ID must be position.");
		}
		return studentRepository.delete(id);
	}

}
