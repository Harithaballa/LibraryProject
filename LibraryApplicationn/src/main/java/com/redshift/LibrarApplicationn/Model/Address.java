package com.redshift.LibrarApplicationn.Model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="address_id")
    private int address_id;
    private String location;
    @OneToOne(mappedBy="address",cascade=CascadeType.ALL)
    @JsonIgnore
    private Library lib;
public int getAddress_id() 
{
   return address_id;
}
public void setAddress_id(int address_id) 
{
	this.address_id = address_id;
}
public String getLocation() 
{
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public Library getLib() {
	return lib;
}
public void setLib(Library lib) {
	this.lib = lib;
}
	
	

	
}
