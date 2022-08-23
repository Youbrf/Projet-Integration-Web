package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String category;

	
	public Category() {
		super();
	}
	
	public Category(String category) {
		super();
		this.category = category;
	}
	
	@OneToMany(targetEntity = Show.class,mappedBy = "category")
	private List<Show> shows = new ArrayList<>();
	
	
	public List<Show> getShows() {
		return shows;
	}

	public void setShows(List<Show> shows) {
		this.shows = shows;
	}
	
	public Category addShow(Show show) {
		if(!this.shows.contains(show)) {
			this.shows.add(show);
			show.setCategory(this);
		}
		
		return this;
	}
	
	public Category removeShow(Show show) {
		if(this.shows.contains(show)) {
			this.shows.remove(show);
			if(show.getCategory().equals(this)) {
				show.setCategory(null);
			}
		}
		
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
