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
import java.util.*;
import static org.junit.Assert.*;


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

    @Test
    public void testSearchLastNamePatient()
    {
        //given
        String lastName = "Kaczmarek";

        //when
        Collection<PatientEntity> res = daoPatient.searchLastNamePatient(lastName);
        List<PatientEntity> listRes = new ArrayList<>(res);

        //then
        assertNotNull(listRes);
        assertFalse(listRes.isEmpty());
        assertEquals(listRes.size(), 2);
        assertEquals(listRes.get(0).getLastName(), lastName);
        assertEquals(listRes.get(1).getLastName(), lastName);
    }

    @Test
    public void testSearchTotalVisitPatient()
    {
        //given
        int totalPatientVisit = 2;

        //when
        Collection<PatientEntity> res = daoPatient.searchPatientTotalVisit(totalPatientVisit);
        List<PatientEntity> listRes = new ArrayList<>(res);

        //then
        assertNotNull(listRes);
        assertFalse(listRes.isEmpty());
        assertEquals(3, listRes.size());
        PatientEntity patient = listRes.get(0);
        assertThat(patient).isNotNull();
        assertEquals("Marek", patient.getFirstName());


        assertThat(patient.getId()).isEqualTo(2L);
        assertThat(patient.getFirstName()).isEqualTo("Marek");
        assertThat(patient.getLastName()).isEqualTo("Lawniczak");
        assertThat(patient.getEmail()).isEqualTo("marek.lawniczak@interia.pl");
        assertThat(patient.getPatientNumber()).isEqualTo("PATI0009");
        assertThat(patient.getTelephoneNumber()).isEqualTo("+48 606 789 012");
        assertThat(patient.getDateOfBirth()).isEqualTo("1980-04-13");
    }

    @Test
    public void searchDiabetesPatient() {
        // given
        Boolean diabetes = true;

        // when
        Collection<PatientEntity> res = daoPatient.searchDiabetesPatient(diabetes);
        List<PatientEntity> listRes = new ArrayList<>(res);

        // then
        assertNotNull(listRes);
        assertFalse(listRes.isEmpty());
        assertEquals(4, listRes.size());

        PatientEntity patient = listRes.get(0);
        assertNotNull(patient);
        assertEquals("Julia", patient.getFirstName());
        assertEquals("Kowalska", patient.getLastName());
        assertEquals("PATI0004", patient.getPatientNumber());
        assertThat(patient.getDiabetes()).isEqualTo(diabetes);

        PatientEntity patient2 = listRes.get(1);
        assertNotNull(patient2);
        assertEquals("Ewa", patient2.getFirstName());
        assertEquals("Pawlak", patient2.getLastName());
        assertEquals("PATI0010", patient2.getPatientNumber());
        assertThat(patient2.getDiabetes()).isEqualTo(diabetes);


        PatientEntity patient3 = listRes.get(2);
        assertNotNull(patient3);
        assertEquals("Krzysztof", patient3.getFirstName());
        assertEquals("Stolarz", patient3.getLastName());
        assertEquals("PATI0014", patient3.getPatientNumber());
        assertThat(patient3.getDiabetes()).isEqualTo(diabetes);
    }



}
