package ec.edu.ups.ppw63.Examen63Pardo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "detalles_factura")
public class DetalleFactura {
	
    @Id
	private int codigo;
	private String producto; 
	private int cantidad;
	private double precio;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getProducto() {
		return producto;
	}
	public void setProducto(String producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "DetalleFactura [codigo=" + codigo + ", producto=" + producto + ", cantidad=" + cantidad + ", precio="
				+ precio + "]";
	}

}
