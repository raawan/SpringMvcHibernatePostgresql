package paymentapp.persistence.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import paymentapp.persistence.dto.GenericDomainObject;

/*
 * these methods should be called within transactional context
 */
@Repository
public class GenericDAOImpl<T extends GenericDomainObject> implements GenericDAO<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public void create(T item) {
		Date now = new Date();
		item.setCreated(now);
		item.setModified(now);
		sessionFactory.getCurrentSession().save(item);
	}

	@Override
	public void update(T item) {
		item.setModified(new Date());
		sessionFactory.getCurrentSession().update(item);
	}

	@Override
	public void delete(T item) {
		sessionFactory.getCurrentSession().delete(item);
	}

	@Override
	public T getById(Class<? extends GenericDomainObject> clazz, Serializable id) {
		//ToDO: check if its good to suppresswarning or to move this down to subclasses
		return (T)sessionFactory.getCurrentSession().get(clazz, id);
	}

	@Override
	public List<String> getAllIDs(Class<? extends GenericDomainObject> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		sessionFactory.getCurrentSession().flush();
	}


	@Override
	public void evict(T entity) {
		sessionFactory.getCurrentSession().evict(entity);
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}


}
