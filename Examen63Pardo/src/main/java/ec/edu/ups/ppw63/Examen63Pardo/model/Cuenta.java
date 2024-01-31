package ec.edu.ups.ppw63.Examen63Pardo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Cuenta {
     @Id
        private int numeroCuenta;
        private double saldo;

        @ManyToOne  // Muchas cuentas pueden pertenecer a un cliente
        private Cliente cliente;

        // Getters y setters
        public int getNumeroCuenta() {
            return numeroCuenta;
        }

        public void setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
        }

        public double getSaldo() {
            return saldo;
        }

        public void setSaldo(double saldo) {
            this.saldo = saldo;
        }

        public Cliente getCliente() {
            return cliente;
        }

        public void setCliente(Cliente cliente) {
            this.cliente = cliente;
        }

        // Método para depositar dinero
        public void depositar(double monto) {
            this.saldo += monto;
        }

        // Método para retirar dinero
        public boolean retirar(double monto) {
            if (monto <= saldo) {
                saldo -= monto;
                return true;
            }
            return false;
        }

}
