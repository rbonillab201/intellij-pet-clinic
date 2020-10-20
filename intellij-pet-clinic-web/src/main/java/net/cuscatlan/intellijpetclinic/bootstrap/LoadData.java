package net.cuscatlan.intellijpetclinic.bootstrap;

import net.cuscatlan.intellijpetclinic.model.*;
import net.cuscatlan.intellijpetclinic.service.OwnerService;
import net.cuscatlan.intellijpetclinic.service.PetTypeService;
import net.cuscatlan.intellijpetclinic.service.SpecialtyService;
import net.cuscatlan.intellijpetclinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;
    public final SpecialtyService specialtyService;
    public final PetTypeService petTypeService;

    public LoadData(OwnerService ownerService, VetService vetService, SpecialtyService specialtyService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        int conteo = ownerService.findAll().size();
        if (conteo == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog1Saved = new PetType();
        dog1Saved.setName("Perro");

        PetType catSaved = new PetType();
        catSaved.setName("Gato");

        System.out.println("Tipos de mascotas salvadas");

        Specialty surgerySaved = new Specialty();
        surgerySaved.setDescription("Surgery");

        Owner owner1 = new Owner();
        owner1.setFirstName("Renato");
        owner1.setLastName("Bonilla");
        owner1.setAddress("Colonia 3 de mayo");
        owner1.setCity("San Salvador");
        owner1.setTelephone("78874661");

        Pet perRenato = new Pet();
        perRenato.setPetType(dog1Saved);
        perRenato.setBirthDate(LocalDate.now());
        perRenato.setOwner(owner1);

        owner1.getPets().add(perRenato);

        Owner owner2 = new Owner();
        owner2.setFirstName("Ted");
        owner2.setLastName("Bonilla");
        owner2.setAddress("Colonia 3 de mayo");
        owner2.setCity("San Salvador");
        owner2.setTelephone("78874632");

        Pet perTed = new Pet();
        perTed.setBirthDate(LocalDate.now());
        perTed.setPetType(dog1Saved);
        perTed.setOwner(owner2);

        owner2.getPets().add(perTed);

        Owner owner3 = new Owner();
        owner3.setFirstName("Tito");
        owner3.setLastName("Bonilla");
        owner3.setAddress("Colonia 3 de mayo");
        owner3.setCity("San Salvador");
        owner3.setTelephone("78836661");

        Pet catTito = new Pet();
        catTito.setBirthDate(LocalDate.now());
        catTito.setPetType(catSaved);
        catTito.setOwner(owner3);

        owner3.getPets().add(catTito);

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);
        System.out.println("Propietarios creados");

        Vet vet1 = new Vet();
        vet1.setFirstName("Karla");
        vet1.setLastName("Bonilla");
        vet1.getSpecialties().add(surgerySaved);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gaby");
        vet2.setLastName("Bonilla");
        vet2.getSpecialties().add(surgerySaved);

        vetService.save(vet1);
        vetService.save(vet2);
        System.out.println("Veterinarios creados");
    }
}
