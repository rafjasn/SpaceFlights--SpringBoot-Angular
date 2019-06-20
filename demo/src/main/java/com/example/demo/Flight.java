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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Flight {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected Long id;
	
	protected Date arrivalDate;
	protected Date departureDate;
	protected Long numberOfSeats;
	protected Double price;

	
	@ManyToMany(mappedBy="projects", fetch=FetchType.LAZY) 
	 @JsonBackReference
	 
    private Collection<Tourist> employees;

    public Flight() {
        employees = new ArrayList<Tourist>();
    }
	
    public Collection<Tourist> getEmployees() {
        return employees;
    }
	
    
    public void addEmployee(Tourist employee) {
        if (!getEmployees().contains(employee)) {
            getEmployees().add(employee);
        }
        if (!employee.getProjects().contains(this)) {
            employee.getProjects().add(this);
        }
    }
	
//	@ManyToMany
////	@JsonIgnore
//	  private Set<Tourist> tourists = new HashSet<Tourist>();
//	  
	
//	
//	@OneToMany(fetch=FetchType.LAZY ,mappedBy="flight",cascade=CascadeType.ALL)
//	private  Set<Tourist> tourists = new HashSet<Tourist>();
//	
//	
//	@ManyToOne (cascade=CascadeType.ALL)
//	  private Tourist tourist;
	 
//	
//	protected Flight() {
//		
//	}
//	



	public Flight(Long id,Date arrivalDate, Date departureDate, Long numberOfSeats, Double price,
			Set<Tourist> tourists) {
		super();
		this.id = id;
		this.arrivalDate = arrivalDate;
		this.departureDate = departureDate;
		this.numberOfSeats = numberOfSeats;
		this.price = price;
	//	this.tourists = tourists;
	}


//for old manytomany


//
//	  public Set<Tourist> getTourists() {
//		    return tourists;
//		  }
//
//		  public void setTourists(Set<Tourist> tourists) {
//		    this.tourists = tourists;
//		  }
//	


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}




	public Date getArrivalDate() {
		return arrivalDate;
	}



	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}



	public Date getDepartureDate() {
		return departureDate;
	}



	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}



	public Long getNumberOfSeats() {
		return numberOfSeats;
	}



	public void setNumberOfSeats(Long numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}



	public Double getPrice() {
		return price;
	}



	public void setPrice(Double price) {
		this.price = price;
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
		Flight other = (Flight) obj;
		if (id != other.id)
			return false;
		return true;
	}

    public String toString() {
        return "Project id: " + getId() +
               " with " + getEmployees().size() + " employees";
    }
	
	
	
//	  @Override
//	  public String toString() {
//	    return "Flight [id=" + id + ", tourists=" + tourists
//	        + "]";
//	  }
//	
}
