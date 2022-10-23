package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import edu.eci.cvds.samples.entities.Cliente;

/**
 *
 * @author 2106913
 */
public interface ClienteMapper {
    
    public Cliente consultarCliente(@Param("idcliente") int id); 
    public Cliente borrarCliente(@Param("id") int id); 
    
    /**
     * Registrar un nuevo item rentado asociado al cliente identificado
     * con 'idc' y relacionado con el item identificado con 'idi'
     * @param id
     * @param idit
     * @param fechainicio
     * @param fechafin 
     */
    public void agregarItemRentadoACliente(@Param("idcliente") int id, 
            @Param("iditemr")int idit, 
            @Param("fstart") Date fechainicio,
            @Param("fend") Date fechafin);

    /**
     * Consultar todos los clientes
     * @return 
     */
    public List<Cliente> consultarClientes();

    /***
     * Guarda un cliente en BD
     * //TODO Implementar
     * @return
     */
    public void insertarCliente(@Param("client") Cliente client);
    public String prueba();
    
}
