package com.developers.onetoone.runner;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.developers.onetoone.entity.Passport;
import com.developers.onetoone.entity.Person;
import com.developers.onetoone.repository.PersonRepo;

import lombok.extern.slf4j.Slf4j;

//WHEN YOU WANT TO EXECUTE RUNNER THEN UN-COMMENT @COMPONENT THEN IT WILL EXECUTE WHEN PROJECT STARTS
@Slf4j
//@Component
public class DataInitializer implements ApplicationRunner {

	@Autowired
	private PersonRepo personRepo;

	private Logger logger = LoggerFactory.getLogger(DataInitializer.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {

		logger.info(
				"******  ******  ****** ******  application runner execution starts   ******  ******  ****** ******  ");
		Passport passport = new Passport();
		passport.setVoterId("VOTER123");
		passport.setDob(LocalDate.of(1990, 5, 20));
		passport.setPassportNumber("P123456789");

		Person person = new Person();
		person.setPName("John Doe");
		person.setEmailId("john.doe@example.com");
		person.setPhNo("1234567890");
		person.setPsport(passport); // Set the relationship.

		personRepo.save(person); // Save the person, and the passport will be saved due to cascading
		logger.info(
				"\"******  ******  ****** ******   application runner execution ends  ******  ******  ****** ******  ");

	}

}
