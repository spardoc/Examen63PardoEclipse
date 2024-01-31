package ec.edu.ups.ppw63.Examen63Pardo.business;

import java.util.Date;
import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.dao.ClienteDAO;
import ec.edu.ups.ppw63.Examen63Pardo.dao.FacturaDAO;
import ec.edu.ups.ppw63.Examen63Pardo.model.CantidadFacturasCliente;
import ec.edu.ups.ppw63.Examen63Pardo.model.Cliente;
import ec.edu.ups.ppw63.Examen63Pardo.model.DetalleFactura;
import ec.edu.ups.ppw63.Examen63Pardo.model.Factura;
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
	private FacturaDAO daoFactura;
	
	@PostConstruct //Posterior a la creacion se llama a este metodo
	public void init() 
	{
		System.out.println("Iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("1105919169");
		cliente.setNombre("Samuel Pardo");
		cliente.setDireccion("Loja");
		
		daoCliente.insert(cliente);
		
		cliente = new Cliente();
		cliente.setCodigo(2);
		cliente.setDni("1105919388");
		cliente.setNombre("Jairo Salazar");
		cliente.setDireccion("Cuenca");
		
		daoCliente.insert(cliente);
		
		Factura factura = new Factura();
		factura.setCodigo(1);
		factura.setCliente(cliente);
		factura.setNumero("11111-111-1111");
		factura.setFechaEmision(new Date());
		factura.setTotal(1000.52);
		
		DetalleFactura det = new DetalleFactura();
		det.setCodigo(1);
		det.setProducto("TV");
		det.setCantidad(2);
		det.setPrecio(100.50);
		
		factura.addDetalle(det);
		
		det = new DetalleFactura();
		det.setCodigo(2);
		det.setProducto("Cocina");
		det.setCantidad(1);
		det.setPrecio(150.50);
		
		factura.addDetalle(det);
		
		
		daoFactura.insert(factura);
		
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Facturas2");
		List<Factura> list2 = daoFactura.getAll();
		for (Factura fac: list2) {
			System.out.println(fac);
		}
	
		System.out.println("\n------------- Cantidad Facturas");
		List<CantidadFacturasCliente> list3 = daoFactura.getTotalFacturas();
		for (CantidadFacturasCliente fac: list3) {
			System.out.println(fac);
		}
	}
}
