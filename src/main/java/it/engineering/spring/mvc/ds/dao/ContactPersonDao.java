package it.engineering.spring.mvc.ds.dao;

import java.util.List;

import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;

public interface ContactPersonDao {
	
	void save(ContactPersonEntity contactPersonDto) throws Exception;

	ContactPersonEntity update(ContactPersonEntity entity) throws Exception;

	List<ContactPersonEntity> getAll() throws Exception;

	ContactPersonEntity findById(Long id) throws Exception;
}
