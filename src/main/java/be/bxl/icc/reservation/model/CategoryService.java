package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	

	public Category getCategory(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Category> category = repository.findById(indice); 
		
		return category.isPresent() ? category.get() : null;
	}

	public void add(Category category) {
		repository.save(category);
	}

	public void update(String id, Category category) {
		repository.save(category);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		repository.deleteById(indice);
	}

	public List<Category> getAll() {
		List<Category> categorys = new ArrayList<>();
		
		repository.findAll().forEach(categorys::add);
		
		return categorys;
	}
	
	
}
