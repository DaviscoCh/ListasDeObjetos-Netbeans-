/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 25-ene.-2024 14:11:16
 */
public class E04_CompañiaE {

    private String Zona;
    private String Numero_cliente;
    private int LMMAnterior;
    private int LMMActual;

    public E04_CompañiaE() {
    }

    public E04_CompañiaE(String Zona, String Numero_cliente, int LMMAnterior, int LMMActual) {
        this.Zona = Zona;
        this.Numero_cliente = Numero_cliente;
        this.LMMAnterior = LMMAnterior;
        this.LMMActual = LMMActual;
    }

    public String getZona() {
        return Zona;
    }

    public void setZona(String Zona) {
        this.Zona = Zona;
    }

    public String getNumero_cliente() {
        return Numero_cliente;
    }

    public void setNumero_cliente(String Numero_cliente) {
        this.Numero_cliente = Numero_cliente;
    }

    public int getLMMAnterior() {
        return LMMAnterior;
    }

    public void setLMMAnterior(int LMMAnterior) {
        this.LMMAnterior = LMMAnterior;
    }

    public int getLMMActual() {
        return LMMActual;
    }

    public void setLMMActual(int LMMActual) {
        this.LMMActual = LMMActual;
    }

    public double funcion_TotalFacturadoZona() {
        double TK = LMMActual + LMMAnterior;
        double CT = 0, CostoT = 0;
        if (TK <= 100) {
            CT = TK * 0.10;
            CostoT += CT;
        } else if (TK > 101 && TK < 200) {
            CT = 100 * 0.10 + (TK - 100) * 0.12;
            CostoT += CT;
        } else if (TK >= 201) {
            CT = 100 * 0.10 + 100 * 0.12 + (TK - 200) * 0.15;
            CostoT += CT;
        }
        return CostoT;
    }
}
