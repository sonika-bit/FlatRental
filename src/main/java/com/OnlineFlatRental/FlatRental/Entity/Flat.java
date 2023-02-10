package com.OnlineFlatRental.FlatRental.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class Flat {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int flatId;
	private float cost;
	
	@OneToOne(cascade=CascadeType.MERGE)
	@JoinColumn(name="houseNo")
	private Address flatAddress;
	private String availability;
	
	public Flat() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	public Flat(int flatId, float cost, Address flatAddress, String availability) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availability = availability;
	}

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}
	
	public float getCost() {
		return cost;
	}
	
	public void setCost(float flatCost) {
		this.cost = flatCost;
	}
	
	public Address getFlatAddress() {
		return flatAddress;
	}
	
	public void setFlatAddress(Address flatAddress) {
		this.flatAddress = flatAddress;
	}
	
	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress
				+ ", flatAvailability=" + availability + "]";
	}
}