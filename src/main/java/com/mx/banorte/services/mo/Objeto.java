package com.mx.banorte.services.mo;

import javax.json.bind.annotation.JsonbProperty;

public class Objeto {

    @JsonbProperty("servicio")
    private String servicio;

    @JsonbProperty("paymentType")
    private int paymentType;

    @JsonbProperty("name")
    private String name;

    @JsonbProperty("acountNumber")
    private int acountNumber;

    @JsonbProperty("date")
    private String date;

    public int getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(int paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAcountNumber() {
        return acountNumber;
    }

    public void setAcountNumber(int acountNumber) {
        this.acountNumber = acountNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    
    
}
