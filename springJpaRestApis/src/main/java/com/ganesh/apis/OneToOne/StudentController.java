package com.ganesh.apis.OneToOne;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class StudentController {
	
	private StudentRespository studentRepo;
	
	public StudentController(StudentRespository studentRepo) {
		this.studentRepo = studentRepo;
	}

	
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		return studentRepo.findAll();
	}
	
	@GetMapping("/students/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(value="id") Long studentId) throws ResourceNotFoundException {
		
		Student std = studentRepo.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student Not Found ::"+ studentId));
				return ResponseEntity.ok().body(std);
		
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student, @RequestBody School school) {
		return studentRepo.save(student);
		
	}
	
	
	
	@PutMapping("/students/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(value="id") Long stuId, @RequestBody Student student) throws ResourceNotFoundException {
		Student stu = studentRepo.findById(stuId)
				    .orElseThrow(() -> new ResourceNotFoundException("Student Not Found:: "+ stuId));
		
		  stu.setFirstName(student.getFirstName());
		  stu.setLastName(student.getLastName());
		  stu.setEmail(student.getEmail());
		  
		  Student updatedStudent = studentRepo.save(stu);
		  return ResponseEntity.ok().body(updatedStudent);
	}
	
	
	@DeleteMapping("/students/{id}")
	public Map<String, Boolean> deleteStudentById(@PathVariable(value="id") Long id) throws ResourceNotFoundException {
	   
		Student student = studentRepo.findById(id)
				          .orElseThrow(() -> new ResourceNotFoundException("Student Not Found:: "+ id));
		
		
		studentRepo.delete(student);
		Map<String, Boolean> map = new HashMap<>();
		map.put("Student Deleted", Boolean.TRUE);
		return map;
		
				 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
