package com.nilesh;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Emp")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int empId;
	String name;
	int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinTable(name="emp_address", joinColumns={@JoinColumn(name="empId", referencedColumnName="empId")},
	inverseJoinColumns={@JoinColumn(name="addId", referencedColumnName="addId")})
	Address address;
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "User [empId=" + empId + ", name=" + name + ", age=" + age + "]";
	}
	
	
	

}
