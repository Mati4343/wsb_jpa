package com.jpacourse.persistence.entity;

import java.time.LocalDate;

import java.util.Collection;
import javax.persistence.*;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	@Column(nullable = false)
	private String telephoneNumber;

	private String email;

	@Column(nullable = false)
	private String patientNumber;

	@OneToMany(mappedBy = "patient", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.LAZY) //relacja dustronna
	private Collection<VisitEntity> visits;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false) //relacja jednostronna od strony rodzica
	@JoinColumn(name = "id_address")
	private AddressEntity address;

	@Column(nullable = false)
	private Boolean diabetes;

	@Column(nullable = false)
	private LocalDate dateOfBirth;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPatientNumber() {
		return patientNumber;
	}

	public void setPatientNumber(String patientNumber) {
		this.patientNumber = patientNumber;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Collection<VisitEntity> getVisits() {
		return visits;
	}

	public void setVisits(Collection<VisitEntity> visits)
	{
		this.visits = visits;
	}

	public void addVisit(VisitEntity visit) {
		visits.add(visit);
		visit.setPatient(this);
	}

	public void removeVisit(VisitEntity visit) {
		visits.remove(visit);
		visit.setPatient(null);
	}

	public Boolean getDiabetes() {
		return diabetes;
	}

	public void setDiabetes(Boolean diabetes)
	{
		this.diabetes = diabetes;
	}

	public AddressEntity getAddress() {
		return address;
	}
	public void setAddress(AddressEntity address) {
		this.address = address;
	}


}
