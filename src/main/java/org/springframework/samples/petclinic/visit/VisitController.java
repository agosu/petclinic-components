package org.springframework.samples.petclinic.visit;

import org.springframework.samples.petclinic.pet.PetRepository;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/visits")
class VisitController {

	private final VisitService visitService;

	public VisitController(VisitService visitService, PetRepository pets) {
		this.visitService = visitService;
	}

	@GetMapping
	public List<Visit> getVisits() {
		return visitService.getVisits();
	}

	@GetMapping("/{id}")
	public Visit getVisit(@PathVariable int id) {
		return visitService.findVisitById(id);
	}

	@GetMapping("/byPetId/{id}")
	public List<Visit> getVisitByPetId(@PathVariable int id) {
		return visitService.findByPetId(id);
	}

	@PostMapping
	public Visit createVisit(@Valid Visit visit) {
		return visitService.createVisit(visit);
	}

	@DeleteMapping("/{id}")
	public void deleteVisit(@PathVariable  int id){
		visitService.deleteVisitById(id);
	}

}
