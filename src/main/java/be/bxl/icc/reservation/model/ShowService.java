package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ShowService {
	@Autowired
	private ShowRepository repository;


	public List<Show> getAll() {
		List<Show> shows = new ArrayList<>();
		repository.findAll().forEach(shows::add);
		return shows;
	}

	public List<Show> listAll(String keyword) {
		if (keyword != null) {
			return repository.search(keyword);
		}
		return repository.findAll();
	}
	
	public Show get(String id) {
		Long indice = (long) Integer.parseInt(id);
		Optional<Show> show = repository.findById(indice); 
		
		return show.isPresent() ? show.get() : null;
	}

	public void add(Show show) {
		repository.save(show);
	}

	public void update(String id, Show show) {
		repository.save(show);
	}

	public void delete(String id) {
		Long indice = (long) Integer.parseInt(id);
		
		repository.deleteById(indice);
	}

	public  List<Show> showByCategory(String idCat){
		Long indice = (long) Integer.parseInt(idCat);
		return repository.showByCategory(indice);
	}

	public Page<Show> findPagination(int pageNo,int pageSize, String sortField, String sortDirection){
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending(): Sort.by(sortField).descending();

		Pageable pageable = PageRequest.of(pageNo-1,pageSize, sort);
		return this.repository.findAll(pageable);
	}
	public List<Show> getFromLocation(Location location) {
		return repository.findByLocation(location);
	}
}
