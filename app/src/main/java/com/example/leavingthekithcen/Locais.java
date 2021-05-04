package com.example.leavingthekithcen;

public class Locais {
    public String nome = null;
    public Double latitude = null;
    public Double longitude = null;
    public String facebook = null;
    public String instagram = null;
    public String whatsaap = null;
    public Boolean desconto = false;
    public String ticket = null;
    public String ticketText = null;

    public Locais(Double latitude, Double longitude, String nome, String facebook, String instagram, String whatsaap, Boolean desconto, String ticket, String ticketText) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nome = nome;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsaap = whatsaap;
        this.desconto = desconto;
        this.ticket = ticket;
        this.ticketText = ticketText;
    }

    public Locais(Double latitude, Double longitude, String nome, String facebook, String instagram, String whatsaap) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.nome = nome;
        this.facebook = facebook;
        this.instagram = instagram;
        this.whatsaap = whatsaap;
    }

    public Locais() {
    }

    public String getCardapio() {
        return facebook;
    }

    public void setCardapio(String cardapio) {
        this.facebook = cardapio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
