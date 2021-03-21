package it.engineering.spring.mvc.ds.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer")
public class ManufacturerEntity implements Serializable, it.engineering.spring.mvc.ds.entity.Entity{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "city_number")
	private CityEntity city;
	
	@OneToMany(mappedBy = "manufacturer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<ContactPersonEntity> contacts;

	public ManufacturerEntity() {
	}

	public ManufacturerEntity(Long id, String name, CityEntity city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public CityEntity getCity() {
		return city;
	}

	public void setCity(CityEntity city) {
		this.city = city;
	}
	public List<ContactPersonEntity> getContacts() {
		return contacts;
	}

	public void setContacts(List<ContactPersonEntity> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "ManufacturerEntity [id=" + id + ", name=" + name + ", city=" + city + "]";
	}
	
}
