package org.springframework.samples.petclinic.owner;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OwnerRepository extends Repository<Owner, Integer> {

	@Query("SELECT owner FROM Owner owner")
	@Transactional(readOnly = true)
	List<Owner> findAll();

	@Query("SELECT owner FROM Owner owner left join fetch owner.pets WHERE owner.id =:id")
	@Transactional(readOnly = true)
	Owner findById(@Param("id") Integer id);

	Owner save(Owner owner);

	Owner update(Owner owner);

	void deleteById(int id);
}
