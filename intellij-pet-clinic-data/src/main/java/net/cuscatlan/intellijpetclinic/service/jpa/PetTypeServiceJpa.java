package net.cuscatlan.intellijpetclinic.service.jpa;

import net.cuscatlan.intellijpetclinic.model.PetType;
import net.cuscatlan.intellijpetclinic.repository.PetTypeRepository;
import net.cuscatlan.intellijpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springJpaService")
public class PetTypeServiceJpa implements PetTypeService {
    PetTypeRepository petTypeRepository;

    public PetTypeServiceJpa(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Set<PetType> findAll() {
        Set<PetType> types = new HashSet<>();
        // Implementado con Bulk Collection
        types.addAll(petTypeRepository.findAll());
        return types;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType object) {
        return petTypeRepository.save(object);
    }

    @Override
    public void delete(PetType object) {
        petTypeRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        petTypeRepository.deleteById(aLong);
    }
}
