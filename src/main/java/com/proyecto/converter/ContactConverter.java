package com.proyecto.converter;

import org.springframework.stereotype.Component;

import com.proyecto.entity.Contact;
import com.proyecto.model.ContactModel;

@Component("contactConverter")
public class ContactConverter {
	public Contact converterContactModel2Contact(ContactModel contactModel) { 
		Contact contact = new Contact();
		contact.setId(contactModel.getId());
		contact.setFirstname(contactModel.getFirstname());
		contact.setLastname(contactModel.getLastname());
		contact.setTelephone(contactModel.getTelephone());
		contact.setCity(contactModel.getCity());
		return contact;
		
		
	}
	public ContactModel converterContact2ContactModel(Contact contact) { 
		ContactModel contactModel = new ContactModel();
		contactModel.setId(contact.getId());
		contactModel.setFirstname(contact.getFirstname());
		contactModel.setLastname(contact.getLastname());
		contactModel.setTelephone(contact.getTelephone());
		contactModel.setCity(contact.getCity());
		return contactModel;
		
	}
}
