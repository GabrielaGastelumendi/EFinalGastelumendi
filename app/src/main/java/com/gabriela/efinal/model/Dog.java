package com.gabriela.efinal.model;

import android.content.Intent;


public class Dog extends Shows{

    public String edad ;
    public String tamano;
    public int peso;
    public boolean adoptado;
    public String raza;


    public Dog (String name, String imgUrl, String tamano, int peso, boolean adoptado, String raza) {
        super(name, imgUrl);
        this.tamano = tamano;
        this.peso = peso;
        this.adoptado = adoptado;
        this.raza = raza;
    }

    public Dog(String name, String imgUrl, String edad) {
        super(name, imgUrl);
        this.edad = edad;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public boolean isAdoptado() {
        return adoptado;
    }

    public void setAdoptado(boolean adoptado) {
        this.adoptado = adoptado;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }
}
