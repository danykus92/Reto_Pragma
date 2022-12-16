package models;

public class Producto {

    private String nombreDelProducto;
    private String precio;
    private String precioTotal;
    private String desde;


    public Producto(String nombreDelProducto, String precio,  String precioTotal, String desde) {
        this.nombreDelProducto = nombreDelProducto;
        this.precio = precio;
        this.precioTotal = precioTotal;
        this.desde = desde;
    }

    public String getNombreDelProducto() {
        return nombreDelProducto;
    }

    public String getPrecio() {
        return precio;
    }

    public String getPrecioTotal() {
        return precioTotal;
    }

    public String getDesde(){
        return desde;
    }
}
