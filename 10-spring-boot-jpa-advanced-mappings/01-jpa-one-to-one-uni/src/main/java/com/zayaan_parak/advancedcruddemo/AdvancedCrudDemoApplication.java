package com.zayaan_parak.advancedcruddemo;

import com.zayaan_parak.advancedcruddemo.dao.AppDAO;
import com.zayaan_parak.advancedcruddemo.entity.Instructor;
import com.zayaan_parak.advancedcruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvancedCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvancedCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> deleteInstructor(appDAO);
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 3;

		System.out.println("Deleting instructor with id: " + id);

		appDAO.deleteById(id);

		System.out.println("Deleted instructor with id: " + id);
	}

	private void findInstructor(AppDAO appDAO) {

		int id = 1;

		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findById(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("Associated instructorDetail only:"  + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {

//		// create the instructor
//		Instructor instructor = new Instructor("Zayaan", "Parak", "zay@zyp.com");
//
//		// create the instructor detail
//		InstructorDetail instructorDetail = new InstructorDetail("https://www.luv2code.com/youtube", "Coding");
//
//		// associate the objects
//		instructor.setInstructorDetail(instructorDetail);

		// create the instructor
		Instructor instructor = new Instructor("Moe", "Akoojee", "moe@zyp.com");

		// create the instructor detail
		InstructorDetail instructorDetail = new InstructorDetail("Designing", "https://www.luv2code.com/youtube");

		// associate the objects
		instructor.setInstructorDetail(instructorDetail);

		// save the instructor
		//
		// NOTE: this will also save the details object because of CascadeType.ALL
		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Instructor saved...");
	}
}
