package org.springframework.samples.petclinic.pet;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerService;
import org.springframework.samples.petclinic.visit.Visit;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Collection;

@Service
public class PetService {

	private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "pets/createOrUpdatePetForm";

	private final PetRepository pets;
	private final OwnerService ownerService;

	public PetService(PetRepository pets, OwnerService ownerService) {
		this.pets = pets;
		this.ownerService = ownerService;
	}

	public Collection<PetType> getPetTypes() {
		return this.pets.findPetTypes();
	}

	public String initCreatePet(Owner owner, ModelMap model) {
		Pet pet = new Pet();
		ownerService.addPet(owner, pet);
		model.put("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

	public String createPet(Owner owner, @Valid Pet pet, BindingResult result, ModelMap model) {
		if (StringUtils.hasLength(pet.getName()) && pet.isNew() && owner.getPet(pet.getName(), true) != null) {
			result.rejectValue("name", "duplicate", "already exists");
		}
		ownerService.addPet(owner, pet);
		if (result.hasErrors()) {
			model.put("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		}
		else {
			this.pets.save(pet);
			return "redirect:/owners/{ownerId}";
		}
	}

	public String initUpdate(int petId, ModelMap model) {
		Pet pet = this.pets.findById(petId);
		model.put("pet", pet);
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

	public String update(Pet pet, BindingResult result, Owner owner, ModelMap model) {
		if (result.hasErrors()) {
			pet.setOwner(owner);
			model.put("pet", pet);
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		}
		else {
			ownerService.addPet(owner, pet);
			this.pets.save(pet);
			return "redirect:/owners/{ownerId}";
		}
	}

	public Pet findById(int petId) {
		return this.pets.findById(petId);
	}

	public Owner getOwner(int petId) {
		return findById(petId).getOwner();
	}

	public void addVisit(Visit visit, Pet pet) {
		pet.getVisits().add(visit);
	}

}
