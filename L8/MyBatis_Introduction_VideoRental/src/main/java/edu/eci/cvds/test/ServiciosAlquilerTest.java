package edu.eci.cvds.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import javax.print.DocFlavor.SERVICE_FORMATTED;

import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.Cliente;
import edu.eci.cvds.samples.entities.Item;
import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;
import edu.eci.cvds.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquiler;
import edu.eci.cvds.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class ServiciosAlquilerTest {
    @Inject
    private SqlSession sqlSession;
    ServiciosAlquiler serviciosAlquiler;

    public ServiciosAlquilerTest() {
        serviciosAlquiler = ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
        System.out.println(serviciosAlquiler.getClass());

    }

    @Before
    public void setUp() {
    }
    
    


    
    @Test
    public void consultarClientesTest() {
        try {
            assert(serviciosAlquiler.consultarClientes().size() > 0);
        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }
    
    @Test
    public void consultarItemTest() {
        try {
            for(int i = 10; i < 50; i++) {
                Item item = serviciosAlquiler.consultarItem(i);
            }
        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }
    
    
    @Test
    public void consultarItemsDisponiblesTest() {
        assert(serviciosAlquiler.consultarItemsDisponibles().size() > 0);
    }
    
    @Test
    public void consultarTipoItemTest() {
        try {
            for(int i = 10; i < 50; i++) {
                TipoItem item = serviciosAlquiler.consultarTipoItem(1);
            }

        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }
    
    @Test
    public void consultarTiposItemTest() {
        try {
            assert(serviciosAlquiler.consultarTiposItem().size() > 0);
        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }
    
    @Test
    public void consultarItemsClienteTest() {
        try {
            for(int i = 10; i < 20; i++) {
                assert(serviciosAlquiler.consultarItemsCliente(13).size() > 0);    
            }
        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }

    @Test 
    public void consultarCostoAlquilerTest(){
        try {
            for(int i = 10; i < 50; i++) {
                Item item = serviciosAlquiler.consultarItem(i);
                if (item != null) assert(item.getTarifaxDia()*2 ==serviciosAlquiler.consultarCostoAlquiler(1, 2));
            }

        } catch (ExcepcionServiciosAlquiler e) {
            assert(false);
        }
    }

    @Test 
    public void consultarClienteTest(){
        try {
            for (int i = 10; i < 20; i++) {
                serviciosAlquiler.consultarCliente(i);
                
            }
        } catch (Exception e) {
            assert(false);
        }
    }


    /********* TEST INSERTS ****************************************/
}