package com.jpacourse.dto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import java.util.Collection;

public class ToVisit {

	private Long id;
	private String description;
	private Collection<ToMedicalTreatment> medicalTreatments;
	private ToPatient patient;
	private ToDoctor doctor;
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

	public Collection<ToMedicalTreatment> getMedicalTreatments() {
		return medicalTreatments;
	}


	public void setMedicalTreatments(Collection<ToMedicalTreatment> medicalTreatments) {
		this.medicalTreatments=medicalTreatments;
	}

	public ToPatient getPatient() {
		return patient;
	}
	public void setPatient(ToPatient patient) {
		this.patient = patient;
	}

	public ToDoctor getDoctor() {return doctor;
	}
	public void setDoctor(ToDoctor doctor) {
		this.doctor = doctor;
	}

	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}


}