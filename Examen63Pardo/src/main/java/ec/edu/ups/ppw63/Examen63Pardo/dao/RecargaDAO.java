package ec.edu.ups.ppw63.Examen63Pardo.dao;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class RecargaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Recarga recarga) 
	{
		em.persist(recarga);
	}
	
	public void update(Recarga recarga) 
	{
		em.merge(recarga);
	}
	
	public void remove(int codigo) 
	{
		Recarga recarga = em.find(Recarga.class, codigo);
		em.remove(recarga);
	}
	
	public Recarga read(int codigo) 
	{
		Recarga recarga = em.find(Recarga.class, codigo);
		return recarga;
	}
	
	public List<Recarga> getAll()
	{
		String jpql = "SELECT r FROM Recarga r"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Recarga.class);
		return q.getResultList();
	}
	
	public Recarga getRecargaPorCodigo(String codigo) 
	{
		String jpql = "SELECT r FROM Recarga r WHERE r.codigo = :codigo"; //Sentencias a las entidades
		Query q = em.createQuery(jpql, Recarga.class);
		q.setParameter("codigo", codigo);
		List<Recarga> recargas = q.getResultList();
		if(recargas.size() > 0) 
		{
			return recargas.get(0);
		}
		return null;
	}
}
