package com.jpacourse.persistence.dao.impl;

import com.jpacourse.persistence.dao.DaoDoctor;
import com.jpacourse.persistence.entity.DoctorEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ImplDaoDoctor extends AbstractDao<DoctorEntity, Long> implements DaoDoctor
{

}
