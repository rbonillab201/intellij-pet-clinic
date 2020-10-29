package net.cuscatlan.intellijpetclinic.repository;

import net.cuscatlan.intellijpetclinic.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Long> {
}
