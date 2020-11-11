package net.cuscatlan.intellijpetclinic.service.map;

import net.cuscatlan.intellijpetclinic.model.Visit;
import net.cuscatlan.intellijpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
@Profile({"default","map"})
public class VisitServiceMap extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public Visit save(Visit object) {
        if(object != null) {
            if(object.getPet() == null || object.getPet().getOwner() == null ||
                    object.getPet().getId() == null || object.getPet().getOwner().getId() == null){
                throw new RuntimeException("No se tienen todos los elementos, pueda que falte l mascota o el dueño");
            } else {
                return super.save(object);
            }
        } else {
            return null;
        }
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteById(aLong);
    }
}
