package Nithish.Backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import Nithish.Backend.Entity.Contacts;
import jakarta.transaction.Transactional;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Long> {

	@Transactional
	@Query(value="select c from Contacts c where c.user_id = :user_id", nativeQuery = true)
	public List<Contacts> getContactsByUserId(@Param("user_id") long user_id);
	
	
//	@Transactional
//	@Query(value="select c from Contacts c where c.id = :c_id", nativeQuery = true)
//	public Contacts findByCiD(@Param("c_id") Long c_id);
}
