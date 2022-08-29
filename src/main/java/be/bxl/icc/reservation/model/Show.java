package be.bxl.icc.reservation.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.slugify.Slugify;

@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(unique=true)
	private String slug;

	private String title;
	private String description;

	@Column(name="poster_url")
	private String posterUrl;
	
	  
	  @ManyToOne
	  @JsonIgnore
	  @JoinColumn(name="category_id", nullable=true)
	  private Category category;
	 
	
	/**
	 * Lieu de création du spectacle
	 */
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name="location_id", nullable=true)
	private Location location;
	
	@ManyToMany(mappedBy = "shows")
	private List<ArtistType> artistTypes = new ArrayList<>();

	/**
     * Get the performances (artists in a type of collaboration) for the show
     */
	public List<ArtistType> getArtistTypes() {
		return artistTypes;
	}

	public Show addArtistType(ArtistType artistType) {
		if(!this.artistTypes.contains(artistType)) {
			this.artistTypes.add(artistType);
			artistType.addShow(this);
		}
		
		return this;
	}
	
	public Show removeArtistType(ArtistType artistType) {
		if(this.artistTypes.contains(artistType)) {
			this.artistTypes.remove(artistType);
			artistType.getShows().remove(this);
		}
		
		return this;
	}

	
	private boolean bookable;
	private double price;
	
	/**
	 * Date de création du spectacle
	 */
	@Column(name="created_at")
	private LocalDateTime createdAt;
	
	/**
	 * Date de modification du spectacle
	 */
	@Column(name="updated_at")
	private LocalDateTime updatedAt;

	@OneToMany(targetEntity=Representation.class, mappedBy="show")
	private List<Representation> representations = new ArrayList<>();

	public List<Representation> getRepresentations() {
		return representations;
	}

	/*
	 * public Show addRepresentation(Representation representation) {
	 * if(!this.representations.contains(representation)) {
	 * this.representations.add(representation); representation.setShow(this); }
	 * 
	 * return this; }
	 * 
	 * public Show removeRepresentation(Representation representation) {
	 * if(this.representations.contains(representation)) {
	 * this.representations.remove(representation);
	 * if(representation.getLocation().equals(this)) {
	 * representation.setLocation(null); } }
	 
		
		return this;
	}*/

	public Show() { }
	
	public Show(String title, String description, String posterUrl, Location location, boolean bookable,
			double price) {
		Slugify slg = new Slugify();
		
		this.slug = slg.slugify(title);
		this.title = title;
		this.description = description;
		this.posterUrl = posterUrl;
		this.location = location;
		this.bookable = bookable;
		this.price = price;
		this.createdAt = LocalDateTime.now();
		this.updatedAt = null;
	}


	public Long getId() {
		return id;
	}

	public String getSlug() {
		return slug;
	}

	private void setSlug(String slug) {
		this.slug = slug;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
		
		Slugify slg = new Slugify();
		
		this.setSlug(slg.slugify(title));
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPosterUrl() {
		return posterUrl;
	}

	public void setPosterUrl(String posterUrl) {
		this.posterUrl = posterUrl;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location.removeShow(this);	//déménager de l’ancien lieu
		this.location = location;
		this.location.addShow(this);		//emménager dans le nouveau lieu
	}

	public boolean isBookable() {
		return bookable;
	}

	public void setBookable(boolean bookable) {
		this.bookable = bookable;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", slug=" + slug + ", title=" + title 
			+ ", description=" + description + ", posterUrl=" + posterUrl + ", location=" 
			+ location + ", bookable=" + bookable + ", price=" + price
			+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt 
			+ ", representations=" + representations.size() + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category.removeShow(this);
		this.category = category;
		this.category.addShow(this);
	}

	

	
}