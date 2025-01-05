package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY) //relacja dwustronna
	private Collection<MedicalTreatmentEntity> medicalTreatments;

	@ManyToOne //relacja dwustronna
	@JoinColumn(name = "id_patient")
	private PatientEntity patient;

	@ManyToOne //relacja dwustronna
	@JoinColumn(name = "id_doctor")
	private DoctorEntity doctor;


	@Column(nullable = false)
	private LocalDateTime time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public DoctorEntity getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorEntity doctor) {
		this.doctor = doctor;
	}

	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public Collection<MedicalTreatmentEntity> getMedicalTreatments() {
		return medicalTreatments;
	}
	public void addMedicalTreatment(MedicalTreatmentEntity medicalTreatment) {
		medicalTreatments.add(medicalTreatment);
		medicalTreatment.setVisit(this);
	}
	public void removeMedicalTreatment(MedicalTreatmentEntity medicalTreatment) {
		medicalTreatments.remove(medicalTreatment);
		medicalTreatment.setVisit(null);
	}

}
