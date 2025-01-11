package com.jpacourse.rest;
import java.time.LocalDateTime;
import com.jpacourse.dto.ToPatient;
import com.jpacourse.rest.exception.EntityNotFoundException;
import com.jpacourse.service.ServicePatient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class ControllerPatient {
    @Autowired
    private ServicePatient servicePatient;

    @GetMapping("/{id}")
    public ResponseEntity<ToPatient> getIdPatient(@PathVariable Long id) {
        ToPatient patient = servicePatient.getIdPatient(id);
        if (patient == null) {
            throw new EntityNotFoundException(id);
        }

        return ResponseEntity.ok(patient);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ToPatient> updatePatient(@RequestBody ToPatient toPatient) {
        ToPatient pom_patient = servicePatient.updatePatient(toPatient);
        return ResponseEntity.ok(pom_patient);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> dropPatient(@PathVariable Long id) {
        servicePatient.dropPatient(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/visits")
    public ResponseEntity<Void> addVisit(@PathVariable Long id, @RequestParam Long Id_doctor, @RequestParam String description, @RequestParam String time) {
        LocalDateTime TimeVisit = LocalDateTime.parse(time);
        servicePatient.addVisitPatient(id, Id_doctor, description, TimeVisit);
        return ResponseEntity.ok().build();
    }
}
