package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerService {

	private final OwnerRepository ownerRepository;
	private final PetService petService;

	public OwnerService(OwnerRepository ownerRepository, PetService petService) {
		this.ownerRepository = ownerRepository;
		this.petService = petService;
	}

	List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

	Owner findOwnerById(int ownerId) {
		return ownerRepository.findById(ownerId);
	}

	Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	void deleteOwnerById(int id) {
		ownerRepository.deleteById(id);
	}

	Owner addPet(int id, Pet pet) {
		Pet newPet = petService.createPet(pet);
		Owner owner = ownerRepository.findById(id);
		owner.getPets().add(newPet);
		return owner;
	}

}
