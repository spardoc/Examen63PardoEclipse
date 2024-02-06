package ec.edu.ups.ppw63.Examen63Pardo.dao;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class ClienteDAO 
{
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Cliente cliente) 
	{
		em.persist(cliente);
	}
	
	public void update(Cliente cliente) 
	{
		em.merge(cliente);
	}
	
	public void remove(int codigo) 
	{
		Cliente cliente = em.find(Cliente.class, codigo);
		em.remove(cliente);
	}
	
	public Cliente read(int codigo) 
	{
		Cliente cliente = em.find(Cliente.class, codigo);
		return cliente;
	}
	
	public List<Cliente> getAll()
	{
		String jpql = "SELECT c FROM Cliente c"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Cliente.class);
		return q.getResultList();
	}
	
	public Cliente getClientePorNumeroTelefono(String numero) 
	{
		String jpql = "SELECT c FROM Cliente c WHERE c.numeroTelefono = :numero"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Cliente.class);
		q.setParameter("numero", numero);
		List<Cliente> clientes = q.getResultList();
		if(clientes.size() > 0) 
		{
			return clientes.get(0);
		}
		return null;
	}
}
