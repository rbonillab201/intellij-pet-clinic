package net.cuscatlan.intellijpetclinic.repository;

import net.cuscatlan.intellijpetclinic.model.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
