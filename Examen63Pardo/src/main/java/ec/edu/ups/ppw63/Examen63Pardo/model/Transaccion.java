package ec.edu.ups.ppw63.Examen63Pardo.model;

import jakarta.persistence.ManyToOne;

public class Transaccion {
	
    private double monto;

    @ManyToOne
    private Cuenta cuentaOrigen;

    @ManyToOne
    private Cuenta cuentaDestino;

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Cuenta getCuentaOrigen() {
        return cuentaOrigen;
    }

    public void setCuentaOrigen(Cuenta cuentaOrigen) {
        this.cuentaOrigen = cuentaOrigen;
    }

    public Cuenta getCuentaDestino() {
        return cuentaDestino;
    }

    public void setCuentaDestino(Cuenta cuentaDestino) {
        this.cuentaDestino = cuentaDestino;
    }

    // Método para realizar una transferencia
    public boolean realizarTransferencia() {
        if (cuentaOrigen.retirar(monto)) {
            cuentaDestino.depositar(monto);
            return true;
        }
        return false;
    }
}