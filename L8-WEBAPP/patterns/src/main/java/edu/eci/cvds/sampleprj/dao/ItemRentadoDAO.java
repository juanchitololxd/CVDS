package edu.eci.cvds.sampleprj.dao;

import org.apache.ibatis.exceptions.PersistenceException;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoDAO {
    public ItemRentado load(int id) throws PersistenceException;
    public void save(ItemRentado item, Cliente cli) throws PersistenceException;
}
