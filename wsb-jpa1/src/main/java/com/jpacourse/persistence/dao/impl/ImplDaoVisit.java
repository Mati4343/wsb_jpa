package com.jpacourse.persistence.dao.impl;
import java.util.List;
import com.jpacourse.persistence.dao.DaoVisit;
import com.jpacourse.persistence.entity.VisitEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ImplDaoVisit extends AbstractDao<VisitEntity, Long> implements DaoVisit
{
    @Override
    public List<VisitEntity> searchPatient(Long id_patient)
    {
        return this.entityManager.createQuery("SELECT v FORM VisitEntity v WHERE v.patient.id = :id_patient", VisitEntity.class)
                .setParameter("IdPatient", id_patient)
                .getResultList();
    }
}
