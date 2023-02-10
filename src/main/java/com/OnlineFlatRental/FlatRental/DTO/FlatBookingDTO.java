package com.OnlineFlatRental.FlatRental.DTO;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlatBookingDTO {
    private Integer bookingNo;
	private FlatDTO flat;
	private TenantDTO tenantId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingFromDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate bookingToDate;
	
	public FlatBookingDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FlatBookingDTO(Integer bookingNo, FlatDTO flat, TenantDTO tenantId, LocalDate bookingFromDate,
			LocalDate bookingToDate) {
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

	public FlatDTO getFlat() {
		return flat;
	}
	
	public void setFlat(FlatDTO flat) {
		this.flat = flat;
	}

	public TenantDTO getTenantId() {
		return tenantId;
	}

	public void setTenantId(TenantDTO tenantId) {
		this.tenantId = tenantId;
	}

	public LocalDate getBookingFromDate() {
		return bookingFromDate;
	}

	public void setBookingFromDate(LocalDate bookingFromDate) {
		this.bookingFromDate = bookingFromDate;
	}

	public LocalDate getBookingToDate() {
		return bookingToDate;
	}

	public void setBookingToDate(LocalDate bookingToDate) {
		this.bookingToDate = bookingToDate;
	}

	@Override
	public String toString() {
		return "FlatBookingDTO [bookingNo=" + bookingNo + ", flat=" + flat + ", tenantId=" + tenantId
				+ ", bookingFromDate=" + bookingFromDate + ", bookingToDate=" + bookingToDate + "]";
	}
}

