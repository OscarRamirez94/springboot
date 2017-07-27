package com.proyecto.service;


import java.util.List;

import com.proyecto.entity.Contact;
import com.proyecto.model.ContactModel;

public interface ContactService {
	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContact();
	public abstract Contact findBydId(int id);
	public abstract void deleteId(int id);
	public abstract ContactModel findByIdModel (int id);
}
