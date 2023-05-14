
package in.vini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.vini.entity.ContactDetails;


public interface ContactDetailsRepo extends JpaRepository<ContactDetails, Integer> {

}
