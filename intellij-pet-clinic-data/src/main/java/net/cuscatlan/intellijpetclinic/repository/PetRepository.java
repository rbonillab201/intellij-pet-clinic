package net.cuscatlan.intellijpetclinic.repository;

import net.cuscatlan.intellijpetclinic.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
