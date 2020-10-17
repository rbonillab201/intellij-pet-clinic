package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class Owner extends Person {

    Set<Pet> pets;
}
