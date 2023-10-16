package Nithish.Backend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import Nithish.Backend.Entity.Contacts;
import Nithish.Backend.Repository.ContactsRepository;

@Service
public class ContactsService {

	@Autowired
	ContactsRepository cRepo;
	
	public List<Contacts> getAll() {
		
		return cRepo.findAll();
	}
	
	
	public List<Contacts> getContactByUserId(long user_id) {
		
		return cRepo.getContactsByUserId(user_id);
	}
	
	
	
	public List<Contacts> getContactsSortedByName(String dir) {
		
		if(dir.equalsIgnoreCase("asc")) {
			
			Sort  nameSort = Sort.by("name").ascending();
			
			return cRepo.findAll(nameSort);
		}
		else {
			
			Sort  nameSort = Sort.by("name").descending();
			
			return cRepo.findAll(nameSort);
		}
	}
	
	
	
	public Contacts postContact(Contacts contact) {
		
		return cRepo.save(contact);	
	}
	
	public Contacts updateContact(Contacts newContact, Long id) {
		
		Contacts updatedContact = cRepo.findById(id).get();

        updatedContact.setEmail(newContact.getEmail());
        updatedContact.setGroupname(newContact.getGroupname());
        updatedContact.setName(newContact.getName());
        updatedContact.setPhoneno(newContact.getPhoneno());
        updatedContact.setUser(newContact.getUser());

        return cRepo.save(updatedContact);
    }
	
	public void deleteContact(Long id) {
		
		cRepo.deleteById(id);
	}
	
	public void deleteAllContacts() {
		
		cRepo.deleteAll();
	}
}
