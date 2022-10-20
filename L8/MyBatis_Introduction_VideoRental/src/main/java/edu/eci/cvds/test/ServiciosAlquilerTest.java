package edu.eci.cvds.test;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;
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
    }

    @Before
    public void setUp() {
    }

    @Test
    public void emptyDB() {
        for (int i = 0; i < 100; i += 10) {
            boolean r = false;
            try {
                Cliente cliente = serviciosAlquiler.consultarCliente(i);
            } catch (ExcepcionServiciosAlquiler e) {
                r = true;
            } catch (IndexOutOfBoundsException e) {
                r = true;
            }
            // Validate no Client was found;
            Assert.assertTrue(r);
        }
        ;
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
                if (item == null) throw new ExcepcionServiciosAlquiler("NULL");
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
            TipoItem item = serviciosAlquiler.consultarTipoItem(1);
            if (item == null) throw new ExcepcionServiciosAlquiler("NULL");
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
    
    //consultarCostoAlquiler consultarMultaAlquiler consultarCostoAlquiler consultarCliente
    
    
}