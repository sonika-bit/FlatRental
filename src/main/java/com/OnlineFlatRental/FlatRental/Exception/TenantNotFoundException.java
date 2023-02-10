package com.OnlineFlatRental.FlatRental.Exception;

public class TenantNotFoundException extends Exception{
	private static final long serialVersionUID = 1L;
	public TenantNotFoundException() {
		super();
	}
	public TenantNotFoundException(String msg) {
		super(msg);
	}

}
