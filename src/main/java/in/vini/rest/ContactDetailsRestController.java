package in.vini.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.vini.entity.ContactDetails;
import in.vini.repo.ContactDetailsRepo;

@RestController
public class ContactDetailsRestController {
	@Autowired
	private ContactDetailsRepo repo;

	@PostMapping(value = "/add", produces = { "application/json" }, consumes = { "application/json" })
	public ResponseEntity<ContactDetails> addContact(@RequestBody ContactDetails details) {

		ContactDetails save = repo.save(details);

		return new ResponseEntity<>(save, HttpStatus.CREATED);

	}

	@GetMapping(value = "/view", produces = "application/json")
	public List<ContactDetails> getContacts() {

		List<ContactDetails> findAll = repo.findAll();

		return findAll;

	}

	@GetMapping(value = "/delete/{id}/", produces = { "application/json" }, consumes = { "application/json" })
	public void deleteContact(@PathVariable("id") Integer cid) {
		repo.deleteById(cid);

	}

	@PutMapping(value = "/edit/{id}/", produces = { "application/json" }, consumes = { "application/json" })
	public ContactDetails editContact(@PathVariable("id") Integer cid, @RequestBody ContactDetails details) {

		Optional<ContactDetails> findById = repo.findById(cid);
		if (findById.isPresent()) {
			
				ContactDetails contactDetails = findById.get();
				contactDetails.setName(details.getName());
				contactDetails.setMail(details.getName());
				contactDetails.setPhno(details.getPhno());
				repo.save(contactDetails);
				return contactDetails;
			
		}
		return null;

	}
}











