package be.bxl.icc.reservation.model;

<<<<<<< HEAD



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	User findByEmail(String email);

	User findById(long id);
	User findByLogin(String login);
	
}
=======
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByLastname(String lastname);

	User findById(long id);
	User findByLogin(String login);
	User findByEmail(String email);
}
>>>>>>> c7157af6537b517182225d6af80df4e914770d67
