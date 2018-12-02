package com.model;

public class Location {

       private int locationId;
       private String locationName;

       
       public Location() {
              super();
       }

       public Location(int locationId, String locationName) {
              super();
              this.locationId = locationId;
              this.locationName = locationName;
       }

       public int getLocationId() {
              return locationId;
       }

       public void setLocationId(int locationId) {
              this.locationId = locationId;
       }

       public String getLocationName() {
              return locationName;
       }

       public void setLocationName(String locationName) {
              this.locationName = locationName;
       }

   
       
}
