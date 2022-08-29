package be.bxl.icc.reservation.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepository extends JpaRepository <Show,Long> {
	Show findBySlug(String slug);
	Show findByTitle(String title);
	List<Show> findByLocation(Location location);
	@Query("SELECT s FROM Show s WHERE s.category.id = ?1")
	List<Show> showByCategory(Long idCat);

	@Query("SELECT s FROM Show s WHERE s.title LIKE %?1%")
	List<Show> search(String keyword);
}

