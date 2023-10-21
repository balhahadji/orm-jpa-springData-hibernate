package tn.hedi.jpaapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.hedi.jpaapp.entities.Medecin;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
    Medecin findByNom(String nom);
}
