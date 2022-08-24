package be.bxl.icc.reservation.model;




import java.util.Optional;

import org.springframework.data.repository.CrudRepository;



public interface CategoryRepository extends CrudRepository<Category, Long> {

	
	Optional<Category> findById(Long id);
	Category findByName(String name);
	
	

}
