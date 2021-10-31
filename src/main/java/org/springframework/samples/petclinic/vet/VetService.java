package org.springframework.samples.petclinic.vet;

import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class VetService {

	private final VetRepository vetRepository;

	private final SpecialtyRepository specialtyRepository;

	public VetService(VetRepository vetRepository, SpecialtyRepository specialtyRepository) {
		this.vetRepository = vetRepository;
		this.specialtyRepository = specialtyRepository;
	}

	List<Vet> getVets() {
		return vetRepository.findAll();
	}

	Vet findVetById(int vetId) {
		return vetRepository.findById(vetId);
	}

	Vet createVet(Vet vet) {
		return vetRepository.save(vet);
	}

	void deleteVetById(int id) {
		vetRepository.deleteById(id);
	}

	Vet addSpecialty(int vetId, int specialtyId) {
		Vet vet = vetRepository.findById(vetId);
		Specialty specialty = specialtyRepository.findById(specialtyId);
		vet.getSpecialties().add(specialty);
		return vet;
	}

	Specialty createSpecialty(@Valid Specialty specialty) {
		return specialtyRepository.save(specialty);
	}

}
