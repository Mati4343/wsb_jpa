package com.jpacourse.dto;
import java.time.LocalDate;
import java.util.Collection;

public class ToPatient {
	private Long id;
	private String firstName;
	private String lastName;
	private String telephoneNumber;
	private String email;
	private String patientNumber;
	private Collection<ToVisit> visits;
	private AddressTO address;
	private LocalDate dateOfBirth;
	private Boolean diabetes;


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

	public Collection<ToVisit> getVisits() {
		return visits;
	}
	public void setVisits(Collection<ToVisit> visits) {this.visits = visits; }

	public AddressTO getAddress() {
		return address;
	}
	public void setAddress(AddressTO address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Boolean getDiabetes() {return diabetes; }
	public void setDiabetes(Boolean diabetes) {this.diabetes = diabetes; }


}
