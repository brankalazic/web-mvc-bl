package it.engineering.spring.mvc.ds.converter.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.engineering.spring.mvc.ds.converter.ConverterDtoEntity;
import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;

@Component
public class ContactPersonConverter implements ConverterDtoEntity<ContactPersonDto, ContactPersonEntity>{
	private ManufacturerConverterDtoEntity manufacturerFormatter;
	
	@Autowired
	public ContactPersonConverter(ManufacturerConverterDtoEntity manufacturerFormatter) {
		super();
		this.manufacturerFormatter = manufacturerFormatter;
	}

	@Override
	public ContactPersonDto toDto(ContactPersonEntity e) {
		System.out.println(e.getManufacturer()+"+++++++++");
		return new ContactPersonDto(e.getId(), e.getFirstname(), e.getLastname(),
													this.manufacturerFormatter.toDto(e.getManufacturer()));
	}

	@Override
	public ContactPersonEntity toEntity(ContactPersonDto dto) {
		System.out.println(dto);
		return new ContactPersonEntity(dto.getId(), dto.getFirstname(), dto.getLastname(),
																this.manufacturerFormatter.toEntity(dto.getManufacturerDto()));
	}

}
