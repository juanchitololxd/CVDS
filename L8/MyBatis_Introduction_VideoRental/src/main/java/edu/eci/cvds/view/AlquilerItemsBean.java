package edu.eci.cvds.view;

import com.google.inject.Inject;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;


@ManagedBean(name = "AlquilerBean")
@SessionScoped
public class AlquilerItemsBean extends BasePageBean {

    @Inject
    private ServiciosAlquiler serviciosAlquiler;
    private List<Cliente> clientesAdded;
    
    public AlquilerItemsBean(){

    }
    /**
     * Retorna una lista con la informacion de los clientes almacenados en la base de datos
     * @return todos los clientes de la base de datos
     */
    public List<Cliente> consultarClientes(){
        List<Cliente> clientes = new ArrayList<Cliente>();
        try {
            clientes.addAll(serviciosAlquiler.consultarClientes());
            return clientes;   
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error ", e.getMessage()));            
        }
        return clientes;
    }

    /**
      * Registra un cliente nuevo en la base de datos
      * @param Nombre nombre del nuevo cliente
      * @param Documeto documento de identidad del nuevo cliente
      * @param Telefono telefono del nuevo cliente
      * @param Direccion direccion del nuevo cliente
      * @param Email email del nuevo cliente
      * 
      */
    public void registrar(String nombre, long documento, String telefono, String direccion, String email){
	try{	
		Cliente nuevo = new Cliente(nombre, documento, telefono, direccion, email);
		serviciosAlquiler.registrarCliente(nuevo);
		clientesAdded.add(nuevo);
	}catch(ExcepcionServiciosAlquiler e){
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error ", e.getMessage()));
	}
    }
}