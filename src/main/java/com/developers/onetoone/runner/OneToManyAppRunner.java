package com.developers.onetoone.runner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.developers.onetomany.entity.Address;
import com.developers.onetomany.entity.User;
import com.developers.onetomany.repository.IUserRepo;

// WHEN YOU WANT TO EXECUTE RUNNER THEN UN-COMMENT @COMPONENT THEN IT WILL EXECUTE WHEN PROJECT STARTS
//@Component
public class OneToManyAppRunner implements CommandLineRunner {

	@Autowired
	private IUserRepo userRepo;

	@Override
	public void run(String... args) throws Exception {
		Address a1 = new Address();
		a1.setCity("Hyd");
		a1.setState("TG");
		a1.setType("Present");

		Address a2 = new Address();
		a2.setCity("Guntur");
		a2.setState("AP");
		a2.setType("Permanent");

		User e = new User();
		e.setName("Ashok");
		e.setPhNo("782510");

		/*
		 * // associating emp obj to address data a1.setUser(e); a2.setUser(e);
		 */

		List<Address> addressesList = Arrays.asList(a1, a2);

		// associating addresses objs to emp data
		e.setAddr(addressesList);

		userRepo.save(e);

	}

	public User getEmp(int id) {
		Optional<User> byId = userRepo.findById(id);
		return byId.get();
	}

}
