package net.cuscatlan.intellijpetclinic.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Table(name = "visits")
@Entity
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate localDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
