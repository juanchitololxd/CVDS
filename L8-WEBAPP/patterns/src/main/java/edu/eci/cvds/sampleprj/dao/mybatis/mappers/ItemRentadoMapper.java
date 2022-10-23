package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.ItemRentado;

public interface ItemRentadoMapper {
    public ItemRentado consultarItem(@Param("id") int id);
    /***
     * Guarda un itemRentado en BD
     * //TODO Implementar
     * @return
     */
    public void insertarItem(@Param("item") ItemRentado item, @Param("client") Cliente client);
}
