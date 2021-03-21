package it.engineering.spring.mvc.ds.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.ds.converter.impl.ContactPersonConverter;
import it.engineering.spring.mvc.ds.dao.ContactPersonDao;
import it.engineering.spring.mvc.ds.dao.ManufacturerDao;
import it.engineering.spring.mvc.ds.dto.ContactPersonDto;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;
import it.engineering.spring.mvc.ds.entity.ManufacturerEntity;
import it.engineering.spring.mvc.ds.exception.ExistEntityException;
import it.engineering.spring.mvc.ds.service.ContactPersonService;

@Service
@Transactional
public class ContactPersonServiceImpl implements ContactPersonService {

	private ContactPersonDao contactPersonDao;
	private ManufacturerDao manufacturerDao;
	private ContactPersonConverter contactPersonConverter;
	
	@Autowired
	public ContactPersonServiceImpl(ContactPersonDao contactPersonDao, ManufacturerDao manufacturerDao,
			ContactPersonConverter contactPersonServiceImpl) {
		super();
		this.contactPersonDao = contactPersonDao;
		this.manufacturerDao = manufacturerDao;
		this.contactPersonConverter = contactPersonServiceImpl;
	}

	@Override
	public void save(ContactPersonDto contactPersonDto) throws Exception {
		ManufacturerEntity manufacturerExisting = this.manufacturerDao.findbyId(contactPersonDto.getManufacturerDto().getId());
		System.out.println(manufacturerExisting);
		if(manufacturerExisting == null) {
			throw new ExistEntityException(manufacturerExisting,"Proizvodjac ne postoji");
		}
		
		System.out.println(contactPersonDto);
		ContactPersonEntity entity = this.contactPersonConverter.toEntity(contactPersonDto);
		
	
		this.contactPersonDao.save(entity);
	}

	@Override
	public List<ContactPersonDto> getAll() throws Exception {
		List<ContactPersonEntity> entities = this.contactPersonDao.getAll();
		
		return entities.stream().map(el-> this.contactPersonConverter.toDto(el)).collect(Collectors.toList());
	}

	@Override
	public ContactPersonDto findById(Long id) throws Exception {
		ContactPersonEntity contactPerson = this.contactPersonDao.findById(id);
		
		if(contactPerson == null) {
			throw new ExistEntityException(contactPerson, "Kontakt ne postoji!");
		}
		
		return this.contactPersonConverter.toDto(contactPerson);
	}

	@Override
	public ContactPersonDto update(ContactPersonDto contactPersonDto) throws Exception {
		ContactPersonEntity contactPersonEntity = this.contactPersonDao.findById(contactPersonDto.getId());
		
		if(contactPersonEntity == null) {
			throw new ExistEntityException(contactPersonEntity, "Proizvodjac ne postoji!");
		}
		
		ManufacturerEntity manufacturerEntity = this.manufacturerDao.findbyId(contactPersonDto.getManufacturerDto().getId());
		
		if(manufacturerEntity == null) {
			throw new ExistEntityException(manufacturerEntity, "Proizvodjac ne postoji!");
		}
		
		contactPersonEntity = new ContactPersonEntity();
		
		contactPersonEntity.setId(contactPersonDto.getId());
		contactPersonEntity.setFirstname(contactPersonDto.getFirstname());
		contactPersonEntity.setLastname(contactPersonDto.getLastname());
		
		contactPersonEntity.setManufacturer(manufacturerEntity);
		
		contactPersonEntity = this.contactPersonDao.update(contactPersonEntity);
		
		return this.contactPersonConverter.toDto(contactPersonEntity);
	}

}
