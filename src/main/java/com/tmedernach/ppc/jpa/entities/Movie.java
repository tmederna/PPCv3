package com.tmedernach.ppc.jpa.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Entity implementation class for Entity: Movie
 *
 */
@Entity
public class Movie implements Serializable
{

   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue
   private Long id;

   @NotNull
   @NotEmpty
   private String movieName;

   @ManyToOne (fetch = FetchType.EAGER)
   private Studio studio;

   
   @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private Set<Scene> scenes = new HashSet<Scene>();

   private int durationInMinutes;

   private String qualityGrade;
   
   private String releaseDate;
   
   @ManyToOne(fetch = FetchType.EAGER)
   private Language language;
   
   public Long getId()
   {
      return id;
   }

   public void setId(Long id)
   {
      this.id = id;
   }

   public String getMovieName()
   {
      return movieName;
   }

   public void setMovieName(String movieName)
   {
      this.movieName = movieName;
   }

   public Movie()
   {
      super();
   }

   public Studio getStudio()
   {
      return this.studio;
   }

   public void setStudio(final Studio studio)
   {
      this.studio = studio;
   }

   public Set<Scene> getScenes()
   {
      return this.scenes;
   }

   public void setScenes(final Set<Scene> scenes)
   {
      this.scenes = scenes;
   }

   public Language getLanguage()
   {
      return this.language;
   }

   public void setLanguage(final Language language)
   {
      this.language = language;
   }
   
   public int getDurationInMinutes() {
		return durationInMinutes;
	}

	public void setDurationInMinutes(int durationInMinutes) {
		this.durationInMinutes = durationInMinutes;
	}

	public String getQualityGrade() {
		return qualityGrade;
	}

	public void setQualityGrade(String qualityGrade) {
		this.qualityGrade = qualityGrade;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void addScene(Scene s){
		scenes.add(s);
	}

}
