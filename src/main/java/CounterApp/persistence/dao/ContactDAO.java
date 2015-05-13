package CounterApp.persistence.dao;

import java.util.List;

import CounterApp.persistence.dto.Contact;


public interface ContactDAO {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
