package be.bxl.icc.reservation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotEmpty(message = "The category must not be empty.")
	@Size(min=2, max=10, message = "The category must be between 2 and 10 characters long.")
	private String category;
	
	@OneToMany(targetEntity=Show.class,mappedBy="category")
	private List<Show> shows = new ArrayList<>();	
	
	public List<Show> getShow() {
		return shows;
	}
	public void setShow(List<Show> show) {
		this.shows = show;
	}
	
	public Category addshow(Show show) {
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
	
	public Category() {
		super();
	}
	public Category(String category) {
		this.category = category;
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", category=" + category + "]";
	}

}
