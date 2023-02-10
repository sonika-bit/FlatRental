package com.OnlineFlatRental.FlatRental.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
	public class Admin {
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		int adminId;
		String adminPassword;
		
		public Admin(int adminId, String adminPassword) {
			super();
			this.adminId = adminId;
			this.adminPassword = adminPassword;
		}
		
		public Admin() {
			super();
			// TODO Auto-generated constructor stub
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
			return "Admin [adminId=" + adminId + ", adminPassword=" + adminPassword + "]";
		}
		

	}


