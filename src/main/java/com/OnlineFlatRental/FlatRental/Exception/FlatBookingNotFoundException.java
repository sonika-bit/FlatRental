package com.OnlineFlatRental.FlatRental.Exception;

	public class FlatBookingNotFoundException extends Exception {
		private static final long serialVersionUID = 1L;
		public FlatBookingNotFoundException() {
			super();
		}
		public FlatBookingNotFoundException(String msg) {
			super(msg);
		}

}
