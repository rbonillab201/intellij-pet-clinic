package net.cuscatlan.intellijpetclinic.service.map;

import net.cuscatlan.intellijpetclinic.model.Specialty;
import net.cuscatlan.intellijpetclinic.model.Vet;
import net.cuscatlan.intellijpetclinic.service.SpecialtyService;
import net.cuscatlan.intellijpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"})
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    public final SpecialtyService specialtyService;

    public VetServiceMap(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {
        if(object != null){
            if(!object.getSpecialties().isEmpty()){
                object.getSpecialties().forEach(specialty ->  {
                    if(specialty.getId() == null){
                        Specialty specialtySaved = specialtyService.save(specialty);
                        specialty.setId(specialtySaved.getId());
                    }
                });
            }
            return super.save(object);
        } else {
            return null;
        }
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
