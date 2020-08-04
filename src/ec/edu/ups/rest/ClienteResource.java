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
	private CuentaBancariaFacade ejbCuentaFacade;

	@EJB 
	private TransaccionFacade ejbTransaccionFacade;

	@GET
	@Path("/list/{cuenta}/{monto}/{fecha}/{hora}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listPersons(@PathParam("cuenta") int cuenta, @PathParam("monto") double monto, @PathParam("fecha") String fecha, @PathParam("hora") String hora) {
		Jsonb jsonb = JsonbBuilder.create();
		

		CuentaBancaria cuentaF = null;
		cuentaF = ejbCuentaFacade.find(cuenta);
		Transaccion t = new Transaccion();
		t.setCuenta(cuentaF);
		t.setMonto(monto);
		t.setFecha(fecha);
		t.setHora(hora);
		cuentaF.setMonto(cuentaF.getMonto() - monto);
		ejbCuentaFacade.edit(cuentaF);
		ejbTransaccionFacade.create(t);
		// para evitar el error del CORS se agregan los headers
		return Response.ok(jsonb.toJson(t)).build();
	}	
//	@POST
//	@Path("/post")
//	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response post(@FormParam("cedula") String cedula, @FormParam("nombre") String nombre, @FormParam("apellido") String apellido) throws Exception{
//		Cliente p =new Cliente();
//		p.setCedula(cedula);
//		p.setNombre(nombre);
//		p.setApellido(apellido);
//		ejbClienteFacade.create(p);
//		return Response.ok("Parece q si mijito")
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
//				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
//	}	 
	
	@POST
	@Path("/post")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(@FormParam("monto") double monto, @FormParam("fecha") String fecha, @FormParam("hora") String hora,@FormParam("cuenta") int cuenta) throws Exception{
		
		CuentaBancaria cuentaF = null;
		cuentaF = ejbCuentaFacade.find(cuenta);
		Transaccion t = new Transaccion();
		t.setCuenta(cuentaF);
		t.setMonto(monto);
		t.setFecha(fecha);
		t.setHora(hora);
		cuentaF.setMonto(cuentaF.getMonto() + monto);
		ejbCuentaFacade.edit(cuentaF);
		ejbTransaccionFacade.create(t);
		
		

		return Response.ok("Parece q si mijito")
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE").build();
	}	
	
}