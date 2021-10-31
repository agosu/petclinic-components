package org.springframework.samples.petclinic.pet;

import org.springframework.samples.petclinic.common.NamedEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "types")
public class PetType extends NamedEntity {

}
