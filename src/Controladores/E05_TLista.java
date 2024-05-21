/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.E05_BancoS;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 28-ene.-2024 18:41:34
 */
public class E05_TLista {

    public static List<E05_BancoS> ListaBanco = new ArrayList<E05_BancoS>();

    public static void Insertar(E05_BancoS ba) {
        ListaBanco.add(ba);
    }

    public static void Editar(E05_BancoS ba, int pos) {
        ListaBanco.set(pos, ba);
    }

    public static void Eliminar(int pos) {
        ListaBanco.remove(pos);
    }

    public static int Buscar(int NumeroC) {
        int pos = -1;
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getNumeroC() == NumeroC) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static E05_BancoS getBanco(int pos) {
        return ListaBanco.get(pos);
    }

    public static DefaultTableModel Visualizar() {
        String[] Columnas = {"Numero.Cli", "Nombre.Cli", "Codigo.Suc", "Codigo.Tra", "Monto"};
        String[] Datos = new String[5];
        DefaultTableModel dt = new DefaultTableModel(null, Columnas);
        for (int i = 0; i < ListaBanco.size(); i++) {
            Datos[0] = String.valueOf(ListaBanco.get(i).getNumeroC());
            Datos[1] = ListaBanco.get(i).getNombreC();
            Datos[2] = ListaBanco.get(i).getCodigoS();
            Datos[3] = String.valueOf(ListaBanco.get(i).getCodigoT());
            Datos[4] = String.valueOf(ListaBanco.get(i).getMonto());
            dt.addRow(Datos);
        }
        return dt;
    }

    public static int Funcion_CantDepo1000() {
        int CM = 0;
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoT() == 'D') {
                if (ListaBanco.get(i).getMonto() > 1000) {
                    CM++;
                }
            }
        }
        return CM;
    }

    public static void Proced_MayorCliSuc() {
        double Mayor_Monto = 0;
        String Mayor_Sucursal = "";
        String Mayor_Nombre = "";
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoT() == 'E') {
                if (ListaBanco.get(i).getMonto() > Mayor_Monto) {
                    Mayor_Monto = ListaBanco.get(i).getMonto();
                    Mayor_Sucursal = ListaBanco.get(i).getCodigoS();
                    Mayor_Nombre = ListaBanco.get(i).getNombreC();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "CLIENTE QUE HIZO LA MAYOR EXTRACCION: " + "\n"
                + "Nombre del Cliente: " + Mayor_Nombre + "\n"
                + "Sucursal donde la Realizo: " + Mayor_Sucursal);
    }

    public static void Proced_PorcentajeS() {
        double TotalD1 = 0, TotalE1 = 0, TotalT1 = 0, PV = 0, PS = 0, PT = 0, Total = 0;
        double TotalD2 = 0, TotalE2 = 0, TotalT2 = 0;
        double TotalD3 = 0, TotalE3 = 0, TotalT3 = 0;
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoS().equals("Virreyes")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalD1 += ListaBanco.get(i).getMonto();
                }
                if (ListaBanco.get(i).getCodigoT() == 'E') {
                    TotalE1 += ListaBanco.get(i).getMonto();
                }
                TotalT1 += TotalD1 + TotalE1;

            } else if (ListaBanco.get(i).getCodigoS().equals("San Fernando")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalD2 += ListaBanco.get(i).getMonto();
                }
                if (ListaBanco.get(i).getCodigoT() == 'E') {
                    TotalE2 += ListaBanco.get(i).getMonto();
                }
                TotalT2 += TotalD2 + TotalE2;

            } else if (ListaBanco.get(i).getCodigoS().equals("Tigre")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalD3 += ListaBanco.get(i).getMonto();
                }
                if (ListaBanco.get(i).getCodigoT() == 'E') {
                    TotalE3 += ListaBanco.get(i).getMonto();
                }
                TotalT3 += TotalD3 + TotalE3;
            }
            Total = TotalT1 + TotalT2 + TotalT3;
            PV = (TotalT1 * 100) / Total;
            PS = (TotalT2 * 100) / Total;
            PT = (TotalT3 * 100) / Total;

        }
        JOptionPane.showMessageDialog(null, "PORCENTAJES DE TRANSACCIONES POR CADA SUCURSAL" + "\n"
                + "Porcentaje de Virreyes: " + PV + "%" + "\n"
                + "Porcentaje de San Fernando: " + PS + "%" + "\n"
                + "Porcentaje de Tigre: " + PT + "%");
    }

    public static void proced_TotalPesosD() {
        double TotalV = 0, TotalS = 0, TotalT = 0;
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoS().equals("Virreyes")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalV = ListaBanco.get(i).getMonto();
                }
            }
            if (ListaBanco.get(i).getCodigoS().equals("San Fernando")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalS = ListaBanco.get(i).getMonto();
                }
            }
            if (ListaBanco.get(i).getCodigoS().equals("Tigre")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    TotalT = ListaBanco.get(i).getMonto();
                }
            }
        }
        JOptionPane.showMessageDialog(null, "TOTAL DE PESOS DEPOSITADOS EN CADA UNA DE LA SUCURSALES" + "\n"
                + "Sucursal Virreyes: " + TotalV + "\n"
                + "Sucursal San Fernando: " + TotalS + "\n"
                + "Sucursal Tigre: " + TotalT);
    }

    public static int Funcion_CantDT() {
        int CD = 0;
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoS().equals("Tigre")) {
                if (ListaBanco.get(i).getCodigoT() == 'D') {
                    CD++;
                }
            }
        }
        return CD;
    }

    public static void Proced_NomNumExtra() {
        List<String> Cliente_Extraccion = new ArrayList<>();
        List<String> Numero_Extraccion = new ArrayList<>();
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoT() == 'E' && ListaBanco.get(i).getMonto() > 500) {
                Cliente_Extraccion.add(ListaBanco.get(i).getNombreC());
                Numero_Extraccion.add(String.valueOf(ListaBanco.get(i).getNumeroC()));
            }
        }
        JOptionPane.showMessageDialog(null, "NOMBRE Y NUMERO DE LOS CLIENTES QUE REALIZARON EXTRACCIONES POR MAS DE 500$" + "\n"
                + Cliente_Extraccion + "\n"
                + Numero_Extraccion);
    }

    public static String Funcion_NumSucD() {
        double SmayorCantD = 0;
        int ContV = 0, ContS = 0, ContT = 0;
        String SMayorCantD = "";
        for (int i = 0; i < ListaBanco.size(); i++) {
            if (ListaBanco.get(i).getCodigoS().equals("Virreyes") && ListaBanco.get(i).getCodigoT() == 'D') {
                ContV++;
                if (ContV > SmayorCantD) {
                    SmayorCantD = ContV;
                    SMayorCantD = "Virreyes";
                }
            }
            if (ListaBanco.get(i).getCodigoS().equals("San Fernando") && ListaBanco.get(i).getCodigoT() == 'D') {
                ContS++;
                if (ContS > SmayorCantD) {
                    SmayorCantD = ContS;
                    SMayorCantD = "San Fernando";
                }
            }
            if (ListaBanco.get(i).getCodigoS().equals("Tigre") && ListaBanco.get(i).getCodigoT() == 'D') {
                ContT++;
                if (ContT > SmayorCantD) {
                    SmayorCantD = ContT;
                    SMayorCantD = "Tigre";
                }
            }
        }
        return SMayorCantD;
    }

}
