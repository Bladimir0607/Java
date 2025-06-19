public class Compra implements Comparable <Compra> {
    private double precio;
    private String descripcion;

    public Compra(double precio, String descripcion) {
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return "Compra: precio=" + precio +
                ", descripcion='" + descripcion;
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return Double.valueOf(this.precio).compareTo(Double.valueOf(otraCompra.getPrecio()));
    }
}
