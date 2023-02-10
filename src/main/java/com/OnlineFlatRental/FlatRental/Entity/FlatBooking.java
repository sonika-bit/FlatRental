package com.OnlineFlatRental.FlatRental.Entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
@Entity
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer bookingNo;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "flatId", unique = true)
	private Flat flat;
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "tenantId", unique = true)
	private Tenant tenantId;
	private LocalDate bookingFromDate;
	private LocalDate bookingToDate;
	
	public FlatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FlatBooking(Integer bookingNo, Flat flatId, Tenant tenantId, LocalDate bookingFromDate, LocalDate bookingToDate) {
		super();
		this.bookingNo = bookingNo;
		this.flat = flat;
		this.tenantId = tenantId;
		this.bookingFromDate = bookingFromDate;
		this.bookingToDate = bookingToDate;
	}

	public Integer getBookingNo() {
		return bookingNo;
	}
	
	public void setBookingNo(Integer bookingNo) {
		this.bookingNo = bookingNo;
	}
	
	public Flat getFlat() {
		return flat;
	}
	
	public void setFlat(Flat flat) {
		this.flat = flat;
	}
	
	public Tenant getTenantId() {
		return tenantId;
	}

	public void setTenantId(Tenant tenantId) {
		this.tenantId = tenantId;
	}
	
	public LocalDate getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}
	
	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}
	@Override
	public String toString() {
		return "FlatBooking{" +
				"bookingNo=" + bookingNo +
				", flat=" + flat +
				", tenantId=" + tenantId +
				", bookingFromDate=" + bookingFromDate +
				", bookingToDate=" + bookingToDate +
				'}';
	}
}