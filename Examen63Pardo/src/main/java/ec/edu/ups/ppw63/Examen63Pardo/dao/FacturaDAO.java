package ec.edu.ups.ppw63.Examen63Pardo.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.model.CantidadFacturasCliente;
import ec.edu.ups.ppw63.Examen63Pardo.model.DetalleFactura;
import ec.edu.ups.ppw63.Examen63Pardo.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO 
{
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Factura factura) 
	{
		em.persist(factura);
	}
	
	public void update(Factura factura) 
	{
		em.merge(factura);
	}
	
	public void remove(int codigo) 
	{
		Factura factura = em.find(Factura.class, codigo);
	}
	
	public Factura read(int codigo) 
	{
		Factura factura = em.find(Factura.class, codigo);
		return factura;
	}
	
	public List<Factura> getAll()
	{
		String jpql = "SELECT f FROM Factura f"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Factura.class);
		return q.getResultList();
	}
	
	public Factura getFacturaPorNumero(String numero) 
	{
		String jpql = "SELECT f FROM Factura f WHERE f.numero = :numero"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Factura.class);
		q.setParameter("numero", numero);
		List<Factura> facturas = q.getResultList();
		if(facturas.size() > 0) 
		{
			return facturas.get(0);
		}
		return null;
	}
	
	public List<DetalleFactura> getDetalles()
	{
		String jpql = "SELECT d FROM DetalleFactura d"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, DetalleFactura.class);
		return q.getResultList();

	}
	
	public List<CantidadFacturasCliente> getTotalFacturas() {
		String sql = "SELECT codigo_cliente, nombre, count(f.codigo) "
				+ "FROM factura f , cliente c "
				+ "WHERE f.codigo_cliente = c.codigo GROUP BY codigo_cliente, nombre ";
		
		Query q = em.createNativeQuery(sql);
		
		List<Object[]> list = q.getResultList();
		List<CantidadFacturasCliente> datos = new ArrayList<CantidadFacturasCliente>();
		for(Object[] result: list) {
			datos.add(new CantidadFacturasCliente(((Number) result[0]).intValue(), 
					result[1].toString(), 
					((Number) result[2]).intValue()));
		}
		return datos;
	}
}
