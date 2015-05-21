package paymentapp.persistence.dao;

import java.io.Serializable;
import java.util.List;

import paymentapp.persistence.dto.GenericDomainObject;

public interface GenericDAO<T extends GenericDomainObject> {

	public  void create(T item);

	public  void update(T item);

	public  void delete(T item);

	public  T getById(Class<? extends GenericDomainObject> clazz, Serializable id);
	
	public List<String> getAllIDs(Class<? extends GenericDomainObject> clazz);

	public  void flush();
	
	public void evict(T entity);
	
	public void clear();
}
