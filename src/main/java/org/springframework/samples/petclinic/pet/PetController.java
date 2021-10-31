package org.springframework.samples.petclinic.pet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
class PetController {

	private final PetService petService;

	public PetController(PetService petService) {
		this.petService = petService;
	}

	@GetMapping("/types")
	public List<PetType> getPetTypes() {
		return petService.getPetTypes();
	}

	@GetMapping
	public List<Pet> getPets() {
		return petService.getPets();
	}

	@GetMapping("/{id}")
	public Pet getPet(@PathVariable int id) {
		return petService.findPetById(id);
	}

	@PostMapping
	public Pet createPet(@Valid Pet pet) {
		return petService.createPet(pet);
	}

	@DeleteMapping("/{id}")
	public void deletePet(@PathVariable int id) {
		petService.deletePetById(id);
	}

}
