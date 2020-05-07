package com.ganesh;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ganesh.model.Employee;
import com.ganesh.model.Skill;
import com.ganesh.repository.EmployeeRepository;
import com.ganesh.repository.SkillRepository;

@SpringBootApplication
public class ManyToManyImplApplication implements CommandLineRunner {
	
	private SkillRepository skillRepo;
	
	private EmployeeRepository empRepo;
	
	public ManyToManyImplApplication(SkillRepository skillRepo, EmployeeRepository empRepo) {
		this.skillRepo = skillRepo;
		this.empRepo = empRepo;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ManyToManyImplApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Skill s1 = new Skill();
		s1.setId(1);
		s1.setSkillDesc("Java");
		
		Skill s2 = new Skill();
		s2.setId(2);
		s2.setSkillDesc("Spring");
		
		Skill s3 = new Skill();
		s3.setId(3);
		s3.setSkillDesc("C++");
		
		Skill s4 = new Skill();
		s4.setId(4);
		s4.setSkillDesc("SQL");
		
		
	    skillRepo.saveAll(Arrays.asList(s1, s2, s3, s4));
		

		Employee e1 = new Employee();
		e1.setId(101);
		e1.setFristName("Ganesh");
		e1.setLastName("Kumar");
		e1.addSkill(s1);
		e1.addSkill(s2);
		

		Employee e2 = new Employee();
		e2.setId(102);
		e2.setFristName("Shashi");
		e2.setLastName("Kumar");
		e2.addSkill(s2);
		e2.addSkill(s3);
		

		Employee e3 = new Employee();
		e3.setId(103);
		e3.setFristName("Vishal");
		e3.setLastName("Kumar");
		e3.addSkill(s1);
		e3.addSkill(s2);
		e3.addSkill(s4);
		
		empRepo.saveAll(Arrays.asList(e1, e2, e3));
		
		
		
		
		
	}

}
