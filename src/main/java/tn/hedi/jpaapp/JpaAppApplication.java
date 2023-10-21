package tn.hedi.jpaapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tn.hedi.jpaapp.entities.Consultation;
import tn.hedi.jpaapp.entities.Medecin;
import tn.hedi.jpaapp.entities.Patient;
import tn.hedi.jpaapp.entities.RendezVous;
import tn.hedi.jpaapp.enums.StatusRDV.StatusRDV;
import tn.hedi.jpaapp.repositories.ConsultationRepository;
import tn.hedi.jpaapp.sevices.HospitalService;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class JpaAppApplication implements CommandLineRunner {
    private HospitalService hospitalService;

    public JpaAppApplication(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }


    public static void main(String[] args) {
        SpringApplication.run(JpaAppApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Stream.of("Balha", "Majdi", "Bassem", "Wissem", "Anis", "Dali", "Rabie").forEach(name -> {
            Patient patient = new Patient();
            patient.setNom(name);
            patient.setDateNaissance(new Date());
            patient.setMalade(Math.random() > 0.5 ? false : true);
            hospitalService.savePatient(patient);
        });
        Stream.of("Nader", "Khalfaoui", "Rahmouni", "Khamssa").forEach(name -> {
            Medecin medecin = new Medecin();
            medecin.setNom(name);
            medecin.setSpecialite(Math.random() > 0.5 ? "cardio" : "Dentiste");
            hospitalService.saveMedecin(medecin);
        });
        Patient patient = hospitalService.findPatientByNom("Balha");
        Medecin medecin = hospitalService.findMedecinByNom("Nader");
        RendezVous rendezVous = new RendezVous();
        rendezVous.setDate(new Date());
        rendezVous.setStatus(StatusRDV.PENDING);
        rendezVous.setMedecin(medecin);
        rendezVous.setPatient(patient);
        hospitalService.saveRDV(rendezVous);

        Consultation consultation = new Consultation();
        consultation.setDateConsultation(new Date());
        consultation.setRapport("rapport de la consultation ...");
        consultation.setRendezVous(rendezVous);
        hospitalService.saveConsultation(consultation);

    }
}

