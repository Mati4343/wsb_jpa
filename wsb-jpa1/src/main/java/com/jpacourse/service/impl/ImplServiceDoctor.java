package com.jpacourse.service.impl;

import com.jpacourse.dto.ToDoctor;
import com.jpacourse.mapper.MapperDoctor;
import com.jpacourse.persistence.dao.DaoDoctor;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.service.ServiceDoctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ImplServiceDoctor implements ServiceDoctor
{
    private final DaoDoctor daoDoctor;

    @Autowired
    public ImplServiceDoctor(DaoDoctor pomDaoDoctor)
    {
        daoDoctor = pomDaoDoctor;
    }

    @Override
    public ToDoctor searchId(Long id) {
        final DoctorEntity entity = daoDoctor.findOne(id);
        return MapperDoctor.mapToTO(entity);
    }
}
