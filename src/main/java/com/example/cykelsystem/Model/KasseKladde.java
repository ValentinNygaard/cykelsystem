package com.example.cykelsystem.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KasseKladde {

    @Id
    private int kasse_kladde_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String date;
    private double byttepenge_start;
    private double omsætning;
    private double dankort_salg;
    private double kort_betalinger;
    private double salg_mobile_pay;
    private double udlæg;
    private double antal_mobile_pay_transaktioner;
    private double byttepenge_slut;
    private double kontanter;
    private double omsætning_afstemt;
    private String tekst;
    private double gebyr_mobile_pay;

    public KasseKladde(String date, double byttepenge_start, double omsætning, double dankort_salg, double kort_betalinger, double salg_mobile_pay, double udlæg, double antal_mobile_pay_transaktioner, double byttepenge_slut, double kontanter, double omsætning_afstemt, String tekst, double gebyr_mobile_pay) {
        this.date = date;
        this.byttepenge_start = byttepenge_start;
        this.omsætning = omsætning;
        this.dankort_salg = dankort_salg;
        this.kort_betalinger = kort_betalinger;
        this.salg_mobile_pay = salg_mobile_pay;
        this.udlæg = udlæg;
        this.antal_mobile_pay_transaktioner = antal_mobile_pay_transaktioner;
        this.byttepenge_slut = byttepenge_slut;
        this.kontanter = kontanter;
        this.omsætning_afstemt = omsætning_afstemt;
        this.tekst = tekst;
        this.gebyr_mobile_pay = gebyr_mobile_pay;
    }

    public KasseKladde() {
    }

    public int getKasse_kladde_id() {
        return kasse_kladde_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getByttepenge_start() {
        return byttepenge_start;
    }

    public void setByttepenge_start(double byttepenge_start) {
        this.byttepenge_start = byttepenge_start;
    }

    public double getOmsætning() {
        return omsætning;
    }

    public void setOmsætning(double omsætning) {
        this.omsætning = omsætning;
    }

    public double getDankort_salg() {
        return dankort_salg;
    }

    public void setDankort_salg(double dankort_salg) {
        this.dankort_salg = dankort_salg;
    }

    public double getKort_betalinger() {
        return kort_betalinger;
    }

    public void setKort_betalinger(double kort_betalinger) {
        this.kort_betalinger = kort_betalinger;
    }

    public double getSalg_mobile_pay() {
        return salg_mobile_pay;
    }

    public void setSalg_mobile_pay(double salg_mobile_pay) {
        this.salg_mobile_pay = salg_mobile_pay;
    }

    public double getUdlæg() {
        return udlæg;
    }

    public void setUdlæg(double udlæg) {
        this.udlæg = udlæg;
    }

    public double getAntal_mobile_pay_transaktioner() {
        return antal_mobile_pay_transaktioner;
    }

    public void setAntal_mobile_pay_transaktioner(double antal_mobile_pay_transaktioner) {
        this.antal_mobile_pay_transaktioner = antal_mobile_pay_transaktioner;
    }

    public double getByttepenge_slut() {
        return byttepenge_slut;
    }

    public void setByttepenge_slut(double byttepenge_slut) {
        this.byttepenge_slut = byttepenge_slut;
    }

    public double getKontanter() {
        return kontanter;
    }

    public void setKontanter(double kontanter) {
        this.kontanter = kontanter;
    }

    public double getOmsætning_afstemt() {
        return omsætning_afstemt;
    }

    public void setOmsætning_afstemt(double omsætning_afstemt) {
        this.omsætning_afstemt = omsætning_afstemt;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public double getGebyr_mobile_pay() {
        return gebyr_mobile_pay;
    }

    public void setGebyr_mobile_pay(double gebyr_mobile_pay) {
        this.gebyr_mobile_pay = gebyr_mobile_pay;
    }
}
