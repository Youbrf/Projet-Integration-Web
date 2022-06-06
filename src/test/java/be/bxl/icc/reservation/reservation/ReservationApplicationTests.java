package be.bxl.icc.reservation.reservation;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import be.bxl.icc.reservation.model.Artist;
import be.bxl.icc.reservation.model.ArtistRepository;

@SpringBootTest
class ReservationApplicationTests {

	@Autowired
	private ArtistRepository artistRepository;

	
	  @Test public void testFindByLastname() {
	  
	  List<Artist> artist = artistRepository.findByLastname("laurent"); for (Artist
	  p : artist) { System.out.println(p); } }
	  
	  @Test public void testFindById() { Long p =
	  artistRepository.findById(1l).getId(); System.out.println(p); }
	  
	  @Test public void testFindByIdArtistContains() { boolean
	  p=artistRepository.existsById(1l); System.out.println(p); }
	  
	  @Test public void testUpdateArtist() { Artist p =
	  artistRepository.findById(1L); p.setFirstname("michel");
	  artistRepository.save(p); }
	  
	  @Test public void testListerTousArtist() { List<Artist> art = (List<Artist>)
	  artistRepository.findAll(); for (Artist p : art) { System.out.println(p); } }
	 
	
	
	
	
	}

