package com.example.gaslon.Model;

import java.io.Serializable;

public class OrderData implements Serializable {
    private String QuantityGas;
    private String QuantityGalon;
    private String QuantityIsiUlang;
    private String OrderName;

    public OrderData(){
    }

    public String getQuantityGas() {
        return QuantityGas;
    }

    public void setQuantityGas(String quantityGas) {
        this.QuantityGas = quantityGas;
    }

    public String getQuantityGalon() {
        return QuantityGalon;
    }

    public void setQuantityGalon(String quantityGalon) {
        this.QuantityGalon = quantityGalon;
    }

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public String getQuantityIsiUlang() {
        return QuantityIsiUlang;
    }

    public void setQuantityIsiUlang(String quantityIsiUlang) {
        QuantityIsiUlang = quantityIsiUlang;
    }

    @Override
    public String toString(){
        return " "+QuantityGas+"\n"+
                " "+QuantityGalon+"\n"+
                " "+QuantityIsiUlang+"\n"+
                " "+OrderName;
    }

    public OrderData(String quantityGas, String quantityGalon, String quantityIsiUlang, String orderName) {
        QuantityGas = quantityGas;
        QuantityGalon = quantityGalon;
        QuantityIsiUlang = quantityIsiUlang;
        OrderName = orderName;
    }
}
