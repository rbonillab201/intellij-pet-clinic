package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Table(name = "specialties")
@Entity
public class Specialty extends BaseEntity {

    @Column(name = "description")
    private String description;
}
