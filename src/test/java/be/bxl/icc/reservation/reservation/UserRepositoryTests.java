package be.bxl.icc.reservation.reservation;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import be.bxl.icc.reservation.model.User;
import be.bxl.icc.reservation.model.UserRepository;


@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback
public class UserRepositoryTests {
	
	
@Autowired

private UserRepository userRepo;
	
	

@Autowired
private TestEntityManager entityManager;


@Test
public void testcreateUser() {
	User user = new User();
	user.setEmail("moussa76b@gmail.com");
	user.setPassword("moussa");
	user.setFirstname("moussa");
	user.setLastname("poisson");
	user.setLangue("fr");
	user.setLogin("moussa");
	user.setCreated_at(LocalDateTime.now());
	
	
	User savedUser=userRepo.save(user);
	User existUser=entityManager.find(User.class, savedUser.getId());
	assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
	
}

@Test
public void testFindUserByEmail() {
	String email = "mou@yahoo.fr";
	
	User user = userRepo.findByEmail(email);
	
	assertThat(user).isNotNull();
}







}
