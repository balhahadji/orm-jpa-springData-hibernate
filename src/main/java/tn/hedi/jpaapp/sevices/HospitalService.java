package tn.hedi.jpaapp.sevices;

import tn.hedi.jpaapp.entities.Consultation;
import tn.hedi.jpaapp.entities.Medecin;
import tn.hedi.jpaapp.entities.Patient;
import tn.hedi.jpaapp.entities.RendezVous;

import java.util.List;

public interface HospitalService {
    Patient savePatient(Patient patient);

    Medecin saveMedecin(Medecin medecin);

    RendezVous saveRDV(RendezVous rendezVous);

    Consultation saveConsultation(Consultation consultation);

    Patient findPatientByNom(String nom);

    Medecin findMedecinByNom(String nom);
    List<Patient> findAllPatients();

}
