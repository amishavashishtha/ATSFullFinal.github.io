package com.model;

import java.util.Date;

public class Flight {

       private String fNo;
       private Airline aId;
    private int totSeats;
    private Location src;
    private Location dest;
    private Date arrivalTime;
    private Date departTime;            
    private int fare;

   

       public Flight() {
              super();
       }



       public Flight(String fNo, Airline aId, int totSeats, Location src,
                     Location dest, Date arrivalTime, Date departTime, int fare) {
              super();
              this.fNo = fNo;
              this.aId = aId;
              this.totSeats = totSeats;
              this.src = src;
              this.dest = dest;
              this.arrivalTime = arrivalTime;
              this.departTime = departTime;
              this.fare = fare;
       }



       public String getfNo() {
              return fNo;
       }



       public void setfNo(String fNo) {
              this.fNo = fNo;
       }



       public Airline getaId() {
              return aId;
       }



       public void setaId(Airline aId) {
              this.aId = aId;
       }



       public int getTotSeats() {
              return totSeats;
       }



       public void setTotSeats(int totSeats) {
              this.totSeats = totSeats;
       }



       public Location getSrc() {
              return src;
       }



       public void setSrc(Location src) {
              this.src = src;
       }



       public Location getDest() {
              return dest;
       }



       public void setDest(Location dest) {
              this.dest = dest;
       }



       public Date getArrivalTime() {
              return arrivalTime;
       }



       public void setArrivalTime(Date arrivalTime) {
              this.arrivalTime = arrivalTime;
       }



       public Date getDepartTime() {
              return departTime;
       }



       public void setDepartTime(Date departTime) {
              this.departTime = departTime;
       }



       public int getFare() {
              return fare;
       }



       public void setFare(int fare) {
              this.fare = fare;
       }
    
       
}
