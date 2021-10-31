package org.springframework.samples.petclinic.visit;

import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.samples.petclinic.pet.PetService;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.Map;

@Service
public class VisitService {

	private final VisitRepository visits;
	private final PetService petService;

	public VisitService(VisitRepository visitRepository, PetService petService) {
		this.visits = visitRepository;
		this.petService = petService;
	}

	public Visit getVisit(int petId, Map<String, Object> model) {
		Pet pet = petService.findById(petId);
		pet.setVisitsInternal(this.visits.findByPetId(petId));
		model.put("pet", pet);
		Visit visit = new Visit();
		pet.addVisit(visit);
		return visit;
	}

	public String createNewVisit(Visit visit, BindingResult result) {
		if (result.hasErrors()) {
			return "pets/createOrUpdateVisitForm";
		}
		else {
			this.visits.save(visit);
			return "redirect:/owners/{ownerId}";
		}
	}

}
