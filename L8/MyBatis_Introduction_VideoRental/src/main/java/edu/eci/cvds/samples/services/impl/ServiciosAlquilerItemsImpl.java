package edu.eci.cvds.samples.services.impl;

import java.sql.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;

public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler{

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(long idcliente) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias)
            throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        
    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        // TODO Auto-generated method stub
        
    }

}
