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

import be.bxl.icc.reservation.model.Type;
import be.bxl.icc.reservation.model.TypeService;


@Controller
public class TypeController {
	@Autowired
	TypeService service;

	@GetMapping("/types")
    public String index2(Model model) {
		List<Type> types = service.getAll();

		model.addAttribute("types", types);
		model.addAttribute("title", "Liste des types");
		
        return "type/index";
    }
	
	@GetMapping("/types/{id}")
    public String show(Model model, @PathVariable("id") String id) {
		Type type = service.getType(id);

		model.addAttribute("type", type);
		model.addAttribute("title", "Fiche d'un type");
		
        return "type/show";
    }
	
	@GetMapping("/type/create")
	public String create(Model model) {
	    Type type = new Type(null);

	    model.addAttribute("type", type);
		
	    return "type/create";
	}
	
	@PostMapping("/type/create")
	public String store(@Valid @ModelAttribute("artist") Type type, BindingResult bindingResult, Model model) {
	    
	    if (bindingResult.hasErrors()) {
		return "type/create";
	    }
		    
	    service.addType(type);
	    
	    return "redirect:/type/"+type.getId();
	}


}
