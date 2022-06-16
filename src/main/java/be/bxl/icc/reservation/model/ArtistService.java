package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistService {
	
	@Autowired
	private ArtistRepository artistRepository;
		
	public List<Artist> getAllArtists() {
		List<Artist> artists = new ArrayList<>();
		
		artistRepository.findAll().forEach(artists::add);
		
		return artists;
	}
	
	public Artist getArtist(String id) {
		int indice = Integer.parseInt(id);
		
		return artistRepository.findById(indice);
	}

	public Artist addArtist(Artist artist) {
		return artistRepository.save(artist);
	}

	public void updateArtist(Long long1, Artist artist) {
		artistRepository.save(artist);
	}

<<<<<<< HEAD
	public void deleteArtist(long id) {
		 long indice =id;
=======
	public void deleteArtist(Long indice2) {
		Long indice = indice2;
>>>>>>> c7157af6537b517182225d6af80df4e914770d67
		
		artistRepository.deleteById(indice);
	}

	
	
}

