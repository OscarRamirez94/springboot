package com.proyecto.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.proyecto.converter.ContactConverter;
import com.proyecto.entity.Contact;
import com.proyecto.model.ContactModel;
import com.proyecto.repository.ContactRepository;
import com.proyecto.service.ContactService;

@Service("contactServiceImpl")
public class ContactServiceImpl implements ContactService {
	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;
	@Autowired

	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.converterContactModel2Contact(contactModel));
		return contactConverter.converterContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContact() {
		List <ContactModel> contactsModel = new ArrayList<ContactModel>();
		List <Contact> contacts =contactRepository.findAll();
		for (Contact contact : contacts ) {
			contactsModel.add(contactConverter.converterContact2ContactModel(contact));
		}
		
		
		return contactsModel;
	}

	@Override
	public Contact findBydId(int id) {
		return contactRepository.findById(id);
		
	}
	
	@Override
	public ContactModel findByIdModel(int id) {
		return	contactConverter.converterContact2ContactModel(findBydId(id));
	}

	@Override
	public void deleteId(int id) {
		Contact contact = contactRepository.findById(id);
		if(contact != null) {
			contactRepository.delete(contact);
			
		}
			
		
	}

	
	
	

}
