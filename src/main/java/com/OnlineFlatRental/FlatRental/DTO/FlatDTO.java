package com.OnlineFlatRental.FlatRental.DTO;

public class FlatDTO {
	private int flatId;
	private float cost;
	
    private AddressDTO flatAddress;
	private String availability;

    private LandlordDTO landlordId;

    public FlatDTO() {
    	super();
    }

    public FlatDTO(int flatId, float cost, AddressDTO flatAddress, String availability) {
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

    public void setCost(float cost) {
        this.cost = cost;
    }

    public AddressDTO getFlatAddress() {
        return flatAddress;
    }
    
    public void setFlatAddress(AddressDTO flatAddress) {
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
        return "FlatDTO{" +
                "flatId=" + flatId +
                ", cost=" + cost +
                ", flatAddress=" + flatAddress +
                ", availability='" + availability + '\'' +
                '}';
    }
}


