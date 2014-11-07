package com.tmedernach.ppc.jpa.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Website
{

   @Id
   @GeneratedValue
   private Long id;
   
   @ManyToOne
   private Studio studio;

   @OneToMany(mappedBy = "website", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private Set<Scene> scenes = new HashSet<Scene>();

   @Column(length = 256)
   private String siteName;

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

   public String getSiteName()
   {
      return this.siteName;
   }

   public void setSiteName(final String siteName)
   {
      this.siteName = siteName;
   }

   public Long getId() {
	   return id;
   }
	
   public void setId(Long id) {
	   this.id = id;
   }
	
   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (siteName != null && !siteName.trim().isEmpty())
         result += "siteName: " + siteName;
      return result;
   }
   
   public void addScene(Scene s){
	   scenes.add(s);
   }


}
