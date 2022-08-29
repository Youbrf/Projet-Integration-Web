package be.bxl.icc.reservation.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import be.bxl.icc.reservation.model.Show;
import be.bxl.icc.reservation.model.ShowService;


	@RestController
	@RequestMapping("/api/shows")
	@CrossOrigin
	
		public class ApiShow {
	
		@Autowired
		ShowService showService;
		
		
		@RequestMapping(method = RequestMethod.GET)
		 List<Show>getAllShows()
		 {
			return showService.getAll();
			
		 }
		
		@RequestMapping(value="/{id}",method = RequestMethod.GET)
		 public Show getShow(@PathVariable("id")String id)
		 {
			return showService.get(id); 
			
		 }
		
			/*
			 * @RequestMapping(method = RequestMethod.POST) public Artist
			 * addArtist(@RequestBody Artist artist) { return
			 * artistService.addArtist(artist);
			 * 
			 * }
			 */
		

	}



