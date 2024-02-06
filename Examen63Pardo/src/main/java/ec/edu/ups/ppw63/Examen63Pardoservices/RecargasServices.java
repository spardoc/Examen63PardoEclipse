package ec.edu.ups.ppw63.Examen63Pardoservices;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.business.GestionRecargas;
import ec.edu.ups.ppw63.Examen63Pardo.dao.RecargaService;
import ec.edu.ups.ppw63.Examen63Pardo.model.Recarga;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("recargas")
public class RecargasServices {
	
	@Inject
	private GestionRecargas gRecargas;
	
	@Inject 
	private RecargaService recargaService;
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Recarga recarga) 
	{
		try 
		{
			gRecargas.actualizarRecarga(recarga);
			return Response.ok(recarga).build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getRecargas(){
		List<Recarga> recargas = gRecargas.getRecargas();
		if(recargas.size()>0)
			return Response.ok(recargas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se han realizado recargas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearRecarga(Recarga recarga) {
        try {
        	System.out.println(recarga.getCliente());
        	System.out.println(recarga.getMonto());
            boolean exito = recargaService.realizarRecarga(recarga.getCliente(), recarga.getMonto());

            if (exito) {
                ErrorMessage successMessage = new ErrorMessage(1, "Recarga exitosa");
                return Response.status(Response.Status.CREATED)
                        .entity(successMessage)
                        .build();
            } else {
                ErrorMessage errorMessage = new ErrorMessage(99, "Recarga fallida");
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(errorMessage)
                        .build();
            }
        } catch (Exception e) {
            ErrorMessage errorMessage = new ErrorMessage(99, e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(errorMessage)
                    .build();
        }
    }
}
