	package ec.edu.ups.ppw63.Examen63Pardo.model;
	
	import jakarta.persistence.*;
	
	
		@Entity
		@Table(name = "clientes")
		public class Cliente {
			
		    @Id
		    @GeneratedValue
		    @Column(name = "codigo")
		    private int codigo;
		    
		    @Column(name = "nombre")
		    private String nombre;
		
		    @Column(name = "numero_Telefono")
		    private String numeroTelefono;
		    
		    @Column(name = "saldo")
		    private double saldo;
		
			public int getCodigo() {
				return codigo;
			}
		
			public void setCodigo(int codigo) {
				this.codigo = codigo;
			}
		
			public String getNombre() {
				return nombre;
			}
		
			public void setNombre(String nombre) {
				this.nombre = nombre;
			}
		
			public String getNumeroTelefono() {
				return numeroTelefono;
			}
		
			public void setNumeroTelefono(String numeroTelefono) {
				this.numeroTelefono = numeroTelefono;
			}
		
			public double getSaldo() {
				return saldo;
			}
		
			public void setSaldo(double saldo) {
				this.saldo = saldo;
			}
		
			@Override
			public String toString() {
				return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", numeroTelefono=" + numeroTelefono + ", saldo="
						+ saldo + "]";
			}
			
		}
