package be.bxl.icc.reservation.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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
	public String store(@Valid @ModelAttribute("type") Type type, BindingResult bindingResult, Model model) {
	    
	    if (bindingResult.hasErrors()) {
		return "type/create";
	    }
		    
	    service.addType(type);
	    
	    return "redirect:/type/"+type.getId();
	}
	
	@GetMapping("/types/{id}/edit")
	public String edit(Model model, @PathVariable("id") String id, HttpServletRequest request) {
		Type type = service.getType(id);

		model.addAttribute("type", type);


		//Générer le lien retour pour l'annulation
	String referrer = request.getHeader("Referer");

		if(referrer!=null && !referrer.equals("")) {
			model.addAttribute("back", referrer);
		} else {
			model.addAttribute("back", "/type/"+type.getId());
		}
		
		return "type/edit";
	}
	
	@PutMapping("/types/{id}/edit")
	public String update(@Valid @ModelAttribute("type") Type type, BindingResult bindingResult, @PathVariable("id") String id, Model model) {
	    
		if (bindingResult.hasErrors()) {
			return "types/edit";
		}
		
		Type existing = service.getType(id);
		
		if(existing==null) {
			return "type/index";
		}
		
		Long indice = (long) Integer.parseInt(id);
		
		type.setId(indice);
	    	service.updateType(id,type);
	    
		model.addAttribute("type", type);
	    
		return "redirect:/types/"+type.getId();
	}



}
