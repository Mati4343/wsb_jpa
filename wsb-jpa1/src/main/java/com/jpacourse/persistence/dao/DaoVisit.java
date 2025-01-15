package com.jpacourse.persistence.dao;
import java.util.List;
import com.jpacourse.persistence.entity.VisitEntity;
import java.util.Collection;

public interface DaoVisit extends Dao<VisitEntity, Long>
{
   //List<VisitEntity> searchPatient(Long id_patient);
    Collection<VisitEntity> searchPatient(Long id_patient);
}

