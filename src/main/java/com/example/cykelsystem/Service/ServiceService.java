package com.example.cykelsystem.Service;

import org.springframework.stereotype.Service;

@Service
public class ServiceService {

    public java.sql.Date getCurrentDate() {
        java.util.Date today = new java.util.Date();
        return new java.sql.Date(today.getTime());
    }
}
