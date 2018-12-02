package com.model;

import java.text.SimpleDateFormat;
import java.util.*;
public class Customer {
private String cName;
private Integer cId;
private Date dob;
private String gender;
private String address;
private String phno;
private String email;
private String password;
private SSN ssn;





public Customer(String cName, Integer cId, Date dob, String gender,
		String address, String phno, String email, String password, SSN ssn) {
	super();
	this.cName = cName;
	this.cId = cId;
	this.dob = dob;
	this.gender = gender;
	this.address = address;
	this.phno = phno;
	this.email = email;
	this.password = password;
	this.ssn = ssn;
}



public SSN getSsn() {
	return ssn;
}



public void setSsn(SSN ssn) {
	this.ssn = ssn;
}



public String getcName() {
return cName;
}

public void setcName(String cName) {
this.cName = cName;
}

public Integer getcId() {
return cId;
}

public void setcId(Integer cId) {
this.cId = cId;
}

public Date getDob() {
return dob;
}

public void setDob(Date dob) {
this.dob = dob;
}

public String getGender() {
return gender;
}

public void setGender(String gender) {
this.gender = gender;
}

public String getAddress() {
return address;
}

public void setAddress(String address) {
this.address = address;
}

public String getPhno() {
return phno;
}

public void setPhno(String phno) {
this.phno = phno;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}




}


