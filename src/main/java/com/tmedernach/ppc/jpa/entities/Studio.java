package com.tmedernach.ppc.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
@Entity
public class Studio
{

   @Id
   @GeneratedValue
   private Long id;

   @NotNull
   @NotEmpty
   private String studioName;

   @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private Set<Movie> movies = new HashSet<Movie>();

   @OneToMany(mappedBy = "studio", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
   private Set<Website> websites = new HashSet<Website>();

   public Set<Movie> getMovies()
   {
      return this.movies;
   }

   public void setMovies(final Set<Movie> movies)
   {
      this.movies = movies;
   }

   public Set<Website> getWebsites()
   {
      return this.websites;
   }

   public void setWebsites(final Set<Website> websites)
   {
      this.websites = websites;
   }

public String getStudioName() {
	return studioName;
}

public void setStudioName(String studioName) {
	this.studioName = studioName;
}

	public void addMovie(Movie m){
		movies.add(m);
	}

}
