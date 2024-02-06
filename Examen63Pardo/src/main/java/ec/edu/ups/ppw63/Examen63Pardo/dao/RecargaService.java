package ec.edu.ups.ppw63.Examen63Pardo.dao;

import java.util.Random;

import ec.edu.ups.ppw63.Examen63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Examen63Pardo.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class RecargaService {

    @Inject
    private ClienteDAO clienteDAO;

    @Inject
    private RecargaDAO recargaDAO;

    public boolean realizarRecarga(Cliente cliente, double monto) {
        System.out.println(validarMonto(monto));
        System.out.println(verificarSaldoCliente(cliente, monto));
        if (validarMonto(monto) && verificarSaldoCliente(cliente, monto)) {
            // Generar un valor aleatorio entre 0 y 1
        	 // Valor aleatorio entre 0 (inclusive) y 1 (exclusivo)
        	Random random = new Random();
        	int valorAleatorio = random.nextInt(2);
            System.out.println("RANDOM>>"+valorAleatorio);

            // Si el valor aleatorio es igual a 1, se realiza la recarga
            if (valorAleatorio == 1) {
                // Crear una nueva Recarga
                Recarga recarga = new Recarga();
                recarga.setCliente(cliente);
                recarga.setMonto(monto);
                System.out.println("Cliente"+cliente);

                // Insertar la recarga en la base de datos
                recargaDAO.insert(recarga);

                // Actualizar el saldo del cliente
                System.out.println("SALDO ANTERIOR: "+cliente.getSaldo());
                double nuevoSaldo = cliente.getSaldo() + monto;
                System.out.println("SALDO FINAL: "+nuevoSaldo);
                cliente.setSaldo(nuevoSaldo);
                clienteDAO.update(cliente);

                return true;
            } else {
                System.out.println("Recarga Fallida");
                return false;
            }
        } else {
            // Transacción fallida debido a datos no válidos
            return false;
        }
    }


    private boolean validarMonto(double monto) {
        // Implementar lógica de validación de monto aquí
        return monto > 0;
    }

    private boolean verificarSaldoCliente(Cliente cliente, double monto) {
        return true;
    }
}
