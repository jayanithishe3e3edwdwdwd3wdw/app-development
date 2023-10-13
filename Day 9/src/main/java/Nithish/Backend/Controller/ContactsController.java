package Nithish.Backend.Controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import Nithish.Backend.Constants.Api;
import Nithish.Backend.Entity.Contacts;
import Nithish.Backend.Service.ContactsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping(Api.CONTACT)
public class ContactsController {

	@Autowired
	ContactsService cService;
	
	@Operation(summary = "Get all contacts")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Contacts list retrieved successfully")
	})
	@GetMapping("/getAll")
	public ResponseEntity<List<Contacts>> getAll() {

	    List<Contacts> allContacts = cService.getAll();
	    return ResponseEntity.ok(allContacts);
	}
	
	
	@Operation(summary = "Get contact by user ID")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Contact retrieved successfully"),
	        @ApiResponse(responseCode = "404", description = "Contact not found")
	})
	@GetMapping("/getContact/{user_id}")
	public ResponseEntity<List<Contacts>> getContactByUserId(@PathVariable("user_id") long user_id) {

	    List<Contacts> contact = cService.getContactByUserId(user_id);
	  
	    return ResponseEntity.ok(contact);
	}
	
	
	@Operation(summary = "Get sorted contacts by name")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Sorted contacts list retrieved successfully")
	})
	@GetMapping("/getSortedContacts/{dir}")
	public ResponseEntity<List<Contacts>> getContactsSortedByName(@PathVariable("dir") String dir) {

	    List<Contacts> sortedContacts = cService.getContactsSortedByName(dir);
	    return ResponseEntity.ok(sortedContacts);
	}
	
	
	@Operation(summary = "Add a new contact")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "201", description = "Contact detail added successfully"),
	        @ApiResponse(responseCode = "400", description = "Invalid contact detail")
	})
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/post", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Contacts> postContact(@RequestBody Contacts contact) {

	    Contacts createdContact = cService.postContact(contact);
	    return ResponseEntity.ok(createdContact);
	}
	
	
	@Operation(summary = "Update an existing contact")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Contact updated successfully"),
	        @ApiResponse(responseCode = "404", description = "Contact not found")
	})
	@PutMapping("/update/{id}")
	public ResponseEntity<Contacts> updateContact(@RequestBody Contacts contact, @PathVariable("id") Long id) {

	    Contacts updatedContact = cService.updateContact(contact, id);
	    
	    return ResponseEntity.ok(updatedContact);
	}
	
	
	@Operation(summary = "Delete a contact by ID")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Contact deleted successfully"),
	        @ApiResponse(responseCode = "404", description = "Contact not found")
	})
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteContact(@PathVariable("id") Long id) {

	    cService.deleteContact(id);
	    return ResponseEntity.ok().build();
	}
	
	
	@Operation(summary = "Delete all contacts")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "All contacts deleted successfully")
	})
	@DeleteMapping("/deleteAll")
	public ResponseEntity<Void> deleteAllContacts() {

	    cService.deleteAllContacts();
	    return ResponseEntity.ok().build();
	}
}
