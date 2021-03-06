package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "vets")
@Entity
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vets_specialties", joinColumns = @JoinColumn(name = "vet_id"),
    inverseJoinColumns = @JoinColumn(name = "specialty_id"))
    private Set<Specialty> specialties = new HashSet<>();
}
