package edu.eci.cvds.sampleprj.dao.mybatis.mappers;


import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.TipoItem;

public interface TipoItemMapper {
    
    
    public List<TipoItem> getTiposItems();
    
    public TipoItem getTipoItem(@Param("id") int id);
    
    public void addTipoItem(@Param("item") TipoItem item);

}
