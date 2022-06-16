package be.bxl.icc.reservation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Column;

import com.github.slugify.Slugify;

@Entity
@Table(name="representations")
public class Representation {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	/**
	 * relation avec la table rooms
	 */
	@ManyToOne
	@JoinColumn(name="room_id", nullable=false)
	private Rooms room;
	
	public Rooms getRoom() {
		return room;
	}

	public void setRoom(Rooms room) {
		this.room = room;
	}


	@ManyToOne
	@JoinColumn(name="show_id", nullable=false)
	private Show show;

	/**
	 * Date de création de la représentation
	 */
	private LocalDateTime when;
	
	
	@ManyToMany
	@JoinTable(
		  name = "reservations", 
		  joinColumns = @JoinColumn(name = "representation_id"), 
		  inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> users = new ArrayList<>();


	public Representation() { }
	
	

	public Representation(Rooms room, Show show, LocalDateTime when) {
		super();
		this.room = room;
		this.show = show;
		this.when = when;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public LocalDateTime getWhen() {
		return when;
	}

	public void setWhen(LocalDateTime when) {
		this.when = when;
	}

	public Long getId() {
		return id;
	}
	public List<User> getUsers() {
		return users;
	}

	public Representation addUser(User user) {
		if(!this.users.contains(user)) {
			this.users.add(user);
			user.addRepresentation(this);
		}
		
		return this;
	}
	
	public Representation removeUser(User user) {
		if(this.users.contains(user)) {
			this.users.remove(user);
			user.getRepresentations().remove(this);
		}
		
		return this;
	}


	@Override
	public String toString() {
		return "Representation [id=" + id + ", room=" + room + ", show=" + show + ", when=" + when + "]";
	}
	
}

