package be.bxl.icc.reservation.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	User findByEmail(String email);

	User findById(long id);
	User findByLogin(String login);
	
}

