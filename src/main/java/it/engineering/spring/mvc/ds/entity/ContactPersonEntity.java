package it.engineering.spring.mvc.ds.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "contact_person")
public class ContactPersonEntity implements Serializable,it.engineering.spring.mvc.ds.entity.Entity{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstname;
	private String lastname;
	
	@ManyToOne
	@JoinColumn(name = "manufacturer_id")
	private ManufacturerEntity manufacturer;


	public ContactPersonEntity() {
		super();
	}


	public ContactPersonEntity(Long id, String firstname, String lastname, ManufacturerEntity manufacturer) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.manufacturer = manufacturer;
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


	public ManufacturerEntity getManufacturer() {
		return manufacturer;
	}


	public void setManufacturer(ManufacturerEntity manufacturer) {
		this.manufacturer = manufacturer;
	}


	@Override
	public String toString() {
		return "ContactPersonEntity [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", manufacturer=" + manufacturer + "]";
	}
	
	
}
