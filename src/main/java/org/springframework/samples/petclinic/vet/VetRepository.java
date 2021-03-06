package org.springframework.samples.petclinic.vet;

import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public interface VetRepository extends Repository<Vet, Integer> {

	@Transactional(readOnly = true)
	List<Vet> findAll();

	@Transactional(readOnly = true)
	Vet findById(@Param("id") Integer id);

	Vet save(Vet vet);

	void deleteById(int id);

}
