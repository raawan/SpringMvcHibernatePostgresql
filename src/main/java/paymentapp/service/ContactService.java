package paymentapp.service;

import java.util.List;

import paymentapp.persistence.dto.Contact;


public interface ContactService {
	
	public void addContact(Contact contact);
	public List<Contact> listContact();
	public void removeContact(Integer id);
}
