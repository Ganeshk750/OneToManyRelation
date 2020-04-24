package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.model.Student;

import repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;
	
   @Autowired	
   public StudentServiceImpl(StudentRepository studentRepository) {
	   this.studentRepository = studentRepository;
    }
   
	@Override
	public List<Student> studentList() {
		
		return studentRepository.findAll();
	}

	@Override
	public Student findOne(String id) {
		
		return studentRepository.getOne(id);
	}

	@Override
	public Student addStudent(Student student) {
		
		return studentRepository.save(student);
	}

	@Override
	public String deleteStudent(String id) {
		studentRepository.deleteById(id);
		return "{'message':'Student Deleted Successfully'}";
	}

}
