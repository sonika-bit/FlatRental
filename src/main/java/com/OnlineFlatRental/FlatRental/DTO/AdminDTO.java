package com.OnlineFlatRental.FlatRental.DTO;

public class AdminDTO {
	private int adminId;
	private String adminPassword;

    public AdminDTO() {
    	super();
    }

    public AdminDTO(int adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminId=" + adminId +
                ", adminPassword='" + adminPassword + '\'' +
                '}';
    }
}

