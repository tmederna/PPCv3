package com.tmedernach.ppc.jpa;

import javax.persistence.Entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

import java.lang.Override;

import com.tmedernach.ppc.jpa.Talent;

import javax.persistence.ManyToOne;
import javax.persistence.FetchType;

@SuppressWarnings("serial")
@Entity
public class TalentName implements Serializable
{

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name = "id", updatable = false, nullable = false)
   private Long id = null;
   @Version
   @Column(name = "version")
   private int version = 0;

   @ManyToOne(fetch = FetchType.EAGER, optional = false)
   private Talent associatedPerson;

   @Column(length = 30)
   private String alias;

   public Long getId()
   {
      return this.id;
   }

   public void setId(final Long id)
   {
      this.id = id;
   }

   public int getVersion()
   {
      return this.version;
   }

   public void setVersion(final int version)
   {
      this.version = version;
   }

   @Override
   public boolean equals(Object that)
   {
      if (this == that)
      {
         return true;
      }
      if (that == null)
      {
         return false;
      }
      if (getClass() != that.getClass())
      {
         return false;
      }
      if (id != null)
      {
         return id.equals(((TalentName) that).id);
      }
      return super.equals(that);
   }

   @Override
   public int hashCode()
   {
      if (id != null)
      {
         return id.hashCode();
      }
      return super.hashCode();
   }

   public Talent getAssociatedPerson()
   {
      return this.associatedPerson;
   }

   public void setAssociatedPerson(final Talent associatedPerson)
   {
      this.associatedPerson = associatedPerson;
   }

   public String getAlias()
   {
      return this.alias;
   }

   public void setAlias(final String alias)
   {
      this.alias = alias;
   }

   @Override
   public String toString()
   {
      String result = getClass().getSimpleName() + " ";
      if (alias != null && !alias.trim().isEmpty())
         result += "alias: " + alias;
      return result;
   }
}