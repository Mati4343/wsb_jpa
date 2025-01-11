package com.jpacourse.persistance.dao;
import com.jpacourse.persistence.dao.DaoDoctor;
import com.jpacourse.persistence.entity.DoctorEntity;
import com.jpacourse.persistence.dao.DaoPatient;
import com.jpacourse.persistence.entity.PatientEntity;
import com.jpacourse.persistence.entity.VisitEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestDaoPatient
{
    @Autowired
    private DaoDoctor daoDoctor;

    @Autowired
    private DaoPatient daoPatient;

    @Test
    public void createVisit() {
        // given
        PatientEntity patient = daoPatient.findOne(1L);
        DoctorEntity doctor = daoDoctor.findOne(1L);
        LocalDateTime dateVisit = LocalDateTime.now();
        assertThat(patient).isNotNull();
        assertThat(doctor).isNotNull();
        int totalPatientVisit = patient.getVisits().size();

        // when
        VisitEntity res_visit = daoPatient.addPatientVisit(1L, 1L, "test visit1", dateVisit);

        // then
        assertThat(res_visit).isNotNull();

        assertThat(patient.getVisits().size()).isEqualTo(totalPatientVisit + 1);
        assertThat(result.getPatient().getId()).isEqualTo(patient.getId());
        assertThat(result.getDoctor().getId()).isEqualTo(doctor.getId());
        assertThat(result.getDescription()).isEqualTo("test visit1");
        assertThat(result.getTime()).isEqualTo(visitDate);
    }

}
