package Controladores;

import Entidades.E01_Boletos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * @author Charlie Cordova
 * @version 1.0
 * @created 23-ene.-2024 11:33:03
 */
public class E01_TLista {

    public static List<E01_Boletos> Lista = new ArrayList<E01_Boletos>();

    public static void Insert(E01_Boletos ob) {
        Lista.add(ob);
    }

    public static void Update(E01_Boletos ob, int pos) {
        Lista.set(pos, ob);
    }

    public static void Delete(int pos) {
        Lista.remove(pos);
    }

    public static int Buscar(int Codigo) {
        int pos = -1;
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getCodigo() == Codigo) {
                pos = i;
                break;
            }
        }
        return pos;
    }

    public static E01_Boletos getBoletos(int pos) {
        return Lista.get(pos);
    }

    public static DefaultTableModel Visualizar() {
        String[] Columna = {"Codigo", "Destino", "Compañia", "Cantidad", "Servicio", "Descuento","Adicional", "Total"};
        String[] Datos = new String[8];
        DefaultTableModel dt = new DefaultTableModel(null, Columna);
        for (int i = 0; i < Lista.size(); i++) {
            Datos[0] = String.valueOf(Lista.get(i).getCodigo());
            Datos[1] = Lista.get(i).getDestino();
            Datos[2] = Lista.get(i).getCompania();
            Datos[3] = String.valueOf(Lista.get(i).getCantidad());
            Datos[4] = Lista.get(i).getServicio();
            Datos[5] = String.valueOf(Lista.get(i).Descuento());
            Datos[6] = String.valueOf(Lista.get(i).Servicio());
            Datos[7] = String.valueOf(Lista.get(i).PagoTotal());
            dt.addRow(Datos);
        }
        return dt;
    }

    public static void CantidadRecaudadaDestino() {
        double crq = 0, crc = 0, crg = 0;
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getDestino().equals("Quito")) {
                crq = crq + Lista.get(i).PagoTotal();
            }
            if (Lista.get(i).getDestino().equals("Cuenca")) {
                crc = crc + Lista.get(i).PagoTotal();
            }
            if (Lista.get(i).getDestino().equals("Guayaquil")) {
                crg = crg + Lista.get(i).PagoTotal();
            }
        }
        JOptionPane.showMessageDialog(null, "Total Recaudado a Quito: " + crq + "\n"
                + "Total recaudado a Cuenca: " + crc + "\n"
                + "Total recaudado a Guayaquil: " + crg);
    }

    public static void TotalRecaudadoCompania() {
        double crutas = 0, ccifa = 0, ccal = 0;
        for (int i = 0; i < Lista.size(); i++) {
            if (Lista.get(i).getCompania().equals("Rutas")) {
                crutas = crutas + Lista.get(i).PagoTotal();
            }
            if (Lista.get(i).getCompania().equals("Cifa")) {
                ccifa = ccifa + Lista.get(i).PagoTotal();
            }
            if (Lista.get(i).getCompania().equals("Calderon")) {
                ccal = ccal + Lista.get(i).PagoTotal();
            }
        }
        JOptionPane.showMessageDialog(null, "Total Recaudado a Rutas: " + crutas + "\n"
                + "Total recaudado a Cifa: " + ccifa + "\n"
                + "Total recaudado a Calderon: " + ccal);
    }

}
