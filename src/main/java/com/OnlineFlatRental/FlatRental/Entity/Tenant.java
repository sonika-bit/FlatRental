package com.OnlineFlatRental.FlatRental.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Tenant {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tenantId;
	private int age;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "houseNo", unique = true)
	private Address taddress;
	
	public Tenant(int tenantId, int age, Address taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.taddress = taddress;
	}
	
	public Tenant() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Address getTaddress() {
		return taddress;
	}
	
	public void setTaddress(Address taddress) {
		this.taddress = taddress;
	}
	
	public int getTenantId() {
		return tenantId;
	}
	
	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", taddress=" + taddress
				+ "]";
	}
	
}