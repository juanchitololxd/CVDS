package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject; import
com.google.inject.Singleton;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import
edu.eci.cvds.sampleprj.dao.ItemDAO;
import edu.eci.cvds.samples.entities.Cliente; import
edu.eci.cvds.samples.entities.Item; import
edu.eci.cvds.samples.entities.ItemRentado; import
edu.eci.cvds.samples.entities.TipoItem; import
edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler; import
java.sql.Date; import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
@Singleton
public class ServiciosAlquilerImpl implements ServiciosAlquiler {
 
    
 private ItemDAO itemDAO;
 private ClienteDAO clienteDAO;
    
 @Inject
 public ServiciosAlquilerImpl(ItemDAO itemDAO, ClienteDAO clienteDAO) {
     this.itemDAO = itemDAO;
     this.clienteDAO = clienteDAO;
 }
 
 
 
 
 @Override public int valorMultaRetrasoxDia(int itemId) {
throw new UnsupportedOperationException("Not supported yet.");
 }
 @Override
 public Cliente consultarCliente(long docu) throws ExcepcionServiciosAlquiler {
throw new UnsupportedOperationException("Not supported yet.");
 }
 @Override public List<ItemRentado> consultarItemsCliente(long idcliente) throws
ExcepcionServiciosAlquiler { throw new UnsupportedOperationException("Not supported yet.");
 }
 @Override public List<Cliente> consultarClientes() throws
ExcepcionServiciosAlquiler { throw new
UnsupportedOperationException("Not supported yet.");
 }
 @Override public Item consultarItem(int id) throws ExcepcionServiciosAlquiler
{ try { return itemDAO.load(id); } catch
(PersistenceException ex) { throw new ExcepcionServiciosAlquiler("Error" +
"al consultar el item "+id,ex);
 }
 }
 @Override public List<Item> consultarItemsDisponibles() {
throw new UnsupportedOperationException("Not supported yet.");
 }
 @Override public long consultarMultaAlquiler(int iditem, Date fechaDevolucion) throws
ExcepcionServiciosAlquiler { throw new UnsupportedOperationException("Not supported yet."); }
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
public void registrarAlquilerCliente(Date date, long docu, Item item, int numdias) throws ExcepcionServiciosAlquiler {
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