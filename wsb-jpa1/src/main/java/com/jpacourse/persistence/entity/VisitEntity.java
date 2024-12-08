package com.jpacourse.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name = "VISIT")
public class VisitEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	@OneToMany(mappedBy = "visit", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private Collection<MedicalTreatmentEntity> medicalTreatments;

	@ManyToOne
	@JoinColumn(name = "patient_id")
	private PatientEntity patient;


	@ManyToOne
	@JoinColumn(name = "doctor_id")
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
