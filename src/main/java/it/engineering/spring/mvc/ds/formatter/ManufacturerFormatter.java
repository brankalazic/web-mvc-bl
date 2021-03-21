package it.engineering.spring.mvc.ds.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;

import it.engineering.spring.mvc.ds.dto.ManufacturerDto;
import it.engineering.spring.mvc.ds.service.ManufacturerService;

public class ManufacturerFormatter implements  Formatter<ManufacturerDto>{

	private ManufacturerService manufacturerService;
	
	@Autowired
	public ManufacturerFormatter(ManufacturerService contactPersonService) {
		super();
		this.manufacturerService = contactPersonService;
	}
	@Override
	public String print(ManufacturerDto object, Locale locale) {
		return object.getId() + " - "+ object.getName();
	}


	@Override
	public ManufacturerDto parse(String contact, Locale locale) throws ParseException {
		System.out.println("========    ManufacturerDto::parse   ======================");
		System.out.println("String city: " + contact);
		
		Long id = Long.parseLong(contact);
		
		try {
			ManufacturerDto manufacturerDto = this.manufacturerService.findById(id);
			return manufacturerDto;
		} catch (Exception e) {
		e.printStackTrace();
		throw new ParseException("Greska u formateru", 0);
		}
		
	}

}
