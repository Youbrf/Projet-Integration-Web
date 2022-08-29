package be.bxl.icc.reservation.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import be.bxl.icc.reservation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ShowController {
	@Autowired
	ShowService service;
	@Autowired
	CategoryService categoryService;

	@GetMapping("/shows")
    	public String index(Model model) {
			return findPage(1,"title","asc",model);
    	}

	@RequestMapping("/shows/search")
	public String searchShowByTitle(Model model, @Param("keyword") String keyword) {
		List<Show> listShows = service.listAll(keyword);
		List<Category> listCategory = categoryService.getAllCategory();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("listShows", listShows);
		model.addAttribute("keyword", keyword);

		return "show/index";
	}

	@GetMapping("/shows/page/{pageNo}")
	public String findPage(@PathVariable (value = "pageNo") int pageNo,
						   @RequestParam("sortField") String sortField,
						   @RequestParam("sortDir") String sortDir,
						   Model model){
		int pageSize = 2;

		Page<Show> page = service.findPagination(pageNo,pageSize,sortField,sortDir);
		List<Show> listShows = page.getContent();
		List<Category> listCategory = categoryService.getAllCategory();

		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reserveSortDir", sortDir.equals("asc") ? "desc" : "asc");
		model.addAttribute("listShows", listShows);
		model.addAttribute("listCategory", listCategory);

		return "show/index";
	}

	@GetMapping("/shows/category/{idCategory}")
	public String showByCategory(@PathVariable("idCategory") String idCategory, Model model){
		List<Show> listShows = service.showByCategory(idCategory);
		List<Category> listCategory = categoryService.getAllCategory();
		model.addAttribute("listCategory", listCategory);
		model.addAttribute("listShows", listShows);

		return "show/index";
	}

	@GetMapping("/shows/{id}")
  	 public String show(Model model, @PathVariable("id") String id) {
		Show show = service.get(id);

		//Récupérer les artistes du spectacle et les grouper par type
       Map<Type,ArrayList<ArtistType>> collaborateurs = new TreeMap<>();
       
//       show.getArtistTypes().forEach((a)->{
//       	if(a.getType() == null) {
//           	collaborateurs.put(a.getType(), new ArrayList<>());
//           }
//           collaborateurs.get(a.getType()).add(a);
//       });
//      
       
       model.addAttribute("collaborateurs", collaborateurs);

		model.addAttribute("show", show);
		model.addAttribute("title", "Fiche d'un spectacle");
		
       	return "show/show";
   	}
}
