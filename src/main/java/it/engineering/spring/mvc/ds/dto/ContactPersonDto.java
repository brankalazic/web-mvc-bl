package it.engineering.spring.mvc.ds.dto;

import java.io.Serializable;

public class ContactPersonDto implements Serializable,Dto{
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String firstname;
	private String lastname;
	private ManufacturerDto manufacturerDto;
	
	public ContactPersonDto() {
		super();
		
	}
	
	public ContactPersonDto(Long id, String firstname, String lastname, ManufacturerDto manufacturer) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.manufacturerDto = manufacturer;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	
	
	public ManufacturerDto getManufacturerDto() {
		return manufacturerDto;
	}
	
	public void setManufacturerDto(ManufacturerDto manufacturerDto) {
		this.manufacturerDto = manufacturerDto;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "ContactPersonDto [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", manufacturer="
				+ manufacturerDto + "]";
	}
}
