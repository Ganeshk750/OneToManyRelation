package service;

import java.util.List;

import com.ganesh.model.Student;

public interface StudentService {
	
    List<Student> studentList();
	
	Student findOne(String id);
	
	Student addStudent(Student student);
	
	String deleteStudent(String id);

}
