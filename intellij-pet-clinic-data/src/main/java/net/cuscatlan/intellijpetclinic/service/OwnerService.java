package net.cuscatlan.intellijpetclinic.service;

import net.cuscatlan.intellijpetclinic.model.Owner;

import java.util.Optional;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
