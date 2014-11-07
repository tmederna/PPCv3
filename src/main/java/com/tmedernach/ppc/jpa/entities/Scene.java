package com.tmedernach.ppc.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

import com.tmedernach.ppc.jpa.entities.Movie;
import com.tmedernach.ppc.jpa.entities.Website;

@XmlRootElement
@Entity
public class Scene
{

   @Id
   @GeneratedValue
   private Long id;
   
   private String descriptiveTitle;
   
   @ManyToOne
   private Movie movie;
   
   private int nbrInMovie;

   @ManyToOne
   private Website website;
   
   private String descriptionOnSite;
   
   private int males;
   
   private int females;
   
   private String globalRating;
   
   private int durationInMinutes;

   public String getDescriptionOnSite() {
	return descriptionOnSite;
}

	public void setDescriptionOnSite(String descriptionOnSite) {
		this.descriptionOnSite = descriptionOnSite;
	}
	
	public int getMales() {
		return males;
	}
	
	public void setMales(int males) {
		this.males = males;
	}
	
	public int getFemales() {
		return females;
	}
	
	public void setFemales(int females) {
		this.females = females;
	}
	
	public String getGlobalRating() {
		return globalRating;
	}
	
	public void setGlobalRating(String globalRating) {
		this.globalRating = globalRating;
	}
	
	public int getDurationInMinutes() {
		return durationInMinutes;
	}
	
	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}
	
	public Movie getMovie()
   {
      return this.movie;
   }

   public void setMovie(final Movie movie)
   {
      this.movie = movie;
   }

   public Website getWebsite()
   {
      return this.website;
   }

   public void setWebsite(final Website website)
   {
      this.website = website;
   }

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDescriptiveTitle() {
		return descriptiveTitle;
	}
	
	public void setDescriptiveTitle(String descriptiveTitle) {
		this.descriptiveTitle = descriptiveTitle;
	}
	
	public int getNbrInMovie() {
		return nbrInMovie;
	}
	
	public void setNbrInMovie(int nbrInMovie) {
		this.nbrInMovie = nbrInMovie;
	}

}
