package com.jpacourse.mapper;
import com.jpacourse.dto.ToMedicalTreatment;
import com.jpacourse.persistence.enums.TreatmentType;
import com.jpacourse.persistence.entity.MedicalTreatmentEntity;
import java.util.stream.Collectors;


public final class MapperMedicalTreatment
{

    public static ToMedicalTreatment mapToTO(final MedicalTreatmentEntity medicaltreatmentEntity)
    {
        if (medicaltreatmentEntity == null) {return null; }

        final ToMedicalTreatment tomedicaltreatment = new ToMedicalTreatment();
        tomedicaltreatment.setId(medicaltreatmentEntity.getId());
        tomedicaltreatment.setDescription(medicaltreatmentEntity.getDescription());
        if(medicaltreatmentEntity.getType() != null)
        {
            tomedicaltreatment.setTypeTreatment(medicaltreatmentEntity.getType().name());
        }
        return tomedicaltreatment;
    }

    public static MedicalTreatmentEntity mapToEntity(final ToMedicalTreatment tomedicaltreatment)
    {
        if(tomedicaltreatment == null) {return null; }

        final MedicalTreatmentEntity medicaltreatmentEntity = new MedicalTreatmentEntity();
        medicaltreatmentEntity.setId(tomedicaltreatment.getId());
        medicaltreatmentEntity.setDescription(tomedicaltreatment.getDescription());
        if(tomedicaltreatment.getTypeTreatment() != null)
        {
            medicaltreatmentEntity.setType(Enum.valueOf(TreatmentType.class, tomedicaltreatment.getTypeTreatment()));
        }
        return medicaltreatmentEntity;
    }
}
