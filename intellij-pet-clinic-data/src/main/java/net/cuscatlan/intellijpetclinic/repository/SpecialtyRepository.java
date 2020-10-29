package net.cuscatlan.intellijpetclinic.repository;

import net.cuscatlan.intellijpetclinic.model.Specialty;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialtyRepository extends JpaRepository<Specialty, Long> {
}
