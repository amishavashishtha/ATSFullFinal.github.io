package com.model;

import java.util.*;

public class Booking {

       private String bookingId;
       private Date bookingDt;
       private String fNo;
       private Customer cId;
       private Integer price;
       private Integer seatsBooked;
       private Date DOJ;

       
       public Booking() {
              super();
       }


       public Booking(String bookingId, Date bookingDt, String fNo, Customer cId,
			Integer price, Integer seatsBooked, Date dOJ) {
		super();
		this.bookingId = bookingId;
		this.bookingDt = bookingDt;
		this.fNo = fNo;
		this.cId = cId;
		this.price = price;
		this.seatsBooked = seatsBooked;
		DOJ = dOJ;
	}





	public Integer getSeatsBooked() {
		return seatsBooked;
	}





	public void setSeatsBooked(Integer seatsBooked) {
		this.seatsBooked = seatsBooked;
	}





	public String getBookingId() {
              return bookingId;
       }


       public void setBookingId(String bookingId) {
              this.bookingId = bookingId;
       }


       public Date getBookingDt() {
              return bookingDt;
       }


       public void setBookingDt(Date bookingDt) {
              this.bookingDt = bookingDt;
       }


       public String getfNo() {
              return fNo;
       }


       public void setfNo(String fNo) {
              this.fNo = fNo;
       }


       public Customer getcId() {
              return cId;
       }


       public void setcId(Customer cId) {
              cId = cId;
       }


       public Integer getPrice() {
              return price;
       }


       public void setPrice(Integer price) {
              this.price = price;
       }


       public Date getDOJ() {
              return DOJ;
       }


       public void setDOJ(Date dOJ) {
              DOJ = dOJ;
       }


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDt=" + bookingDt
				+ ", fNo=" + fNo + ", cId=" + cId + ", price=" + price
				+ ", seatsBooked=" + seatsBooked + ", DOJ=" + DOJ + "]";
	}

       
       
}
