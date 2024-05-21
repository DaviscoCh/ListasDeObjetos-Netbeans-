/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.E02_Bebidas;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 24-ene.-2024 11:16:26
 */
public class E02_TLista {

    public static List<E02_Bebidas> ListaBebidas = new ArrayList<E02_Bebidas>();

    public static void Insertar(E02_Bebidas be) {
        ListaBebidas.add(be);
    }

    public static void Editar(E02_Bebidas be, int pos) {
        ListaBebidas.set(pos, be);
    }

    public static void Eliminar(int pos) {
        ListaBebidas.remove(pos);
    }

    public static int Buscar(String NumeroF) {
        int pos = -1;
        for (int i = 0; i < ListaBebidas.size(); i++) {
            if (ListaBebidas.get(i).getNumeroF().equals(NumeroF)) {
                pos = i;
                break;
            }

        }
        return pos;
    }

    public static E02_Bebidas getBebidas(int pos) {
        return ListaBebidas.get(pos);
    }

    public static DefaultTableModel Visualizar() {
        String[] Columna = {"Numero.F", "Numero.A", "Cantidad", "Precio.U", "Total"};
        String[] Datos = new String[5];
        DefaultTableModel dt = new DefaultTableModel(null, Columna);
        for (int i = 0; i < ListaBebidas.size(); i++) {
            Datos[0] = ListaBebidas.get(i).getNumeroF();
            Datos[1] = ListaBebidas.get(i).getNumeroA();
            Datos[2] = String.valueOf(ListaBebidas.get(i).getCantidad());
            Datos[3] = String.valueOf(ListaBebidas.get(i).getPrecio_Unitario());
            Datos[4] = String.valueOf(ListaBebidas.get(i).Funcion_TotalFacturado());
            dt.addRow(Datos);
        }
        return dt;
    }

    public static double TotalFacturado() {
        double RecaudacionTotal = 0;
        for (int i = 0; i < ListaBebidas.size(); i++) {
            RecaudacionTotal += ListaBebidas.get(i).Funcion_TotalFacturado();
        }
        return RecaudacionTotal;
    }

    public static void CantidadLitrosArticulo() {
        int CA1 = 0, CA2 = 0, CA3 = 0;
        for (int i = 0; i < ListaBebidas.size(); i++) {
            if (ListaBebidas.get(i).getNumeroA().equals("1")) {
                CA1 += ListaBebidas.get(i).getCantidad();
            }
            if (ListaBebidas.get(i).getNumeroA().equals("2")) {
                CA2 += ListaBebidas.get(i).getCantidad();
            }
            if (ListaBebidas.get(i).getNumeroA().equals("3")) {
                CA3 += ListaBebidas.get(i).getCantidad();
            }
        }
        JOptionPane.showMessageDialog(null, "Cantidad de Listros vendidos por el Articulo 1: " + CA1 + "\n"
                + "Cantidad de Listros vendidos por el Articulo 2: " + CA2 + "\n"
                + "Cantidad de Listros vendidos por el Articulo 3: " + CA3);
    }

    public static int CantidadFacturasM300() {
        int CF = 0;
        for (int i = 0; i < ListaBebidas.size(); i++) {
            if (ListaBebidas.get(i).Funcion_TotalFacturado() > 300) {
                CF++;
            }
        }
        return CF;
    }

}
