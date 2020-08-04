package ec.edu.ups.controlador;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.CuentaBancariaFacade;
import ec.edu.ups.ejb.TransaccionFacade;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.CuentaBancaria;
import ec.edu.ups.modelo.Transaccion;

import java.io.Serializable;
import java.util.List;
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	@EJB
	private ClienteFacade ejbCliente;
	private String cedula;
	
	@EJB
	private CuentaBancariaFacade ejbCuenta;
	
	@EJB
	private TransaccionFacade ejbTransaccion;
	
	private List<Transaccion> transacciones;


	public ClienteBean() {
		// TODO Auto-generated constructor stub
	}

	public ClienteFacade getEjbCliente() {
		return ejbCliente;
	}

	public void setEjbCliente(ClienteFacade ejbCliente) {
		this.ejbCliente = ejbCliente;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}

	public void cambiarClienteAjax(AjaxBehaviorEvent event) {
		cedula = (String) ((UIOutput) event.getSource()).getValue();
	}

	public Cliente buscarCliente() {

		Cliente cliente = null;
		if(this.cedula != null) {

			cliente = ejbCliente.find(this.cedula);
		}
		return cliente;
	}
	
	public List<CuentaBancaria> cuentasBancarias(){
		
		List<CuentaBancaria> cuentas = null;
		Cliente cliente = null;
		if(this.cedula != null) {
			cliente = ejbCliente.find(this.cedula);
			
			cuentas = cliente.getCuentabancaria();
			System.out.println(cuentas);
		}
		
		return cuentas;
		
	}
	
	public String seleccionar(CuentaBancaria c) {
		System.out.println("Entraaa");
		System.out.println(c.getCodigo());
		transacciones = ejbTransaccion.obtenerTransacciones(c.getCodigo());
		return null;
	}

}
