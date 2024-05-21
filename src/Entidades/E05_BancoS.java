/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 28-ene.-2024 18:41:34
 */
public class E05_BancoS {
    private int NumeroC;
    private String NombreC;
    private String CodigoS;
    private char CodigoT;
    private double Monto;

    public E05_BancoS() {
    }

    public E05_BancoS(int NumeroC, String NombreC, String CodigoS, char CodigoT, double Monto) {
        this.NumeroC = NumeroC;
        this.NombreC = NombreC;
        this.CodigoS = CodigoS;
        this.CodigoT = CodigoT;
        this.Monto = Monto;
    }

    public int getNumeroC() {
        return NumeroC;
    }

    public void setNumeroC(int NumeroC) {
        this.NumeroC = NumeroC;
    }

    public String getNombreC() {
        return NombreC;
    }

    public void setNombreC(String NombreC) {
        this.NombreC = NombreC;
    }

    public String getCodigoS() {
        return CodigoS;
    }

    public void setCodigoS(String CodigoS) {
        this.CodigoS = CodigoS;
    }

    public char getCodigoT() {
        return CodigoT;
    }

    public void setCodigoT(char CodigoT) {
        this.CodigoT = CodigoT;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }
    
    public String Imprimir(){
        return "Numero de Cliente: " + NumeroC + "\n" + 
               "Nombre del Cliente: " + NombreC + "\n" + 
               "Codigo de la Sucursal: " + CodigoS + "\n" + 
               "Transaccion a Realizar: " + CodigoT + "\n" + 
               "Monto: " + Monto;
    }
}
