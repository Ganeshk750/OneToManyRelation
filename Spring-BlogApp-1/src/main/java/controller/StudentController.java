package controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.model.Address;
import com.ganesh.model.Student;

import service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	private StudentService studentService;
	
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping("/list")
	public List<Student> studentList(){
		return studentService.studentList();
	}
	
	@RequestMapping("/list/{id}")
	public Student findOne(@PathVariable Long id) {
		return studentService.findOne(id);
	}
	
	@RequestMapping("/list/{id}")
	public String deleteStudent(@PathVariable Long id) {
	      studentService.deleteStudent(id)
	      return "deleted";
	}
	
	@RequestMapping("/add")
	public Student addStudent(@RequestBody Student student) {
		return studentService.addStudent(student)
	}


}
