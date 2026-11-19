package com.sms;

import java.lang.ModuleLayer.Controller;

import com.sms.Repository.studentRepository;
import com.sms.controller.StudentController;
import com.sms.service.StudentService;
import com.sms.service.StudentServiceImpl;
import com.sms.view.StudentView;

public class Main {
	public static void main(String[] args) {
		studentRepository repository = new studentRepository();
		
		StudentService service = new StudentServiceImpl(repository);
		
		StudentController controller = new StudentController(service);
		
		StudentView view = new StudentView(controller);
		view.start();
	}
}
