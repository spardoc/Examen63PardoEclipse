package ec.edu.ups.ppw63.Examen63Pardo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recargas")
public class Recarga {
	
	@Id
	@GeneratedValue
    @Column(name = "codigo")
    private int codigo;
    
	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_codigo")
    private Cliente cliente;

    @Column(name = "monto")
    private Double monto;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	@Override
	public String toString() {
		return "Recarga [codigo=" + codigo + ", cliente=" + cliente + ", monto=" + monto + "]";
	}
    
}
