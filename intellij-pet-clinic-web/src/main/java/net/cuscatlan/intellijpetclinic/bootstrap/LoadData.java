package net.cuscatlan.intellijpetclinic.bootstrap;

import net.cuscatlan.intellijpetclinic.model.Owner;
import net.cuscatlan.intellijpetclinic.model.Vet;
import net.cuscatlan.intellijpetclinic.service.OwnerService;
import net.cuscatlan.intellijpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadData implements CommandLineRunner {

    OwnerService ownerService;
    VetService vetService;

    public LoadData(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        Owner owner1 = new Owner();
        owner1.setFirstName("Renato");
        owner1.setLastName("Bonilla");

        Owner owner2 = new Owner();
        owner2.setFirstName("Ted");
        owner2.setLastName("Bonilla");

        ownerService.save(owner1);
        ownerService.save(owner2);
        System.out.println("Propietarios creados");

        Vet vet1 = new Vet();
        vet1.setFirstName("Karla");
        vet1.setLastName("Bonilla");

        Vet vet2 = new Vet();
        vet2.setFirstName("Gaby");
        vet2.setLastName("Bonilla");

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Veterinarios creados");





    }
}
