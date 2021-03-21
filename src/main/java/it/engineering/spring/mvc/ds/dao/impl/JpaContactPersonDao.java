package it.engineering.spring.mvc.ds.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import it.engineering.spring.mvc.ds.dao.ContactPersonDao;
import it.engineering.spring.mvc.ds.entity.ContactPersonEntity;
@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class JpaContactPersonDao implements ContactPersonDao{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void save(ContactPersonEntity contactPerson) throws Exception {
		
		this.entityManager.persist(contactPerson);
		
	}

	@Override
	public List<ContactPersonEntity> getAll() throws Exception {
		return entityManager
				.createQuery("SELECT c from ContactPerson c ORDER BY firstname", ContactPersonEntity.class)
				.getResultList();
	}

	@Override
	public ContactPersonEntity findById(Long id) throws Exception {
		return this.entityManager.find(ContactPersonEntity.class, id);
	}

	@Override
	public ContactPersonEntity update(ContactPersonEntity entity) throws Exception {
		return this.entityManager.merge(entity);
	}
}
