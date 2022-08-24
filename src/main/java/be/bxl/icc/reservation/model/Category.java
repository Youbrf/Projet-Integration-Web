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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "category")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty(message = "the category's name must not be empty")
		private String name;

	@OneToMany(targetEntity = Show.class, mappedBy = "category")
	private List<Show> shows = new ArrayList<>();

	public Category(String name) {
		this.name = name;
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


}
