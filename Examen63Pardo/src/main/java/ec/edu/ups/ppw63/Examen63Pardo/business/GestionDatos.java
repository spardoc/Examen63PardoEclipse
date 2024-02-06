package ec.edu.ups.ppw63.Examen63Pardo.business;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.dao.ClienteDAO;
import ec.edu.ups.ppw63.Examen63Pardo.dao.RecargaDAO;
import ec.edu.ups.ppw63.Examen63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Examen63Pardo.model.Recarga;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup //Al momento de levantar la aplicacion se crea
public class GestionDatos 
{

	@Inject
	private ClienteDAO daoCliente;
    
    @Inject
    private RecargaDAO daoRecarga;
	
	@PostConstruct
	public void init() {
		
		System.out.println("Iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setNombre("Samuel Pardo");
		cliente.setNumeroTelefono("0959213776");
		cliente.setSaldo(2.00);
		
		daoCliente.insert(cliente);
		
		cliente = new Cliente();
		cliente.setNombre("Jairo Salazar");
		cliente.setNumeroTelefono("0999213886");
		cliente.setSaldo(5.00);
		
		daoCliente.insert(cliente);
		
		
		System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}
		
		System.out.println("\n------------- Recargas");
		List<Recarga> list2 = daoRecarga.getAll();
		for (Recarga rec: list2) {
			System.out.println(rec.getCodigo());
		}
	}
}