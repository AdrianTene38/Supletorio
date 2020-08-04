package ec.edu.ups.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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

}
