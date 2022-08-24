

package be.bxl.icc.reservation.controller;

import java.util.ArrayList;
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
import be.bxl.icc.reservation.model.Rooms;
import be.bxl.icc.reservation.model.RoomsService;

@Controller
public class RoomsController {
	
	
	@Autowired
	private RoomsService roomService;

	@GetMapping("/rooms")
	public String index(Model model) {
		List <Rooms> rooms = roomService.getAllRooms();
		
		model.addAttribute("rooms", rooms);
		model.addAttribute("title","Liste des places");
		
			return "room/index";
		
	}

	@GetMapping("/rooms/{id}")
	public String show(Model model, @PathVariable("id") String id) {
		Rooms room = roomService.getRooms(id);
		
		model.addAttribute("room", room);
		model.addAttribute("title", "Fiche d'une salle");
			
		    return "room/show";
		}


	    @GetMapping("/rooms/create")
		public String create(Model model) {
			Rooms room = new Rooms();
			model.addAttribute( "room", room);

			List<Rooms> roomList = roomService.getAllRooms();

			List<String> roomName = new ArrayList<String>();
		    for(int i=0; i<roomList.size(); i++) {
		        roomName.add(roomList.get(i).getName().toString());
		    }

		    
			model.addAttribute("roomname", roomName);
			return "room/create";
	    
	}

	@PostMapping("/room/create")
	public String store(@Valid @ModelAttribute("room") Rooms room, BindingResult bindingResult, Model model) {
	    
	    if (bindingResult.hasErrors()) {
		return "room/create";
	    }
		    
	    roomService.addRoom(room);
	    
	    return "redirect:/rooms/"+room.getId();
	}

	}	
		
		
	
	

