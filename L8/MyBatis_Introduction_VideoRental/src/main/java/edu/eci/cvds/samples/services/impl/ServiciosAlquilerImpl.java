package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {

    private ItemDAO itemDAO;
    private ClienteDAO clienteDAO;
    private ItemRentadoDAO itemRDAO;

    @Inject
    public ServiciosAlquilerImpl(ItemDAO itemDAO, ClienteDAO clienteDAO, ItemRentadoDAO itemRDAO) {
        this.itemDAO = itemDAO;
        this.clienteDAO = clienteDAO;
        this.itemRDAO = itemRDAO;
    }

    @Override
    public int valorMultaRetrasoxDia(int itemId) {
        // No habia un lugar en BD de donde se pudiese sacar la multa
        return 50000;
    }

    @Override
    public Cliente consultarCliente(int docu) throws ExcepcionServiciosAlquiler {
        Cliente cliente = null;
        try {
            cliente = clienteDAO.load(docu);
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
        return cliente;
    }

    @Override
    public List<ItemRentado> consultarItemsCliente(int idcliente) throws ExcepcionServiciosAlquiler {
        try {
            Cliente cliente = clienteDAO.load(idcliente);
            return cliente.getRentados();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public List<Cliente> consultarClientes() throws ExcepcionServiciosAlquiler {
        try {
            return clienteDAO.load();
        }catch (PersistenceException ex){
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public Item consultarItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return itemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error" +
                    "al consultar el item " + id, ex);
        }
    }

    @Override
    public List<Item> consultarItemsDisponibles() {
        List<Item> items = new ArrayList<Item>();
        try {
            items = itemDAO.load();
        } catch (Exception e) {
        }
        return items;
    }

    @Override
    public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws ExcepcionServiciosAlquiler {
        try {
            ItemRentado item = itemRDAO.load(iditem);
            long dias = ChronoUnit.DAYS.between(item.getFechafinrenta().toLocalDate(), fechaDevolucion.toLocalDate());
            if (dias < 0) dias = 0;
            return  dias * valorMultaRetrasoxDia(iditem);
        } catch (Exception ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar la multa del alquiler.", ex);
        }
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