package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Details")
public class Details 
{
	
	
	public Details(int empid, String firstname, String lastname, String designation, String address) 
	{
        this.empid = empid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.designation = designation;
        this.address = address;
    }
	
	public Details() {
    }
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int empid;
    private String firstname;
    private String lastname;
    private String designation;
    private String address;
    
    
	public int getEmpid()
	{
		return empid;
	}
	public void setEmpid(int empid)
	{
		this.empid = empid;
	}
	public String getFirstname()
	{
		return firstname;
	}
	public void setFirstname(String firstname)
	{
		this.firstname = firstname;
	}
	public String getLastname()
	{
		return lastname;
	}
	public void setLastname(String lastname)
	{
		this.lastname = lastname;
	}
	public String getDesignation() 
	{
		return designation;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
    
}
