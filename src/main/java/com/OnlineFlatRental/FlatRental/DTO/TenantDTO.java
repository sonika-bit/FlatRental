package com.OnlineFlatRental.FlatRental.DTO;

public class TenantDTO {
	private int tenantId;
	private int age;
	private AddressDTO taddress;

	public TenantDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TenantDTO(int tenantId, int age, AddressDTO taddress) {
		super();
		this.tenantId = tenantId;
		this.age = age;
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

	public AddressDTO getTaddress() {
		return taddress;
	}
	
	public void setTaddress(AddressDTO taddress) {
		this.taddress = taddress;
	}
	
	@Override
	public String toString() {
		return "TenantDTO [tenantId=" + tenantId + ", age=" + age + ", taddress="
				+ taddress + "]";
	}
}


