package be.bxl.icc.reservation.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import be.bxl.icc.reservation.model.Category;
import be.bxl.icc.reservation.model.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	CategoryService service; 
	
	@GetMapping("/category")
	public String index(Model model) {
		List<Category> categorys = service.getAll();
		
		model.addAttribute("category", categorys);
		model.addAttribute("title","Liste des categories");
		
		return "category/index";
	}
	
	@GetMapping("/category/{id}")
    public String show(Model model, @PathVariable("id") String id) {
		Category category = service.getCategory(id);

		model.addAttribute("category", category);
		model.addAttribute("title", "Fiche d'une category");
		
        return "category/show";
    }
	
	@GetMapping("/category/create")
	public String create(Model model) {
		Category category = new Category(null);

	    model.addAttribute("category", category);
		
	    return "category/create";
	}
	
	@PostMapping("/category/create")
	public String store(@Valid @ModelAttribute("category") Category category, BindingResult bindingResult, Model model) {
	    
		System.out.println(category);
	    if (bindingResult.hasErrors()) {
		return "category/create";
	    }    
	    service.add(category);
	    
	    return "redirect:/category/"+category.getId();
	}
	
	
}
