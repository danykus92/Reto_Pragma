package enums;

public enum Llave {

    LLAVE("Datos del producto"),
    DESDE_DETALLE_PRODUCTO("detalle"),
    DESDE_BUSQUEDA("busqueda");

    String valor;

    private Llave(String key) {
        this.valor = key;
    }

    public String getValor() {
        return valor;
    }
}
