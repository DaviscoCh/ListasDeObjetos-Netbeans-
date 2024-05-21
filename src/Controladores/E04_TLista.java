/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.E04_CompañiaE;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Charlie Cordova
 */
public class E04_TLista {

    public static List<E04_CompañiaE> ListaCompañia = new ArrayList<E04_CompañiaE>();

    public static void Insertar(E04_CompañiaE co) {
        ListaCompañia.add(co);
    }

    public static void Editar(E04_CompañiaE co, int pos) {
        ListaCompañia.set(pos, co);
    }

    public static void Eliminar(int pos) {
        ListaCompañia.remove(pos);
    }

    public static int Buscar(String Zona) {
        int pos = -1;
        for (int i = 0; i < ListaCompañia.size(); i++) {
            if (ListaCompañia.get(i).getZona().equals(Zona)) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static E04_CompañiaE getCompañia(int pos) {
        return ListaCompañia.get(pos);
    }

    public static DefaultTableModel Visualizar() {
        String[] Columnas = {"Zona", "Numero.Cli", "Lectura.M.Anterior", "Lectura.M.Actual", "Pago Total"};
        String[] Datos = new String[5];
        DefaultTableModel dt = new DefaultTableModel(null, Columnas);
        for (int i = 0; i < ListaCompañia.size(); i++) {
            Datos[0] = ListaCompañia.get(i).getZona();
            Datos[1] = ListaCompañia.get(i).getNumero_cliente();
            Datos[2] = String.valueOf(ListaCompañia.get(i).getLMMAnterior());
            Datos[3] = String.valueOf(ListaCompañia.get(i).getLMMActual());
            Datos[4] = String.valueOf(ListaCompañia.get(i).funcion_TotalFacturadoZona());
            dt.addRow(Datos);
        }
        return dt;
    }

    public static void Funcion_RequisitosFactura() {
        int CZ1 = 0, CZ2 = 0, CZ3 = 0;
        double TPZ1 = 0, TPZ2 = 0, TPZ3 = 0;
        for (int i = 0; i < ListaCompañia.size(); i++) {
            if (ListaCompañia.get(i).getZona().equals("Zona 1")) {
                CZ1++;
                TPZ1 += ListaCompañia.get(i).funcion_TotalFacturadoZona();
            }
            if (ListaCompañia.get(i).getZona().equals("Zona 2")) {
                CZ2++;
                TPZ2 += ListaCompañia.get(i).funcion_TotalFacturadoZona();
            }
            if (ListaCompañia.get(i).getZona().equals("Zona 3")) {
                CZ3++;
                TPZ3 += ListaCompañia.get(i).funcion_TotalFacturadoZona();
            }
        }
        JOptionPane.showMessageDialog(null, "Datos de la Zona 1" + "\n"
                + "Cantidad de Usuarios en la Zona 1: " + CZ1 + "\n"
                + "Total Facturado en la zona: " + TPZ1);
        JOptionPane.showMessageDialog(null, "Datos de la Zona 2" + "\n"
                + "Cantidad de Usuarios en la Zona 2: " + CZ2 + "\n"
                + "Total Facturado en la zona: " + TPZ2);
        JOptionPane.showMessageDialog(null, "Datos de la Zona 3" + "\n"
                + "Cantidad de Usuarios en la Zona 3: " + CZ3 + "\n"
                + "Total Facturado en la zona: " + TPZ3);
    }

}
