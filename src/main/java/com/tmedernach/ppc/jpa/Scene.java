package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.tmedernach.ppc.jpa.Movie;
import javax.persistence.ManyToOne;
import com.tmedernach.ppc.jpa.WebSite;

@Entity
public class Scene
{

   @Id
   @GeneratedValue
   private Long id;
   
   @ManyToOne
   private Movie movie;

   @ManyToOne
   private WebSite website;

   public Movie getMovie()
   {
      return this.movie;
   }

   public void setMovie(final Movie movie)
   {
      this.movie = movie;
   }

   public WebSite getWebsite()
   {
      return this.website;
   }

   public void setWebsite(final WebSite website)
   {
      this.website = website;
   }

}
