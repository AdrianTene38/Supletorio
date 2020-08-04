package ec.edu.ups.modelo;

import java.io.Serializable;
import ec.edu.ups.modelo.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaccion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	private String fecha;
	private String hora;
	private double monto;
	private CuentaBancaria cuenta;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public CuentaBancaria getCuenta() {
		return cuenta;
	}
	public void setCuenta(CuentaBancaria cuenta) {
		this.cuenta = cuenta;
	}
	public Transaccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaccion(int codigo, String fecha, String hora, double monto, CuentaBancaria cuenta) {
		super();
		this.codigo = codigo;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.cuenta = cuenta;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + ((cuenta == null) ? 0 : cuenta.hashCode());
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		long temp;
		temp = Double.doubleToLongBits(monto);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Transaccion other = (Transaccion) obj;
		if (codigo != other.codigo)
			return false;
		if (cuenta == null) {
			if (other.cuenta != null)
				return false;
		} else if (!cuenta.equals(other.cuenta))
			return false;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (Double.doubleToLongBits(monto) != Double.doubleToLongBits(other.monto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Transaccion [codigo=" + codigo + ", fecha=" + fecha + ", hora=" + hora + ", monto=" + monto
				+ ", cuenta=" + cuenta + "]";
	}
}