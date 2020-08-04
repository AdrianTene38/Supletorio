package ec.edu.ups.controlador;

import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import java.io.Serializable;
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ClienteBean implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public ClienteBean() {
		// TODO Auto-generated constructor stub
	}

}
