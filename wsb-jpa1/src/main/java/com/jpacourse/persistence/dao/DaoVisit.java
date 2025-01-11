package com.jpacourse.persistence.dao;
import java.util.List;
import com.jpacourse.persistence.entity.VisitEntity;

public interface DaoVisit extends Dao<VisitEntity, Long>
{
    List<VisitEntity> searchPatient(Long id_patient);
}

