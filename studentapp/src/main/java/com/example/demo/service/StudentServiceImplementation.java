package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentServiceImplementation implements StudentService {
    
    @Autowired
    private StudentRepository sr;

    @Override
    public String addStudent(Student student) {
        sr.save(student);
        return "Student added";
    }


	@Override
	public List<Student> fetchAllStudents() {
		
		return sr.findAll();
	}



	@Override
	public void deleteStudentById(Long id) {
		
		sr.deleteById(id);

	
}


	@Override
	public Student getStudentById(Long id) {
		
		return sr.findById(id).get();
	}


	@Override
	public Student updateStudent(Student student) {
		
		return sr.save(student);
	}


	



}