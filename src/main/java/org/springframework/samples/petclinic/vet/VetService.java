package org.springframework.samples.petclinic.vet;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VetService {

	private final VetRepository vetRepository;

	public VetService(VetRepository vetRepository) {
		this.vetRepository = vetRepository;
	}

	public List<Vet> getVets() {
		return vetRepository.findAll();
	}

	public Vet findVetById(int vetId) {
		return vetRepository.findById(vetId);
	}

	public Vet createVet(Vet vet) {
		return vetRepository.save(vet);
	}

	public void deleteVetById(int id) {
		vetRepository.deleteById(id);
	}

	public void addSpecialty(Specialty specialty, Vet vet) {
		vet.getSpecialties().add(specialty);
	}

}
