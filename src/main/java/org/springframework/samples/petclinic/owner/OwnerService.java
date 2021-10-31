package org.springframework.samples.petclinic.owner;

import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerService {

	private final OwnerRepository ownerRepository;

	public OwnerService(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	public List<Owner> getOwners() {
		return ownerRepository.findAll();
	}

	public Owner findOwnerById(int ownerId) {
		return ownerRepository.findById(ownerId);
	}

	public Owner createOwner(Owner owner) {
		return ownerRepository.save(owner);
	}

	public Owner updateOwner(Owner owner) {
		return ownerRepository.update(owner);
	}

	public void deleteOwnerById(int id) {
		ownerRepository.deleteById(id);
	}

	public void addPet(Owner owner, Pet pet) {
		owner.getPets().add(pet);
	}

}
