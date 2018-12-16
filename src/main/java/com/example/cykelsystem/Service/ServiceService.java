package com.example.cykelsystem.Service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceService {

    // This method get the current date
    public String getDateForToday() {
        java.util.Date utilToday = new java.util.Date();
        java.sql.Date sqlToday = new java.sql.Date(utilToday.getTime());
        String date = sqlToday.toString();
        return date;
    }

    // This methods gets the date for the comming days
    public String getDateForLaterThanToday(int days) {
        java.util.Date utilDate = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(utilDate);
        c.add(Calendar.DATE, days);
        utilDate = c.getTime();
        java.sql.Date sqlTomorrow = new java.sql.Date(utilDate.getTime());
        String date =  sqlTomorrow.toString();
        return date;
    }

    // This method gets the date for tomorrow
    public String getDateForTomorrow() {
        return getDateForLaterThanToday(1);
    }

    // This method gets the date for today
    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    // This method gets the date for tomorrow
    public java.sql.Date getCurrentDateAddOneDay(){
        java.util.Date date = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return new java.sql.Date(date.getTime());
    }
}
