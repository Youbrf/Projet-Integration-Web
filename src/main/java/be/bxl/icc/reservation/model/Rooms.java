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
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rooms")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Rooms {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "the category's name must not be empty")
		private String name;
	
	
	private int seats;


	 @ManyToOne
	  @JoinColumn(name="location_id", nullable=true)
	  private Location location;

	 @OneToMany(targetEntity = Representation.class, mappedBy = "room")
		private List<Representation> representations = new ArrayList<>();
	 
	

	 public Rooms(String name,int seats) {
			this.name = name;
			this.seats=seats;
		}
	 public Rooms addRepresentation(Representation representation) {
			if(!this.representations.contains( representation)) {
				this.representations.add( representation);
				 representation.setRoom(this);
				
			}
			return this;
				}
		
		public Rooms removeShow(Representation representation) {
			if(this.representations.contains(representation)) {
				this.representations.remove(representation);
				if(representations.get(seats).equals(this)) {
					representation.setRoom(null);
				}
			}
			
			return this;
		}

public void setLocation(Location location) {
	this.location.removeSeat(this);
	this.location = location;
	this.location.addSeat(this);
}
}