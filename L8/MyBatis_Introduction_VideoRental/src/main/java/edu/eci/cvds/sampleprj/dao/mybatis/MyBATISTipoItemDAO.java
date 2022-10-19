package edu.eci.cvds.sampleprj.dao.mybatis;

import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;

import com.google.inject.Inject;

import edu.eci.cvds.sampleprj.dao.TipoItemDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.ClienteMapper;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.TipoItemMapper;
import edu.eci.cvds.samples.entities.TipoItem;

public class MyBATISTipoItemDAO implements TipoItemDAO{

    @Inject
    private TipoItemMapper tipoItemMapper;

    @Override
    public TipoItem load(int id) throws PersistenceException {
        try {
            return tipoItemMapper.getTipoItem(id);
        } catch (Exception e) {
            throw new PersistenceException("Error al consultar el tipo item " + id, e);
        }
    }

    @Override
    public List<TipoItem> load() throws PersistenceException {
        try {
            return tipoItemMapper.getTiposItems();
        } catch (Exception e) {
            throw new PersistenceException("Error al cargar los clientes ", e);
        }
    }
    
}
