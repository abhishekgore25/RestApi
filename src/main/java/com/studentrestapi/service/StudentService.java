package com.studentrestapi.service;

import java.util.List;

import com.studentrestapi.dto.StudentDto;

public interface StudentService {

	public String saveStudent(StudentDto studentDto);
	
	public String updateStudent(StudentDto studentDto, int id);
	
	public void deleteStudent(int id);
	
	public StudentDto getStudent(int id);
	
	public List<StudentDto> getAllStudent();
}
