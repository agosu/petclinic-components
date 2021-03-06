package org.springframework.samples.petclinic.owner;

import java.util.List;
import javax.validation.Valid;

import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/owners")
class OwnerController {

	private final OwnerService ownerService;

	public OwnerController(OwnerService ownerService) {
		this.ownerService = ownerService;
	}

	@GetMapping
	public List<Owner> getOwners() {
		return ownerService.getOwners();
	}

	@GetMapping("/{id}")
	public Owner getOwner(@PathVariable int id) {
		return ownerService.findOwnerById(id);
	}

	@PostMapping
	public Owner createOwner(@Valid Owner owner) {
		return ownerService.createOwner(owner);
	}

	@DeleteMapping("/{id}")
	public void deleteOwner(@PathVariable int id){
		ownerService.deleteOwnerById(id);
	}

	@PostMapping("/{id}/pets")
	public Owner addPetToOwner(@PathVariable int id, @Valid Pet pet) {
		return ownerService.addPet(id, pet);
	}

}
