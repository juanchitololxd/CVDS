package edu.eci.cvds.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.sampleprj.dao.ClienteDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.samples.entities.Cliente;
import com.google.inject.Inject;

public class MyBATISClienteDAO implements ClienteDAO{

    @Inject
    private ClienteMapper clienteMapper;

    @Override
    public void save(Cliente cliente) throws PersistenceException {
        try {
            clienteMapper.insertarCliente(cliente);
        } catch (PersistenceException e) {
            throw new PersistenceException("Error al guardar el cliente " + cliente.toString(), e);
        }
        
    }

    @Override
    public Cliente load(int id) throws PersistenceException {
        try {
            clienteMapper.consultarCliente(id);
        } catch (Exception e) {
            throw new PersistenceException("Error al cargar el cliente " + String.valueOf(id), e);
        }
        
        return null;
    }

}
