package Entidades;

/**
 * @author hp
 * @version 1.0
 * @created 23-ene.-2024 11:16:26
 */
public class E01_Boletos {

    private int Codigo;
    private String Destino;
    private String Compania;
    private int Cantidad;
    private String Servicio;

    public E01_Boletos() {

    }

    public E01_Boletos(int Codigo, String Destino, String Compania, int Cantidad, String Servicio) {
        this.Codigo = Codigo;
        this.Destino = Destino;
        this.Compania = Compania;
        this.Cantidad = Cantidad;
        this.Servicio = Servicio;
    }

    public String getServicio() {
        return Servicio;
    }

    public void setServicio(String newVal) {
        Servicio = newVal;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int newVal) {
        Codigo = newVal;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String newVal) {
        Destino = newVal;
    }

    public String getCompania() {
        return Compania;
    }

    public void setCompania(String newVal) {
        Compania = newVal;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int newVal) {
        Cantidad = newVal;
    }

    public double Subtotal() {
        double subtotal = 0, descuento = 0, diferencial = 0;
        if (Compania.equals("Rutas")) {
            if (Destino.equals("Quito")) {
                subtotal = Cantidad * 20;
            }
            if (Destino.equals("Cuenca")) {
                subtotal = Cantidad * 15;
            }
            if (Destino.equals("Guayaquil")) {
                subtotal = Cantidad * 30;
            }
        }
        if (Compania.equals("Cifa")) {
            if (Destino.equals("Quito")) {
                subtotal = Cantidad * 22;
            }
            if (Destino.equals("Cuenca")) {
                subtotal = Cantidad * 16.50;
            }
            if (Destino.equals("Guayaquil")) {
                subtotal = Cantidad * 33;
            }
        }
        if (Compania.equals("Calderon")) {
            if (Destino.equals("Quito")) {
                subtotal = Cantidad * 24;
            }
            if (Destino.equals("Cuenca")) {
                subtotal = Cantidad * 18;
            }
            if (Destino.equals("Guayaquil")) {
                subtotal = Cantidad * 36;
            }
        }

        return subtotal;
    }

    public double Descuento() {
        double des = 0;
        if (Cantidad >= 5) {
            des = Subtotal() * 0.15;

        }
        return des;
    }

    public double Servicio() {
        double diferencial = 0;
        if (Servicio.equals("Diferencial")) {
            diferencial = (Subtotal() - Descuento()) * 0.20;
        }
        return diferencial;
    }

    public double PagoTotal() {
        return Subtotal() - Descuento() + Servicio();
    }

    public String Imprimir() {
        return "Codigo:" + Codigo + "\n"
                + "Destino: " + Destino + "\n"
                + "Compañia: " + Compania + "\n"
                + "Cantidad: " + Cantidad + "\n"
                + "Servicio: " + Servicio + "\n"
                + "Valor a Pagar: " + PagoTotal();
    }

}
