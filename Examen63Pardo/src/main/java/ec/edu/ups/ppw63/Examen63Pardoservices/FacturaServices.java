package ec.edu.ups.ppw63.Examen63Pardoservices;

import java.util.List;

import ec.edu.ups.ppw63.Examen63Pardo.business.GestionFacturas;
import ec.edu.ups.ppw63.Examen63Pardo.model.DetalleFactura;
import ec.edu.ups.ppw63.Examen63Pardo.model.Factura;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("facturas")
public class FacturaServices 
{
	@Inject
	private GestionFacturas gFacturas;
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Factura factura) 
	{
		try 
		{
			gFacturas.guardarFactura(factura);
			ErrorMessage error = new ErrorMessage(1, "OK");
			return Response.status(Response.Status.CREATED)
					.entity(error)
					.build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(error)
					.build();
		}
		
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Factura factura) 
	{
		try 
		{
			gFacturas.actualizarFactura(factura);
			return Response.ok(factura).build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(99, e.getMessage());
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String borrar(@QueryParam("codigo") int codigo) 
	{
		try 
		{
			gFacturas.borrarFactura(codigo);
			return "OK";
		}
		catch (Exception e) 
		{
			return "ERROR";
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //Devuelve en formato JSON
	//@Produces("application/json")
	public Response leer(@QueryParam("codigo") String codigo, @QueryParam("numero") String numero) 
	{
		try 
		{
			System.out.println("codigo "+codigo+"num "+numero);
			Factura fac = gFacturas.getFacturaPorNumero(numero);
			return Response.ok(fac).build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(4, "Factura no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Path("{codigo}/{numero}")
	@Produces(MediaType.APPLICATION_JSON) //Devuelve en formato JSON
	//@Produces("application/json")
	public Response leer2(@PathParam("codigo") String codigo, @PathParam("numero") String numero) 
	{
		try 
		{
			System.out.println("codigo "+codigo+"num "+numero);
			Factura fac = gFacturas.getFacturaPorNumero(numero);
			return Response.ok(fac).build();
		}
		catch (Exception e) 
		{
			ErrorMessage error = new ErrorMessage(4, "Factura no existe");
			return Response.status(Response.Status.NOT_FOUND)
					.entity(error)
					.build();
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("list")
	public Response getFacturas(){
		List<Factura> facturas = gFacturas.getFacturas();
		if(facturas.size()>0)
			return Response.ok(facturas).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran facturas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("detalles/list")
	public Response getDetalles(){
		List<DetalleFactura> detalles = gFacturas.getDetalles();
		if(detalles.size()>0)
			return Response.ok(detalles).build();
		
		ErrorMessage error = new ErrorMessage(6, "No se registran facturas");
		return Response.status(Response.Status.NOT_FOUND)
				.entity(error)
				.build();
		
	}
}
