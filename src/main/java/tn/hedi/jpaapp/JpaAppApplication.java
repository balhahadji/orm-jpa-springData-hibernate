package tn.hedi.jpaapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import tn.hedi.jpaapp.entities.Patient;
import tn.hedi.jpaapp.repositories.PatientRepository;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < 30; i++) {
            patientRepository.save(new Patient(null, "balha", new Date(), Math.random() > 0.5 ? true : false, (int) (Math.random() * 100)));
            patientRepository.save(new Patient(null, "samir", new Date(), false, (int) (Math.random() * 100)));
            patientRepository.save(new Patient(null, "foued", new Date(), false, (int) (Math.random() * 100)));
        }
        /*patientRepository.save(new Patient(null, "balha", new Date(), , 55));
        patientRepository.save(new Patient(null, "samir", new Date(), false, 23));
        patientRepository.save(new Patient(null, "foued", new Date(), false, 76));*/
        //List<Patient> patients=patientRepository.findAll();
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(1, 5));
        System.out.println("nombre de tout les page= " + patients.getTotalPages());
        System.out.println("total elements = " + patients.getTotalElements());
        System.out.println("num de page= " + patients.getNumber());
        List<Patient> content = patients.getContent();
        List<Patient> byMalade = patientRepository.findByMalade(true);
        Page<Patient> byMaladePage = patientRepository.findByMalade(true, PageRequest.of(1, 5));
        byMaladePage.forEach(patient -> {
            System.out.println("================================");
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.getScore());
            System.out.println(patient.getDateNaissance());
            System.out.println(patient.isMalade());
        });
        System.out.println("*************************************");
        Patient patient = patientRepository.findById(1L).orElse(null);
        if (patient != null) {
            System.out.println("nom= " + patient.getNom());
            System.out.println("malade? = " + patient.isMalade());
            System.out.println("score= " + patient.getScore());
        }
        patient.setScore(854);
        System.out.println(patient.getScore());
        //patientRepository.deleteById(1L);
        System.out.println("#####################################################################");
        List<Patient> patientList= patientRepository.chercherPatients("balha",30);
        patientList.forEach(patient1 -> {
            System.out.println("================================");
            System.out.println(patient1.getId());
            System.out.println(patient1.getNom());
            System.out.println(patient1.getScore());
            System.out.println(patient1.getDateNaissance());
            System.out.println(patient1.isMalade());
        });

    }
}
