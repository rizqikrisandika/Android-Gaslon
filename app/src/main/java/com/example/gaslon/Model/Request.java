package com.example.gaslon.Model;

public class Request {
    private String bnykGas;
    private String bnykGalon;
    private String bnykIsi;

    public Request(String bnykGas, String bnykGalon, String bnykIsi) {
        this.bnykGas = bnykGas;
        this.bnykGalon = bnykGalon;
        this.bnykIsi = bnykIsi;
    }

    public String getBnykGas() {
        return bnykGas;
    }

    public void setBnykGas(String bnykGas) {
        this.bnykGas = bnykGas;
    }

    public String getBnykGalon() {
        return bnykGalon;
    }

    public void setBnykGalon(String bnykGalon) {
        this.bnykGalon = bnykGalon;
    }

    public String getBnykIsi() {
        return bnykIsi;
    }

    public void setBnykIsi(String bnykIsi) {
        this.bnykIsi = bnykIsi;
    }
}
