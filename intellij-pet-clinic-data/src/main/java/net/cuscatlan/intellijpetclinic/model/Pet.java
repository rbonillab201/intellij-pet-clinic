package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Pet extends BaseEntity {

    private String petName;
    private Owner owner;
    private PetType petType;
    private LocalDate birthDate;
}
