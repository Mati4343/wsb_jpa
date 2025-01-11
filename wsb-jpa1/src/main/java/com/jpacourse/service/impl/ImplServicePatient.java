package com.jpacourse.service.impl;
import java.util.Collection;
import java.time.LocalDateTime;
import com.jpacourse.dto.ToPatient;
import com.jpacourse.mapper.MapperPatient;
import com.jpacourse.persistence.dao.DaoPatient;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.service.ServicePatient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ImplServicePatient implements ServicePatient {
    private final DaoPatient daoPatient;

    @Autowired
    public ImplServicePatient(DaoPatient pomDaoPatient) {
        daoPatient = pomDaoPatient;
    }

    @Override
    @Transactional
    public void dropPatient(Long Id_patient) {
        this.daoPatient.dropIdPatient(Id_patient);
    }

    @Override
    @Transactional(readOnly = true)
    public ToPatient getIdPatient(Long Id_patient) {
        PatientEntity patientEntity = this.daoPatient.searchIdPatient(Id_patient);
        return MapperPatient.mapToTO(patientEntity);
    }

    @Override
    @Transactional
    public ToPatient updatePatient(ToPatient toPatient) {
        PatientEntity patientEntity = MapperPatient.mapToEntity(toPatient);
        PatientEntity pom_entity = this.daoPatient.updatePatient(patientEntity);
        return MapperPatient.mapToTO(pom_entity);
    }

    @Override
    @Transactional
    public void addVisitPatient(Long Id_patient, Long Id_doctor, String description, LocalDateTime time) {
        this.daoPatient.addVisitPatient(Id_patient, Id_doctor, description, time);
    }


}
