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

	public void updateArtist(String id, Artist artist) {
		artistRepository.save(artist);
	}

	public void deleteArtist(long id) {
		 long indice =id;
		
		artistRepository.deleteById(indice);
	}

	
	
}

