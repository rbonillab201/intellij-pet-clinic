package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class Visit extends BaseEntity {

    private LocalDate localDate;
    private String description;
    private Pet pet;

}
