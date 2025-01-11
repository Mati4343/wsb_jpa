package com.jpacourse.mapper;
import java.util.stream.Collectors;
import com.jpacourse.dto.ToPatient;
import com.jpacourse.persistence.entity.PatientEntity;

public final class MapperPatient
{

    public static ToPatient mapToTO(final PatientEntity patientEntity)
    {
        if (patientEntity == null) {return null; }

        final ToPatient topatient = new ToPatient();
        topatient.setId(patientEntity.getId());
        topatient.setFirstName(patientEntity.getFirstName());
        topatient.setLastName(patientEntity.getLastName());
        topatient.setTelephoneNumber(patientEntity.getTelephoneNumber());
        topatient.setEmail(patientEntity.getEmail());
        topatient.setPatientNumber(patientEntity.getPatientNumber());
        topatient.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        topatient.setDateOfBirth(patientEntity.getDateOfBirth());
        topatient.setDiabetes(patientEntity.getDiabetes());

        if(patientEntity.getAddress() != null)
        {
            topatient.setAddress(AddressMapper.mapToTO(patientEntity.getAddress()));
        }

        topatient.setVisits(patientEntity.getVisits() != null ? patientEntity.getVisits().stream()
                .map(MapperVisit::mapForPatientToTO)
                .collect(Collectors.toList())
                : null);

        return topatient;
    }

    public static PatientEntity mapToEntity(final ToPatient topatient)
    {
        if(topatient == null) {return null; }

        final PatientEntity patientEntity = new PatientEntity();
        patientEntity.setId(topatient.getId());
        patientEntity.setFirstName(topatient.getFirstName());
        patientEntity.setLastName(topatient.getLastName());
        patientEntity.setTelephoneNumber(topatient.getTelephoneNumber());
        patientEntity.setEmail(topatient.getEmail());
        patientEntity.setPatientNumber(topatient.getPatientNumber());
        patientEntity.setAddress(AddressMapper.mapToEntity(topatient.getAddress()));
        patientEntity.setDateOfBirth(topatient.getDateOfBirth());
        patientEntity.setDiabetes(topatient.getDiabetes());

        if(topatient.getAddress() != null)
        {
            patientEntity.setAddress(AddressMapper.mapToEntity(topatient.getAddress()));
        }

        patientEntity.setVisits(topatient.getVisits() != null ? topatient.getVisits().stream()
                .map(MapperVisit::mapForPatientToEntity)
                .collect(Collectors.toList())
                :null);

        return patientEntity;
    }
}
