package com.jpacourse.persistence.dao.impl;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;
import com.jpacourse.persistence.dao.DaoPatient;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import java.time.LocalDateTime;
import java.util.Collection;

@Repository
public class ImplDaoPatient extends AbstractDao<PatientEntity, Long> implements DaoPatient
{
    @Override
    @Transactional
    /*public void dropIdPatient(Long id_patient) {
        PatientEntity patient = entityManager.find(PatientEntity.class, id_patient);
        if (patient != null) {entityManager.remove(patient); }

     */
    public PatientEntity searchIdPatient(Long id_patient)
    {
        return entityManager.find(PatientEntity.class, id_patient);
    }


    @Override
    @Transactional
    /*public PatientEntity searchIdPatient(Long id_patient) {
        return entityManager.find(PatientEntity.class, id_patient);
    }*/

    public Collection<PatientEntity> searchLastNamePatient(String lastName)
    {
        return entityManager.createQuery("SELECT paten FROM PatientEntity paten WHERE paten.lastName = :lastName", PatientEntity.class)
                .setParameter("lastName", lastName)
                .getResultList();
    }

    @Override
    @Transactional
    public Collection<PatientEntity> searchPatientTotalVisit(int totalPatientVisit){
        return entityManager.createQuery("SELECT paten FROM PatientEntity paten WHERE size(paten.visits) > :visitsTotal", PatientEntity.class)
        .setParameter("visitsTotal", totalPatientVisit)
                .getResultList();
    }

    @Override
    @Transactional
    public Collection<PatientEntity> searchDiabetesPatient(Boolean diabetes)
    {
        return entityManager.createQuery("SELECT paten FROM PatientEntity paten WHERE paten.diabetes = :statusDiabetes", PatientEntity.class)
                .setParameter("statusDiabetes", diabetes)
                .getResultList();
    }


    @Override
    @Transactional
    public PatientEntity updatePatient(PatientEntity patientEntity) {
        return entityManager.merge(patientEntity);


    }

    @Override
    @Transactional
    public VisitEntity addVisitPatient(Long Id_patient, Long Id_doctor, String description, LocalDateTime time) {
        PatientEntity patient = entityManager.find(PatientEntity.class, Id_patient);
        if (patient != null) {
            VisitEntity visit = new VisitEntity();
            visit.setDoctor(entityManager.find(DoctorEntity.class, Id_doctor));
            visit.setPatient(patient);
            visit.setDescription(description);
            visit.setTime(time);
            patient.getVisits().add(visit);
            entityManager.merge(patient);
            return visit;
        }
        return null;
    }

    @Override
    @Transactional
    public void dropIdPatient(Long id_patient)
    {
        PatientEntity patient = entityManager.find(PatientEntity.class, id_patient);
        if(patient != null)
            entityManager.remove(patient);
    }

}
