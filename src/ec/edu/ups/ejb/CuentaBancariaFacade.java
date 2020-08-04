package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ec.edu.ups.modelo.CuentaBancaria;
@Stateless
public class CuentaBancariaFacade extends AbstractFacade<CuentaBancaria> {



	@PersistenceContext(unitName = "Supletorio")
	private EntityManager em;


	public CuentaBancariaFacade() {
		super(CuentaBancaria.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
}

