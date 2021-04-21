package com.tutorialspoint.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;

import com.tutorialspoint.validator.Phone;
@Entity
@Table(name = "student", schema = "springlogin")
public class StudentEntity {
	@NumberFormat(style = Style.NUMBER)
	@NotNull
	@Id
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@NotEmpty
	@Size(max = 10)
	@Column(name = "name")
	private String name;

	// @Range(min = 1, max = 100) //age need between 1 and 100
	@NotNull
	@Min(value = 1, message = "Age cannot have fewer than 1 year")
	@Max(value = 100, message = "Age cannot have more than 100 years")
	@NumberFormat(style = Style.NUMBER)
	@Column(name = "age", nullable = false, length = 20)
	private Integer age;

	@Size(min = 10)
	// custom validation
	@Phone
	@Transient
	@Column(name = "PHONE")
	private String phone;

	@NotNull
	@Column(name = "GENDER")
	@Enumerated(EnumType.STRING)
	// @Column(name = "GENDER", columnDefinition = "enum('MALE','FEMALE')")
	// @Enumerated is mandatory otherwise it stores integer value
	private Gender gender;
	public enum Gender {
		MALE, FEMALE
	}
	@Column(name = "CITY")
	private String city;

	@Column(name = "birthDate")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date birthDate;

	@Transient
	@Column(name = "HOBBIES")
	private String[] hobbies;

	// -------setter and getter methods--------

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
