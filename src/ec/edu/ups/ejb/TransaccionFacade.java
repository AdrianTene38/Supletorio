package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Transaccion;
@Stateless
public class TransaccionFacade extends AbstractFacade<Transaccion>{
    
    @PersistenceContext(unitName = "Supletorio")
    private EntityManager em;

 
    public TransaccionFacade() {
        super(Transaccion.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Transaccion> obtenerTransacciones(int codigoCuenta){
    	Query query = em.createNamedQuery("getTransacciones");
    	query.setParameter("codigo", codigoCuenta);
    	List result = query.getResultList();
		if (result.isEmpty()) {
			System.out.println("No hay datos");
		}
		return result;
    }
}