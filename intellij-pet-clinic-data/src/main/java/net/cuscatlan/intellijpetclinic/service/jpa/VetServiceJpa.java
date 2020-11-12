package net.cuscatlan.intellijpetclinic.service.jpa;

import net.cuscatlan.intellijpetclinic.model.Vet;
import net.cuscatlan.intellijpetclinic.repository.VetRepository;
import net.cuscatlan.intellijpetclinic.service.VetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Profile("springJpaService")
public class VetServiceJpa implements VetService {
    public final VetRepository vetRepository;

    public VetServiceJpa(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    static int numero = 0;
    @Override
    public Set<Vet> findAll() {
        Set<Vet> vets = new HashSet<>();

        vets.addAll(vetRepository.findAll());

   /*     System.out.println("Ingresando al servicio findAll");
         vetRepository.findAll().forEach(data -> {
            vets.add(data);
            numero++;
            System.out.println(data.getSpecialties().toString());
            System.out.println(data.getFirstName());
        });
     //   vets.addAll(vetRepository.findAll());
        System.out.println("número " + numero);
        System.out.println("Cantidad " + vets.size());*/
        return vets;
    }

    @Override
    public Vet findById(Long aLong) {
        return vetRepository.findById(aLong).orElse(null);
    }

    @Override
    public Vet save(Vet object) {
        return vetRepository.save(object);
    }

    @Override
    public void delete(Vet object) {
        vetRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetRepository.deleteById(aLong);
    }
}
