package ec.edu.ups.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.CuentaBancariaFacade;
import ec.edu.ups.ejb.TransaccionFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.CuentaBancaria;
import ec.edu.ups.modelo.Transaccion;
@Path("/cliente/")
public class ClienteResource {
	@EJB 
	private ClienteFacade ejbClienteFacade;
	@EJB 
	private TransaccionFacade ejbTransaccionFacade;
	@EJB 
	private CuentaBancariaFacade ejbCuentaBancariaFacade;


	@GET
	@Path("/list/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPersons(@PathParam("id") String cedula) {
		Jsonb jsonb = JsonbBuilder.create();
		Cliente cliente = null;
		cliente = ejbClienteFacade.find(cedula);
		// para evitar el error del CORS se agregan los headers
		return Response.ok(jsonb.toJson(cliente))
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}	

	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@FormParam("cedula") String cedula, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido) throws Exception{
		Cliente p =new Cliente();
		p.setCedula(cedula);
		p.setNombre(nombre);
		p.setApellido(apellido);
		ejbClienteFacade.create(p);
		return Response.ok("Parece q si mijito")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}	 

}