package org.springframework.samples.petclinic.pet;

import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetService {

	private final PetRepository petRepository;

	public PetService(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	public List<PetType> getPetTypes() {
		return petRepository.findPetTypes();
	}

	public List<Pet> getPets() {
		return petRepository.findAll();
	}

	public Pet findPetById(int id) {
		return petRepository.findById(id);
	}

	public Pet createPet(Pet pet) {
		return petRepository.save(pet);
	}

	public Pet updatePet(Pet pet) {
		return petRepository.update(pet);
	}

	public void deletePetById(int id) {
		petRepository.deleteById(id);
	}

	public void addVisit(Visit visit, Pet pet) {
		pet.getVisits().add(visit);
	}

}
