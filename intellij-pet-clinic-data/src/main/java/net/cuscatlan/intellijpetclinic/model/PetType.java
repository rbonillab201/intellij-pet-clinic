package net.cuscatlan.intellijpetclinic.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@Table(name = "types")
@Entity
public class PetType extends BaseEntity {

    @Column(name = "name")
    private String name;
}
