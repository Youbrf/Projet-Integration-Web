package be.bxl.icc.reservation.model;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RoomsRepository extends CrudRepository<Rooms, Long> {

	Optional<Rooms> findById(Long id);
	Rooms findByName(String name);
	
	

}
