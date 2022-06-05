package be.bxl.icc.reservation.reservation;

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

	@Test
	public void testFindByLastname() {
		
		List<Artist>artist = artistRepository.findByLastname("laurent");
		for (Artist p : artist)
		{
		System.out.println(p);
		}
		}
		
	
	@Test
	public void testFindById() {
		
		Long p = artistRepository.findById(1l).getId();
		
		System.out.println(p);
		
		
		}
		}
	
	


