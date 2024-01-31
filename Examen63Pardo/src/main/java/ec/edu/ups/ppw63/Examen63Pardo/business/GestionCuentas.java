package ec.edu.ups.ppw63.Examen63Pardo.business;

import ec.edu.ups.ppw63.Examen63Pardo.dao.CuentaDAO;
import ec.edu.ups.ppw63.Examen63Pardo.dao.TransaccionDAO;
import ec.edu.ups.ppw63.Examen63Pardo.model.Cuenta;
import ec.edu.ups.ppw63.Examen63Pardo.model.Transaccion;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionCuentas {
	@Inject
    private CuentaDAO cuentaDao;

    @Inject
    private TransaccionDAO transaccionDao;

    public void realizarTransferencia(int cuentaOrigenId, int cuentaDestinoId, double monto) throws Exception {
        Cuenta cuentaOrigen = cuentaDao.read(cuentaOrigenId);
        Cuenta cuentaDestino = cuentaDao.read(cuentaDestinoId);

        if (cuentaOrigen == null || cuentaDestino == null) {
            throw new Exception("Una de las cuentas no existe");
        }

        if (cuentaOrigen.getSaldo() < monto) {
            throw new Exception("Saldo insuficiente");
        }

        cuentaOrigen.retirar(monto);
        cuentaDestino.depositar(monto);

        cuentaDao.update(cuentaOrigen);
        cuentaDao.update(cuentaDestino);

        Transaccion transaccion = new Transaccion();
        transaccion.setCuentaOrigen(cuentaOrigen);
        transaccion.setCuentaDestino(cuentaDestino);
        transaccion.setMonto(monto);
        transaccionDao.insert(transaccion);
    }


}

