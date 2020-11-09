package net.cuscatlan.intellijpetclinic.service.jpa;

import net.cuscatlan.intellijpetclinic.model.Owner;
import net.cuscatlan.intellijpetclinic.repository.OwnerRepository;
import net.cuscatlan.intellijpetclinic.service.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//@Service
//@Profile("springjpaservfice")
public class OwnerServiceJpa implements OwnerService {

    public final OwnerRepository ownerRepository;

    public OwnerServiceJpa(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owner = new HashSet<>();
        // Java Lambda: Method Reference owner::add
        ownerRepository.findAll().forEach(owner::add);
        return owner;
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        ownerRepository.deleteById(aLong);
    }
}
