package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
	
	
	@Autowired
	private RoomsRepository roomsRepo;
	
		
	
public List<Rooms> getAllRooms(){
		
		List<Rooms>rooms=new ArrayList<>();
		roomsRepo.findAll().forEach(rooms::add);		
		
		return rooms;
		
	}
	
	 public Rooms getRooms(String id) {
	        Long indice = (long) Integer.parseInt(id);
	        Optional<Rooms> room = roomsRepo.findById(indice); 

	        return room.isPresent() ? room.get() : null;
	    }
	
	public Rooms addRoom(Rooms room) {
		return roomsRepo.save(null);
		
	}
	
	public Rooms updateRoom(Long id ,Rooms room) {
		return roomsRepo.save(room);
		
	}
	
	public void deleteRoomById(Long id) {
		roomsRepo.deleteById(id);
	
	}


	public void deleteRoom(Rooms room) {
	
		roomsRepo.delete(room);
	}
	
	
	
	

}
