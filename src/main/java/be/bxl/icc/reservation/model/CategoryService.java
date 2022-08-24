package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository catRepo;
	
	
	public List<Category> getAllCategory(){
		
		List<Category>categories=new ArrayList<>();
		catRepo.findAll().forEach(categories::add);		
		
		return categories;
		
	}
	
	 public Category getCategory(String id) {
	        Long indice = (long) Integer.parseInt(id);
	        Optional<Category> category = catRepo.findById(indice); 

	        return category.isPresent() ? category.get() : null;
	    }
	
	public Category addCategory(Category category) {
		return catRepo.save(null);
		
	}
	
	public Category updateCategory(Long id ,Category category) {
		return catRepo.save(null);
		
	}
	
	public void deleteCategoryById(Long id) {
		catRepo.deleteById(id);
	
	}


	public void deleteCategory(Category category) {
	
		catRepo.delete(category);
	}
	
	
	
	
	
	
	
}
