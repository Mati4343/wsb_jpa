package com.jpacourse.service;
import java.time.LocalDateTime;
import com.jpacourse.dto.ToPatient;

public interface ServicePatient
{
    ToPatient getIdPatient(final Long id_patient);
    ToPatient updatePatient(ToPatient topatient);

    void dropPatient(Long id_patient);
    void addVisitPatient(Long id_patient, Long id_doctor, String description, LocalDateTime time);
}
