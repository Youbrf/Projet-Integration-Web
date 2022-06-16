package be.bxl.icc.reservation.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import be.bxl.icc.reservation.model.Artist;
import be.bxl.icc.reservation.model.Category;
import be.bxl.icc.reservation.model.CategoryService;

@Controller
public class CategoryController {

	
	@Autowired
	CategoryService catService;
	
@GetMapping("/categories")
public String index(Model model) {
	List <Category> categories = catService.getAllCategory();
	
	model.addAttribute("categories", categories);
	model.addAttribute("title","Liste des categories");
	
		return "category/index";
	
}

@GetMapping("/categories/{id}")
public String show(Model model, @PathVariable("id") String id) {
	Category category = catService.getCategory(id);
	
	model.addAttribute("category", category);
	model.addAttribute("title", "Fiche d'une categorie");
		
	    return "category/show";
	}


@GetMapping("/categories/create")
public String create(Model model) {
    Category category = new Category(null);
	
	
    model.addAttribute("category", category);
	
    return "category/create";
}

@PostMapping("/categories/create")
public String store(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
    
    if (bindingResult.hasErrors()) {
	return "category/create";
    }
	    
    catService.addCategory(category);
    
    return "redirect:/categories/"+category.getId();
}

}	
	
	
	
	

