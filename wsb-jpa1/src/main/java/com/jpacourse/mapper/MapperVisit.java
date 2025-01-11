package com.jpacourse.mapper;
import java.util.stream.Collectors;
import com.jpacourse.dto.ToVisit;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.persistence.entity.DoctorEntity;

public class MapperVisit
{
    public static ToVisit mapToTO(final VisitEntity visitEntity)
    {
        if(visitEntity == null) {return null; }


        final ToVisit tovisit = new ToVisit();
        tovisit.setId(visitEntity.getId());
        tovisit.setDescription(visitEntity.getDescription());
        tovisit.setMedicalTreatments(visitEntity.getMedicalTreatments() != null ? visitEntity.getMedicalTreatments().stream()
                .map(MapperMedicalTreatment::mapToTO).collect(Collectors.toList()):null);

        tovisit.setPatient(MapperPatient.mapToTO(visitEntity.getPatient()));
        tovisit.setDoctor(MapperDoctor.mapToTO(visitEntity.getDoctor()));
        tovisit.setTime(visitEntity.getTime());
        return tovisit;
    }


    public static VisitEntity mapToEntity(final ToVisit tovisit)
    {
        if(tovisit == null) {return null; }


        final VisitEntity visitEntity = new VisitEntity();
        visitEntity.setId(tovisit.getId());
        visitEntity.setDescription(tovisit.getDescription());
        visitEntity.setMedicalTreatments(tovisit.getMedicalTreatments() != null ? tovisit.getMedicalTreatments().stream()
                .map(MapperMedicalTreatment::mapToEntity).collect(Collectors.toList()):null);

        visitEntity.setPatient(MapperPatient.mapToEntity(tovisit.getPatient()));
        visitEntity.setDoctor(MapperDoctor.mapToEntity(tovisit.getDoctor()));
        visitEntity.setTime(tovisit.getTime());
        return visitEntity;

    }


    public static ToVisit mapForPatientToTO(final VisitEntity visitEntity)
    {
        if (visitEntity == null) {return null; }

        final ToVisit tovisit = new ToVisit();
        tovisit.setId(visitEntity.getId());
        tovisit.setDescription(visitEntity.getDescription());
        tovisit.setMedicalTreatments(visitEntity.getMedicalTreatments() != null ? visitEntity.getMedicalTreatments().stream()
                .map(MapperMedicalTreatment::mapToTO).collect(Collectors.toList()):null);

        tovisit.setDoctor(MapperDoctor.mapToTO(visitEntity.getDoctor()));
        tovisit.setTime(visitEntity.getTime());
        return tovisit;
    }


    public static VisitEntity mapForPatientToEntity(final ToVisit tovisit)
    {
        if(tovisit == null) {return null; }


    final VisitEntity visitEntity = new VisitEntity();
    tovisit.setId(tovisit.getId());
        visitEntity.setDescription(tovisit.getDescription());
        visitEntity.setMedicalTreatments(tovisit.getMedicalTreatments() != null ? tovisit.getMedicalTreatments().stream()
                .map(MapperMedicalTreatment::mapToEntity).collect(Collectors.toList()):null);

        visitEntity.setDoctor(MapperDoctor.mapToEntity(tovisit.getDoctor()));
        visitEntity.setTime(tovisit.getTime());
        return visitEntity;
    }
}
