package com.sms.Repository;

import java.util.ArrayList;
import java.util.List;

import com.sms.module.Student;

public class studentRepository {
	/** 
	 * collection --> framework{list and ArrayList}
	 * package name --> java.util
	 */
	// object for list
	private final List<Student> students = new ArrayList<>();
	
	public boolean add(Student student) {
		if(findById(student.getStudentid()) != null || findByEmail(student.getEmail()) != null) {
			return false;
		}
		return students.add(student);
	}
	public Student findById(int id) {
		for(Student student : students) {
			if(student.getStudentid() == id) {
				return student;
			}
		}
		
		return null;
	}
	public Student findByEmail(String email) {
		for(Student student : students) {
			if(student.getEmail().equalsIgnoreCase(email)) {
				return student;
			}
		}
		return null;
	}
	
	public List<Student> findAll(){
		return new ArrayList<>(students);
	}
	public boolean update(int id,Student updated) {
		Student existing = findByID(id);
		if(existing == null) {
			return false;
		}
		Student emailOwner = findByEmail(updated.getEmail());
		if(emailOwner !=null && emailOwner.getStudentid() != id) {
			return false;
		}
		existing.setStudentName(emailOwner.getStudentName());
		existing.setEmail(emailOwner.getEmail());
		existing.setDepartment(emailOwner.getDepartment());
		existing.setPhoneNumber(emailOwner.getPhoneNumber());
		return true;
		
	}
	
	private Student findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean delete(int id) {
		Student existing = findById(id);
		return existing != null && students.remove(existing);
	}
}
