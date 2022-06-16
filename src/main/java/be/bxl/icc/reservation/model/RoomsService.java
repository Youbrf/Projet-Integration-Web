package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomsService {
	@Autowired
	private RoomsRepository repository;
	

	public List<Rooms> getAll() {
		List<Rooms> rooms = new ArrayList<>();
		
		repository.findAll().forEach(rooms::add);
		
		return rooms;
	}
	
	public Rooms get(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Rooms> rooms = repository.findById(indice); 
		
		return rooms.isPresent() ? rooms.get() : null;
	}

	public void add(Rooms rooms) {
		repository.save(rooms);
	}

	public void update(String id, Rooms rooms) {
		repository.save(rooms);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		repository.deleteById(indice);
	}
	public List<Rooms> getFromLocation(Location location) {
		return repository.findByLocation(location);
	}
}
