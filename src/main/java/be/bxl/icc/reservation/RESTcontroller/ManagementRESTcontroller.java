package be.bxl.icc.reservation.RESTcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import be.bxl.icc.reservation.model.Artist;
import be.bxl.icc.reservation.model.ArtistService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class ManagementRESTcontroller {
	
	@Autowired
	ArtistService artistService;
	
	
	@RequestMapping(method = RequestMethod.GET)
	 List<Artist>getAllArtists()
	 {
		return artistService.getAllArtists();
		
	 }
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	 public Artist getArtist(@PathVariable("id")String id)
	 {
		return artistService.getArtist(id); 
		
	 }
	
		/*
		 * @RequestMapping(method = RequestMethod.POST) public Artist
		 * addArtist(@RequestBody Artist artist) { return
		 * artistService.addArtist(artist);
		 * 
		 * }
		 */
	

}
