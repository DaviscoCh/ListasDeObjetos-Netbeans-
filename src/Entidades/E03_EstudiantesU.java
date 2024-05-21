/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 24-ene.-2024 15:29:16
 */
public class E03_EstudiantesU {

    private int Codigo;
    private int Legajo;
    private double PO;

    public E03_EstudiantesU() {
    }

    public E03_EstudiantesU(int Codigo, int Legajo, double PO) {
        this.Codigo = Codigo;
        this.Legajo = Legajo;
        this.PO = PO;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getLegajo() {
        return Legajo;
    }

    public void setLegajo(int Legajo) {
        this.Legajo = Legajo;
    }

    public double getPO() {
        return PO;
    }

    public void setPO(double PO) {
        this.PO = PO;
    }
}
