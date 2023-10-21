package tn.hedi.jpaapp.sevices;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import tn.hedi.jpaapp.entities.Consultation;
import tn.hedi.jpaapp.entities.Medecin;
import tn.hedi.jpaapp.entities.Patient;
import tn.hedi.jpaapp.entities.RendezVous;
import tn.hedi.jpaapp.repositories.ConsultationRepository;
import tn.hedi.jpaapp.repositories.MedecinRepository;
import tn.hedi.jpaapp.repositories.PatientRepository;
import tn.hedi.jpaapp.repositories.RendezVousRepository;

import java.util.List;

@Service
@Transactional
public class HospitalServiceImpl implements HospitalService {
    private PatientRepository patientRepository;
    private MedecinRepository medecinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public HospitalServiceImpl(PatientRepository patientRepository, MedecinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medecin saveMedecin(Medecin medecin) {

        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {

        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }

    @Override
    public Patient findPatientByNom(String nom) {
        return patientRepository.findByNom(nom);
    }

    @Override
    public Medecin findMedecinByNom(String nom) {
        return medecinRepository.findByNom(nom);
    }

    @Override
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }
}
