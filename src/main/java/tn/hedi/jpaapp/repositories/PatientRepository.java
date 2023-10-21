package tn.hedi.jpaapp.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.hedi.jpaapp.entities.Patient;

import java.util.Date;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient findByNom(String nom);

   /* public List<Patient> findByMalade(boolean m);

    Page<Patient> findByMalade(boolean m, Pageable pageable);

    List<Patient> findByMaladeAndScoreLessThan(boolean m, int sore);

    List<Patient> findByMaladeIsTrueAndScoreLessThan(int sore);

    List<Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNom(Date d1, Date d2, String mc);*/

    /*@Query("select p from Patient p where p.nom like :x and p.score< :y")
    List<Patient> chercherPatients(@Param("x") String nom, @Param("y") int scoreMin);*/

}
