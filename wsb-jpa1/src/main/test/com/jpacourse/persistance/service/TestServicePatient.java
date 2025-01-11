package com.jpacourse.persistance.dao;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDateTime;
import com.jpacourse.persistence.dao.ToPatinet;
import com.jpacourse.persistence.dao.AddressDao;
import com.jpacourse.persistence.dao.DaoDoctor;
import com.jpacourse.persistence.dao.DaoVisit;



@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class TestServicePatient
{
    @Autowired
    private ServicePatient servicePatient;

    @Autowired
    private AddressDao addressDao;

    @Autowired
    private DaoDoctor daoDoctor;

    @Autowired
    private DaoVisit daoVisit;


    @Test
    public void dropPatient_visitPatinet() {
        // given
        ToPatinet bef_patient = servicePatient.getIdPatient(1L);
        assertThat(bef_patient).isNotNull();
        assertThat(daoVisit.findByPatient(1L)).isNotEmpty();


        int total_doctor = daoDoctor.findAll().size();

        //when
        servicePatient.dropPatient(1L);


        // then
        ToPatient aft_patient = servicePatient.getIdPatient(1L);
        assertThat(aft_patient).isNull();
        assertThat(daoVisit.searchPatient(1L)).isEmpty();
        assertThat(daoDoctor.findAll().size()).isEqualTo(total_doctor);
    }


    @Test
    public void searchIdPatient() {
        // when
        ToPatient patient = servicePatient.getIdPatient(1L);
        // then
        assertThat(patient).isNotNull();
        assertThat(patient.getFirstName()).isEqualTo("Aneta");
        assertThat(patient.getLastName()).isEqualTo("Kaczmarek");
        assertThat(patient.getTelephoneNumber()).isEqualTo("+48 605 678 901");
        assertThat(patient.getEmail()).isEqualTo("aneta.kaczmarek@gmail.com");
        assertThat(patient.getPatientNumber()).isEqualTo("PATI0008");
        assertThat(patient.getAddress()).isEqualToComparingFieldByField(addressDao.findOne(4L));
        assertThat(patient.getVisits()).size().isEqualTo(2);
    }
}
