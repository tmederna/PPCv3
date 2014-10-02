package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import com.tmedernach.ppc.jpa.Movie;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import com.tmedernach.ppc.jpa.WebSite;

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
   private Set<WebSite> websites = new HashSet<WebSite>();

   public Set<Movie> getMovies()
   {
      return this.movies;
   }

   public void setMovies(final Set<Movie> movies)
   {
      this.movies = movies;
   }

   public Set<WebSite> getWebsites()
   {
      return this.websites;
   }

   public void setWebsites(final Set<WebSite> websites)
   {
      this.websites = websites;
   }

}
