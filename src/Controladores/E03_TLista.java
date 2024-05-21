/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.E03_EstudiantesU;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 24-ene.-2024 15:29:16
 */
public class E03_TLista {

    public static List<E03_EstudiantesU> ListaEstudiantes = new ArrayList<E03_EstudiantesU>();

    public static void Insertar(E03_EstudiantesU es) {
        ListaEstudiantes.add(es);
    }

    public static void Editar(E03_EstudiantesU es, int pos) {
        ListaEstudiantes.set(pos, es);
    }

    public static void Eliminar(int pos) {
        ListaEstudiantes.remove(pos);
    }

    public static int Buscar(int Codigo) {
        int pos = -1;
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            if (ListaEstudiantes.get(i).getCodigo() == Codigo) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static E03_EstudiantesU getEstudiantes(int pos) {
        return ListaEstudiantes.get(pos);
    }

    public static DefaultTableModel Visualizar() {
        String[] Columna = {"Codigo Universitario", "Legajo Estudiantil", "Puntaje Obtenido"};
        String[] Datos = new String[3];
        DefaultTableModel dt = new DefaultTableModel(null, Columna);
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            Datos[0] = String.valueOf(ListaEstudiantes.get(i).getCodigo());
            Datos[1] = String.valueOf(ListaEstudiantes.get(i).getLegajo());
            Datos[2] = String.valueOf(ListaEstudiantes.get(i).getPO());
            dt.addRow(Datos);
        }
        return dt;
    }

    public static void CalcularRequisitos() {
        int C1 = 0, C2 = 0, C3 = 0;
        double P1 = 0, P2 = 0, P3 = 0;
        double PT1 = 0, PT2 = 0, PT3 = 0;
        for (int i = 0; i < ListaEstudiantes.size(); i++) {
            if (ListaEstudiantes.get(i).getCodigo() == 1) {
                C1++;
                P1 += ListaEstudiantes.get(i).getPO();
                PT1 = P1 / C1;

            }
            if (ListaEstudiantes.get(i).getCodigo() == 2) {
                C2++;
                P2 += ListaEstudiantes.get(i).getPO();
                PT2 = P2 / C2;

            }
            if (ListaEstudiantes.get(i).getCodigo() == 3) {
                C3++;
                P3 += ListaEstudiantes.get(i).getPO();
                PT3 = P3 / C3;

            }
        }
        JOptionPane.showMessageDialog(null, "UNIVERSIDAD **CODIGO 1** " + "\n"
                + "Codigo Universitario: " + 1 + "\n"
                + "Cantidad de Estudiantes: " + C1 + "\n"
                + "Promedio de los Estudiantes: " + PT1);
        JOptionPane.showMessageDialog(null, "UNIVERSIDAD **CODIGO 2** " + "\n"
                + "Codigo Universitario: " + 2 + "\n"
                + "Cantidad de Estudiantes: " + C2 + "\n"
                + "Promedio de los Estudiantes: " + PT2);
        JOptionPane.showMessageDialog(null, "UNIVERSIDAD **CODIGO 3** " + "\n"
                + "Codigo Universitario: " + 3 + "\n"
                + "Cantidad de Estudiantes: " + C3 + "\n"
                + "Promedio de los Estudiantes: " + PT3);
    }

}
