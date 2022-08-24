package be.bxl.icc.reservation.model;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface RepresentationRepository extends CrudRepository<Representation, Long> {
	List<Representation> findByShow(Show show);
	
	List<Representation> findByWhen(LocalDateTime when);
}
