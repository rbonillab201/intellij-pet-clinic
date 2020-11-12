package net.cuscatlan.intellijpetclinic.bootstrap;

import net.cuscatlan.intellijpetclinic.model.*;
import net.cuscatlan.intellijpetclinic.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LoadData implements CommandLineRunner {

    public final OwnerService ownerService;
    public final VetService vetService;
    public final SpecialtyService specialtyService;
    public final PetTypeService petTypeService;
    public final VisitService visitService;

    public LoadData(OwnerService ownerService, VetService vetService, SpecialtyService specialtyService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.specialtyService = specialtyService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
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

        petTypeService.save(dog1Saved);
        petTypeService.save(catSaved);

        System.out.println("Tipos de mascotas salvadas");

        Specialty surgerySaved = new Specialty();
        surgerySaved.setDescription("Surgery");

        specialtyService.save(surgerySaved);

        Specialty odontoSaved = new Specialty();
        odontoSaved.setDescription("Odonto");

        specialtyService.save(odontoSaved);

        Owner owner1 = new Owner();
        owner1.setFirstName("Renato");
        owner1.setLastName("Bonilla");
        owner1.setAddress("Colonia 3 de mayo");
        owner1.setCity("San Salvador");
        owner1.setTelephone("78874661");

        Pet perRenato = new Pet();
        perRenato.setPetType(dog1Saved);
        perRenato.setPetName("Perrito Renato");
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
        perTed.setPetName("Perro Ted");
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
        catTito.setPetName("Gato de Tito");
        catTito.setOwner(owner3);

        owner3.getPets().add(catTito);

        ownerService.save(owner1);
        ownerService.save(owner2);
        ownerService.save(owner3);
        System.out.println("Propietarios creados");

        Visit visitPerRenato = new Visit();
        visitPerRenato.setDescription("Perrito");
        visitPerRenato.setLocalDate(LocalDate.now());
        visitPerRenato.setPet(perRenato);

        Visit visitPerTed = new Visit();
        visitPerTed.setDescription("Ted Perrito");
        visitPerTed.setLocalDate(LocalDate.now());
        visitPerTed.setPet(perTed);

        Visit visitCatTito = new Visit();
        visitCatTito.setDescription("Gatito");
        visitCatTito.setLocalDate(LocalDate.now());
        visitCatTito.setPet(catTito);

        visitService.save(visitPerRenato);
        visitService.save(visitPerTed);
        visitService.save(visitCatTito);
        System.out.println("Visitas creadas");

        Vet vet1 = new Vet();
        vet1.setFirstName("Karla");
        vet1.setLastName("Bonilla");
        vet1.getSpecialties().add(surgerySaved);

        Vet vet2 = new Vet();
        vet2.setFirstName("Gaby");
        vet2.setLastName("Bonilla");
        vet2.getSpecialties().add(odontoSaved);

        vetService.save(vet2);
        vetService.save(vet1);
        System.out.println("Veterinarios creados");
    }
}
