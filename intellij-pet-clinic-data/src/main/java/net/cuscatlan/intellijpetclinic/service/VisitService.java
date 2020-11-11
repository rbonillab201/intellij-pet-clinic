package net.cuscatlan.intellijpetclinic.service;

import net.cuscatlan.intellijpetclinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitService extends CrudService<Visit, Long> {
}
