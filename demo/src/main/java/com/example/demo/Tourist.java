package com.example.demo;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
public class Tourist {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	protected String firstName;
	protected String lastName;
	protected String gender;
	protected String country;
	protected String remarks;
	protected Date dateOfBirth;

	
	
	
	 @ManyToMany(fetch=FetchType.LAZY)
	 @JsonManagedReference
	 @JsonIgnore
	  private Collection<Flight> projects;

	  public Tourist() {
	      projects = new ArrayList<Flight>();
	  }
	
	  public Collection<Flight> getProjects() {
	      return projects;
	  }
	  public void addProject(Flight project) {
	      if (!getProjects().contains(project)) {
	          getProjects().add(project);
	      }
	      if (!project.getEmployees().contains(this)) {
	          project.getEmployees().add(this);
	      }
	  }

	 

	
	
	
	
	
	
	
	
//	@ManyToMany
////	@JsonIgnore
//	  @JoinTable(name="TOURIST_FLIGHT", 
//	  joinColumns=@JoinColumn(name="TOURIST_ID"),
//	  inverseJoinColumns=@JoinColumn(name="FLIGHT_ID"))
//	  private Set<Flight> flights = new HashSet<Flight>();
	  
//	@ManyToOne (cascade=CascadeType.ALL)
//	  private Flight flight;
//	  
//	
//	protected Tourist() {
//		
//	}
//	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="tourist",cascade=CascadeType.ALL)
//	private  Set<Flight> flights = new HashSet<Flight>();
//	
//	
//	
	
	
	
	
	
	
	
	public Tourist(Long id, String firstName, String lastName, String gender, String country, String remarks,
			Date dateOfBirth) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.remarks = remarks;
		this.dateOfBirth = dateOfBirth;
	}

	//for old many to maany
	
//	  public Set<Flight> getFlights() {
//		    return flights;
//		  }
//
//		  public void setFlights(Set<Flight> flights) {
//		    this.flights = flights;
//		  }
//	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tourist other = (Tourist) obj;
		if (id != other.id)
			return false;
		return true;
	}

	
//	  @Override
//	  public String toString() {
//	    return "Tourist [id=" + id + ", firstName=" + firstName + ", flights="
//	        + "]";
//	  }
	  public String toString() {
	      return "Employee id: " + getId() +   
	             " with " + getProjects().size() + " projects";
	  }
	
}
