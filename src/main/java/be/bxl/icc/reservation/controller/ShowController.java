package be.bxl.icc.reservation.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import be.bxl.icc.reservation.model.ArtistType;
import be.bxl.icc.reservation.model.Show;
import be.bxl.icc.reservation.model.ShowService;
import be.bxl.icc.reservation.model.Type;
import javassist.expr.Instanceof;


@Controller
public class ShowController {
	@Autowired
	ShowService service;

	@GetMapping("/shows")
    	public String index(Model model) {
		List<Show> shows = service.getAll();

		model.addAttribute("shows", shows);
		model.addAttribute("title", "Liste des spectacles");
		
        	return "show/index";
    	}
	
	@GetMapping("/shows/{id}")
   	 public String show(Model model, @PathVariable("id") String id) {
		Show show = service.get(id);

		//Récupérer les artistes du spectacle et les grouper par type
        Map<Type,ArrayList<ArtistType>> collaborateurs = new TreeMap<>();
        
//        show.getArtistTypes().forEach((a)->{
//        	if(a.getType() == null) {
//            	collaborateurs.put(a.getType(), new ArrayList<>());
//            }
//            collaborateurs.get(a.getType()).add(a);
//        });
//       
        
        model.addAttribute("collaborateurs", collaborateurs);

		model.addAttribute("show", show);
		model.addAttribute("title", "Fiche d'un spectacle");
		
        	return "show/show";
    	}

}
