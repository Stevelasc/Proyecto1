package proyecto.inventario;

public class ProductoConcreto extends Producto {

    public ProductoConcreto(String nombre, double precio) {
        super(nombre, precio);
    }


    public double calcularTotal() {
        return getPrecio();
    }


    public String obtenerDescripcion() {
        return super.obtenerDescripcion() + " (Producto Concreto)";
    }
}
