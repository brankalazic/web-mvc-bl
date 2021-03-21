package it.engineering.spring.mvc.ds.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.engineering.spring.mvc.ds.dto.ContactPersonDto;


public class ContactPersonValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return ContactPersonDto.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("Pozvana metoda validate u ContactPersonValidator klaasi...");
		
		ContactPersonDto contactPersonDto = (ContactPersonDto) target;
		
		if(contactPersonDto != null) {
			if(contactPersonDto.getFirstname().isEmpty()) {
				errors.rejectValue("firstname", "contact.firstname", "Ime je obavezno");
			}
			
			if(contactPersonDto.getLastname().isEmpty()) {
				errors.rejectValue("lastname", "contact.lastname", "Prezime je obavezno");
				
			}
			
			if(contactPersonDto.getManufacturerDto()==null) {
				errors.rejectValue("manufacturerDto", "contact.manufacturer", "Obavezno je odabrati proizvodjaca!");
				
			}
		}
		
	}

}
