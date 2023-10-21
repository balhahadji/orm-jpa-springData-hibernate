package tn.hedi.jpaapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.hedi.jpaapp.entities.Patient;
import tn.hedi.jpaapp.sevices.HospitalService;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private HospitalService hospitalService;

    @GetMapping("/patients")
    public List<Patient> patientList() {
        return hospitalService.findAllPatients();
    }
}
