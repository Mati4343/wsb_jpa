package com.jpacourse.service.impl;

import com.jpacourse.dto.ToVisit;
import com.jpacourse.mapper.MapperVisit;
import com.jpacourse.persistence.dao.DaoVisit;
import com.jpacourse.persistence.entity.VisitEntity;
import com.jpacourse.service.ServiceVisit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ImplServiceVisit implements ServiceVisit{
    private final DaoVisit daoVisit;

    @Autowired
    public ImplServiceVisit(DaoVisit pom_DaoVisit)
    {
        daoVisit = pom_DaoVisit;
    }

    @Override
    public ToVisit searchId(Long id) {
        final VisitEntity entity = daoVisit.findOne(id);
        return MapperVisit.mapToTO(entity);
    }
}
