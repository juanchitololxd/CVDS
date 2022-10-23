package edu.eci.cvds.sampleprj.dao;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;

public interface ClienteDAO {
    public void save(Cliente cliente) throws PersistenceException;
    public Cliente load(int id) throws PersistenceException;
    public List<Cliente> load() throws PersistenceException;
}
