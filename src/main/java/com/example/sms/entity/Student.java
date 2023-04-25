package com.example.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "etudiant")
public class Student {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cin;
	
	@Column(name = "nom", nullable = false)
	private String firstName;
	
	@Column(name = "prenom")
	private String name;
	
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "Classe")
	private String classe;

	@Column(name = "present")
	private boolean present;

	public Student() {

	}

	public Student(Long cin, String firstName, String name, String email, String classe, boolean present) {
		this.cin = cin;
		this.firstName = firstName;
		this.name = name;
		this.email = email;
		this.classe = classe;
		this.present = present;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPresent() {
		return present;
	}

	public void setPresent(boolean present) {
		this.present = present;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}


	
	public Long getCin() {
		return cin;
	}
	public void setCin(Long cin) {
		this.cin = cin;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return name;
	}
	public void setLastName(String lastName) {
		this.name = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
