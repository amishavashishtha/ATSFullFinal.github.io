package com.model;

import java.util.Date;


public class SeatsAvailable {
	private Flight fNo;
	private Integer avaSeats;
	private Date deptDate;
	public SeatsAvailable(Flight fNo, Integer avaSeats, Date deptDate) {
		super();
		this.fNo = fNo;
		this.avaSeats = avaSeats;
		this.deptDate = deptDate;
	}
	public Flight getfNo() {
		return fNo;
	}
	public void setfNo(Flight fNo) {
		this.fNo = fNo;
	}
	public Integer getAvaSeats() {
		return avaSeats;
	}
	public void setAvaSeats(Integer avaSeats) {
		this.avaSeats = avaSeats;
	}
	public Date getDeptDate() {
		return deptDate;
	}
	public void setDeptDate(Date deptDate) {
		this.deptDate = deptDate;
	}
	
		

}