package com.jpacourse.service;

import com.jpacourse.dto.ToDoctor;
import com.jpacourse.dto.ToPatient;
import com.jpacourse.dto.ToVisit;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
class TestServiceVisit {
    @Autowired
    private ServiceVisit serviceVisit;


    @Test
    public void testSearchAllVisitIdPatient() {
        // given
        Long id_patient = 1L;

        // when
        Collection<ToVisit> vis = serviceVisit.searchAllIdPatient(id_patient);
        List<ToVisit> lisVis = new ArrayList<>(vis);

        // then
        assertNotNull(lisVis);
        assertThat(lisVis).hasSize(2);

        ToVisit firstVis = lisVis.get(0); //weryfikacja pierwsza wizyta
        assertThat(firstVis).isNotNull();
        assertThat(firstVis.getId()).isEqualTo(2L);
        assertThat(firstVis.getDescription()).isEqualTo("Vis_10");
        assertThat(firstVis.getTime()).isEqualTo(LocalDateTime.parse("2024-12-07T08:45:30"));

        ToPatient patient = firstVis.getPatientEntity(); //weryfikacja pacjent
        assertThat(patient).isNotNull();
        assertThat(patient.getId()).isEqualTo(1L);
        assertThat(patient.getFirstName()).isEqualTo("Julia");
        assertThat(patient.getLastName()).isEqualTo("Kowalska");

        DoctorTO doctor = firstVis.getDoctor(); //weryfikacja doktor
        assertThat(doctor).isNotNull();
        assertThat(doctor.getFirstName()).isEqualTo("Beata");
        assertThat(doctor.getLastName()).isEqualTo("Stolarz");
    }
}