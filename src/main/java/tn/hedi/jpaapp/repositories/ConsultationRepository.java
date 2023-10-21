package tn.hedi.jpaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.hedi.jpaapp.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
