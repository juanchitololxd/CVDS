package edu.eci.cvds.sampleprj.dao.mybatis;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.ItemRentadoDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ItemRentadoMapper;
import edu.eci.cvds.samples.entities.ItemRentado;

public class MyBatisItemRentadoDAO implements ItemRentadoDAO{

    @Inject
    private ItemRentadoMapper itemMapper;

    @Override
    public ItemRentado load(int id) throws PersistenceException {
        try {
            return itemMapper.consultarItem(id);
        } catch (org.apache.ibatis.exceptions.PersistenceException e) {
            throw new PersistenceException("Error al consultar el item " + id, e);
        }
    }

    @Override
    public void save(ItemRentado item) throws PersistenceException {
        try {
            itemMapper.insertarItem(item);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
    
}
