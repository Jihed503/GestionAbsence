package com.example.sms.controller;

import com.example.sms.repository.StudentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@Controller
public class StudentController {

	private StudentService studentService;

	private StudentRepository studentRepo;

	public StudentController(StudentService studentService, StudentRepository studentRepo) {
		super();
		this.studentService = studentService;
		this.studentRepo = studentRepo;
	}

//	List all students
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students";
	}


//	add student
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {

		// created student object to hold student form data
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}

//	save student
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}

//	update student from page
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		Student existingStudent = studentService.getStudentById(id);
		model.addAttribute("student", existingStudent);
		return "edit_student";
	}


//	update student actual 
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
								@ModelAttribute("student") Student student, 
								Model model) {
		// Get Student details from database
		Student existingStudent = studentService.getStudentById(id);
		existingStudent.setCin(student.getCin());
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setClasse(student.getClasse());
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		
		return "redirect:/students";
	}
	
	
//	delete student
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudent(id);
		return "redirect:/students";
	}

// search student
	@GetMapping("/search")
	public String searchStudent(//@RequestParam(value = "page", required = false, defaultValue = "0") int pageNumber,
								//@RequestParam(value = "size", required = false, defaultValue = "5") int size,
								Model model,
								@RequestParam(value = "keyWord", defaultValue = "") String keyWord) {
		int pageNumber=0;
		int size=20;
		Page<Student> studentPage = studentRepo.findByNameContains(keyWord, PageRequest.of(pageNumber, size));
		model.addAttribute("students", studentPage.getContent());
		model.addAttribute("pages", new int[studentPage.getTotalPages()]);
		model.addAttribute("currentPage", pageNumber);
		model.addAttribute("keyWord", keyWord);
		return "search";
	}

}
















