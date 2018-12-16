package com.example.cykelsystem.Service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceService {

    public String getDateForToday() {
        java.sql.Date sqlToday = getCurrentDate();
        String date = sqlToday.toString();
        return date;
    }

    public String getDateForTomorrow() {
        java.sql.Date sqlTomorrow = getCurrentDateAddOne();
        String date =  sqlTomorrow.toString();
        return date;
    }

    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public java.sql.Date getCurrentDateAddOne(){
        java.util.Date utilDate = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(utilDate);
        c.add(Calendar.DATE, 1);
        utilDate = c.getTime();
        return new java.sql.Date(utilDate.getTime());
    }
}
