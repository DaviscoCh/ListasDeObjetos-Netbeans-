/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 24-ene.-2024 10:03:56
 */
public class E02_Bebidas {

    private String NumeroF;
    private String NumeroA;
    private int Cantidad;
    private double Precio_Unitario;

    public E02_Bebidas() {
    }

    public E02_Bebidas(String NumeroF, String NumeroA, int Cantidad, double Precio_Unitario) {
        this.NumeroF = NumeroF;
        this.NumeroA = NumeroA;
        this.Cantidad = Cantidad;
        this.Precio_Unitario = Precio_Unitario;
    }

    public String getNumeroF() {
        return NumeroF;
    }

    public void setNumeroF(String NumeroF) {
        this.NumeroF = NumeroF;
    }

    public String getNumeroA() {
        return NumeroA;
    }

    public void setNumeroA(String NumeroA) {
        this.NumeroA = NumeroA;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio_Unitario() {
        return Precio_Unitario;
    }

    public void setPrecio_Unitario(double Precio_Unitario) {
        this.Precio_Unitario = Precio_Unitario;
    }

    double Total = 0;
    public double Funcion_TotalFacturado() {
        Total = Cantidad * Precio_Unitario;
        return Total;
    }
    
}
