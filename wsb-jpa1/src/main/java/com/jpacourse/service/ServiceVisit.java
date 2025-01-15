package com.jpacourse.service;
import java.util.Collection;
import com.jpacourse.dto.ToVisit;

public interface ServiceVisit
{
    ToVisit searchId(final Long id);
    public Collection<ToVisit> searchAllIdPatient(final Long id_patient);
}
