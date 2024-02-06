package ec.edu.ups.ppw63.Examen63Pardo.business;
import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.dao.RecargaDAO;
import ec.edu.ups.ppw63.Examen63Pardo.model.Recarga;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionRecargas {

	@Inject
	private RecargaDAO daoRecarga;
	
	public void guardarRecarga(Recarga recarga) 
	{
		Recarga rec = daoRecarga.read(recarga.getCodigo());
		if (rec != null) 
		{
			daoRecarga.update(recarga);
		}
		else 
		{
			daoRecarga.insert(recarga);
		}
	}
	
	public void actualizarRecarga(Recarga recarga) throws Exception 
	{
		Recarga rec = daoRecarga.read(recarga.getCodigo());
		if (rec != null) 
		{
			daoRecarga.update(recarga);
		}
		else 
		{
			throw new Exception("Recarga no existe");
		}
	}
	
	public Recarga getRecargaPorCodigo(String codigo) throws Exception 
	{
		return daoRecarga.getRecargaPorCodigo(codigo);
	}
	
	public void borrarRecarga(int codigo) 
	{
		daoRecarga.remove(codigo);
	}
	
	public List<Recarga> getRecargas()
	{
		return daoRecarga.getAll();
	}
	
}
