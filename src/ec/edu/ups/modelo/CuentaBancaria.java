package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.modelo.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CuentaBancaria implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private Cliente cliente;
	private double monto;
	private  List<Transaccion> transacciones;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public List<Transaccion> getTransacciones() {
		return transacciones;
	}
	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	public CuentaBancaria(int codigo, Cliente cliente, double monto, List<Transaccion> transacciones) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.monto = monto;
		this.transacciones = transacciones;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
		result = prime * result + codigo;
		long temp;
		temp = Double.doubleToLongBits(monto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((transacciones == null) ? 0 : transacciones.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CuentaBancaria other = (CuentaBancaria) obj;
		if (cliente == null) {
			if (other.cliente != null)
				return false;
		} else if (!cliente.equals(other.cliente))
			return false;
		if (codigo != other.codigo)
			return false;
		if (Double.doubleToLongBits(monto) != Double.doubleToLongBits(other.monto))
			return false;
		if (transacciones == null) {
			if (other.transacciones != null)
				return false;
		} else if (!transacciones.equals(other.transacciones))
			return false;
		return true;
	}
	public CuentaBancaria() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CuentaBancaria [codigo=" + codigo + ", cliente=" + cliente + ", monto=" + monto + ", transacciones="
				+ transacciones + "]";
	}
}