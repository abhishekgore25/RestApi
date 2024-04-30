package com.studentrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentrestapi.dto.StudentDto;
import com.studentrestapi.service.StudentService;

@RestController
@RequestMapping(path = "/api/v1/student")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@PostMapping("/save")
	public String saveStudent(StudentDto studentDto) 
	{
		System.out.println(studentDto);
		return studentService.saveStudent(studentDto);
	}
	
	@PutMapping("/update")
	public String updateStudent(StudentDto studentDto, int id)
	{
		return studentService.updateStudent(studentDto, id);
	}
	
	@DeleteMapping("/delete")
	public void deleteStudent(int id)
	{
		studentService.deleteStudent(id);
	}
	
	@GetMapping("/get/{id}")
	public StudentDto getStudent(@PathVariable int id) 
	{
		System.out.println(id);
		return studentService.getStudent(id);
	}
	
	@GetMapping("/get")
	public List<StudentDto> getAllStudent() 
	{
		return studentService.getAllStudent();
	}
}
