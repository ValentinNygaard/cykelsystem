//Made by EPS, VN

package com.example.cykelsystem.Service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceService {

    // This method gets the date for today
    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    // This method get the current date
    public String getDateForToday() {
        java.sql.Date sqlToday = getCurrentDate();
        String date = sqlToday.toString();
        return date;
    }

    // This method gets the date for comming days
    public java.sql.Date getCurrentDateAddDays(int days){
        java.util.Date date = new java.util.Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        date = c.getTime();
        return new java.sql.Date(date.getTime());
    }

    // This methods gets the date for the comming days
    public String getDateForLaterThanToday(int days) {
        java.sql.Date sqlTomorrow = getCurrentDateAddDays(days);
        String date =  sqlTomorrow.toString();
        return date;
    }

    // This method gets the date for tomorrow
    public String getDateForTomorrow() {
        return getDateForLaterThanToday(1);
    }
}
