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
	
	@OneToMany(targetEntity=Show.class,mappedBy="category")
	private List<Show> show = new ArrayList<>();	
	
	public List<Show> getShow() {
		return show;
	}
	public void setShow(List<Show> show) {
		this.show = show;
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
