package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
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
public class ServiciosAlquilerItemsImpl implements ServiciosAlquiler {

    private ItemDAO itemDAO;
    private ClienteDAO clienteDAO;
    private ItemRentadoDAO itemRDAO;
    private TipoItemDAO tipoItemDAO;

    @Inject
    public ServiciosAlquilerItemsImpl(ItemDAO itemDAO, ClienteDAO clienteDAO, ItemRentadoDAO itemRDAO,
    TipoItemDAO tipoItemDAO) {
        this.itemDAO = itemDAO;
        this.clienteDAO = clienteDAO;
        this.itemRDAO = itemRDAO;
        this.tipoItemDAO = tipoItemDAO;
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
        } catch (PersistenceException e) {
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
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler("Error al consultar la multa del alquiler.", ex);
        }
    }

    @Override
    public TipoItem consultarTipoItem(int id) throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load(id);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public List<TipoItem> consultarTiposItem() throws ExcepcionServiciosAlquiler {
        try {
            return tipoItemDAO.load();
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }

    }

    @Override
    public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias)
            throws ExcepcionServiciosAlquiler {
        try {
            ItemRentado itemR = new ItemRentado(-1, item, date, Date.valueOf(date.toLocalDate().plusDays(numdias)));
            Cliente client = consultarCliente((int) docu);
            itemRDAO.save(itemR, client);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public void registrarCliente(Cliente p) throws ExcepcionServiciosAlquiler {
        try {
            clienteDAO.save(p);
        }catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }

    }

    @Override
    public long consultarCostoAlquiler(int iditem, int numdias) throws ExcepcionServiciosAlquiler {
        try {
            return consultarItem(iditem).getTarifaxDia()*numdias;
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public void actualizarTarifaItem(int id, long tarifa) throws ExcepcionServiciosAlquiler {
        try {
            Item item = consultarItem(id);
            item.setTarifaxDia(tarifa);
            itemDAO.save(item);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }

    }

    @Override
    public void registrarItem(Item i) throws ExcepcionServiciosAlquiler {
        try {
            itemDAO.save(i);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }
    }

    @Override
    public void vetarCliente(long docu, boolean estado) throws ExcepcionServiciosAlquiler {
        try {
            Cliente client = consultarCliente((int) docu);
            client.setVetado(estado);
            clienteDAO.save(client);
        } catch (PersistenceException ex) {
            throw new ExcepcionServiciosAlquiler(ex.getMessage(), ex);
        }

    }

}