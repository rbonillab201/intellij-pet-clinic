package net.cuscatlan.intellijpetclinic.repository;

import net.cuscatlan.intellijpetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
