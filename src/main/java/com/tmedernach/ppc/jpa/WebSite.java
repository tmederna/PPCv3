package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.tmedernach.ppc.jpa.Studio;
import javax.persistence.ManyToOne;
import com.tmedernach.ppc.jpa.Scene;
import java.util.Set;
import java.util.HashSet;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Column;
import java.lang.Override;

@Entity
public class WebSite
{

   @Id
   @GeneratedValue
   private Long id;
   @ManyToOne
   private Studio studio;

   @OneToMany(mappedBy = "website", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   private Set<Scene> scenes = new HashSet<Scene>();

   @Column(length = 100)
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

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (siteName != null && !siteName.trim().isEmpty())
         result += "siteName: " + siteName;
      return result;
   }

}
