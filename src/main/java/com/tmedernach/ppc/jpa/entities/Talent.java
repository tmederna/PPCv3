package com.tmedernach.ppc.jpa.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.util.Set;
import java.util.HashSet;

import com.tmedernach.ppc.jpa.entities.TalentName;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import java.lang.Override;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Talent
{

   @Id
   @GeneratedValue
   private Long id;
   @OneToMany(mappedBy = "associatedPerson", cascade = CascadeType.ALL)
   private Set<TalentName> aliases = new HashSet<TalentName>();

   @Column(length = 50)
   private String primaryName;

   @Temporal(TemporalType.DATE)
   private Date birthday;

   public Set<TalentName> getAliases()
   {
      return this.aliases;
   }

   public void setAliases(final Set<TalentName> aliases)
   {
      this.aliases = aliases;
   }

   public String getPrimaryName()
   {
      return this.primaryName;
   }

   public void setPrimaryName(final String primaryName)
   {
      this.primaryName = primaryName;
   }

   public Date getBirthday()
   {
      return this.birthday;
   }

   public void setBirthday(final Date birthday)
   {
      this.birthday = birthday;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (primaryName != null && !primaryName.trim().isEmpty())
         result += "primaryName: " + primaryName;
      return result;
   }

}
