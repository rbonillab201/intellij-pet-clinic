package net.cuscatlan.intellijpetclinic.service.map;

import net.cuscatlan.intellijpetclinic.model.Owner;
import net.cuscatlan.intellijpetclinic.model.Pet;
import net.cuscatlan.intellijpetclinic.service.OwnerService;
import net.cuscatlan.intellijpetclinic.service.PetService;
import net.cuscatlan.intellijpetclinic.service.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    public final PetService petService;
    public final PetTypeService petTypeService;

    public OwnerServiceMap(PetService petService, PetTypeService petTypeService) {
        this.petService = petService;
        this.petTypeService = petTypeService;
    }
    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(Owner object) {

        // Valida que el objeto no venga nulo
        if(object != null){
            // Valida que el objecto traiga mascotas
            if (!object.getPets().isEmpty()) {
                object.getPets().forEach(pet -> {
                    // valida que venga el tipo de mascota
                    if(pet.getPetType() == null){
                        throw new RuntimeException("El tipo de mascota es requerida");
                    } else {
                        // evalua que el tipo de mascota este persistido
                        if (pet.getPetType().getId() == null){
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    }
                    // evalua que la mascota este persistida
                    if (pet.getId() == null) {
                        Pet petSaved = petService.save(pet);
                        pet.setId(petSaved.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }

    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }
}
