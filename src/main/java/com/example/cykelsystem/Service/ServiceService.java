package com.example.cykelsystem.Service;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class ServiceService {

    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }

    public Date getCurrentDateAddOne(){
        Date date = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, 1);
        date = c.getTime();
        return date;
    }
}
