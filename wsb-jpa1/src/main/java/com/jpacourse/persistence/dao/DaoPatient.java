package com.jpacourse.persistence.dao;
import java.time.LocalDateTime;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
public interface DaoPatient extends Dao<PatientEntity, Long> {
    PatientEntity searchIdPatient(Long id_patient);
    PatientEntity updatePatient(PatientEntity patientEntity);

    void dropIdPatient(Long id_patient);
    VisitEntity addVisitPatient(Long id_patient, Long id_doctor, String description, LocalDateTime time);




}
