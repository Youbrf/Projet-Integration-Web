package be.bxl.icc.reservation.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findByCategory(String category);
	Optional<Category> findById(Long id);
	@Override Iterable<Category> findAll();

	
	
}
