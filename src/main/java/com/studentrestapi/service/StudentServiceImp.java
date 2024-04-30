package com.studentrestapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.studentrestapi.dto.StudentDto;
import com.studentrestapi.entity.StudentEntity;
import com.studentrestapi.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Override
	public String saveStudent(StudentDto studentDto) 
	{
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		StudentEntity studentEntity = objectMapper.convertValue(studentDto, StudentEntity.class);
		studentRepository.save(studentEntity);
		return "Successfully saved";
	}

	@Override
	public String updateStudent(StudentDto studentDto, int id) 
	{
		studentDto.setId(id);
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		StudentEntity studentEntity = objectMapper.convertValue(studentDto, StudentEntity.class);
		studentRepository.save(studentEntity);
		System.out.println(studentEntity.getName());
		return "updated Successfully";
	}

	@Override
	public void deleteStudent(int id) 
	{
		studentRepository.deleteById(id);
	}

	@Override
	public StudentDto getStudent(int id) 
	{
		Optional<StudentEntity> optional = studentRepository.findById(id);
		StudentEntity studentEntity =optional.get();
		objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		StudentDto studentDto = objectMapper.convertValue(studentEntity, StudentDto.class);
		return studentDto;
	}

	@Override
	public List<StudentDto> getAllStudent() {
		List<StudentEntity> list = studentRepository.findAll();
		List<StudentDto> dtoList = new ArrayList<>();
		
		for(StudentEntity studentEntity: list) 
		{
			objectMapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
			StudentDto studentDto = objectMapper.convertValue(studentEntity, StudentDto.class);
			dtoList.add(studentDto);
		}
		return dtoList;
	}

}
