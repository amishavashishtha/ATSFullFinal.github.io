package com.model;


import java.text.SimpleDateFormat;
import java.util.*;

public class Airline {
                
        private String aId;
        private String aName;
        private Date DOP;

        public Airline() {
                        super();
        }

        public Airline(String aId, String aName, Date dOP) {
                        super();
                        this.aId = aId;
                        this.aName = aName;
                        DOP = dOP;
        }

        public String getaId() {
                        return aId;
        }

        public void setaId(String aId) {
                        this.aId = aId;
        }

        public String getaName() {
                        return aName;
        }

        public void setaName(String aName) {
                        this.aName = aName;
        }

        public Date getDOP() {
                        return DOP;
        }

        public void setDOP(Date dOP) {
                        DOP = dOP;
        }

}
