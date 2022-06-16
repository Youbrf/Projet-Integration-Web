package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="rooms")
public class Rooms {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private int seats;
	
	/**
	 * relation avec la table representation
	 */
	@OneToMany(targetEntity=Representation.class, mappedBy="room")
	private List<Representation> representations = new ArrayList<>();

	public List<Representation> getRepresentations() {
		return representations;
	}

	public Rooms addRepresentation(Representation representation) {
		if(!this.representations.contains(representation)) {
			this.representations.add(representation);
			representation.setRoom(this);
		}
		
		return this;
	}
	
	public Rooms removeRepresentation(Representation representation) {
		if(this.representations.contains(representation)) {
			this.representations.remove(representation);
		}
		
		return this;
	}
	
	/**
	 * relation avec la table location
	 */
	@ManyToOne
	@JoinColumn(name="location_id", nullable=true)
	private Location location;
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location.removeRooms(this);	
		this.location = location;
		this.location.addRooms(this);		
	}
	
	
	public Rooms() {
		super();
	}

	public Rooms(String name, int seats, Location location) {
		super();
		this.name = name;
		this.seats = seats;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Rooms [id=" + id + ", name=" + name + ", seats=" + seats + ", location=" + location + "]";
	}
	
	
	
	
}
