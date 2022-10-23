
/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.cvds.sampleprj.jdbc.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
            String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="prueba2019";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 1));
            
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2168019;
            registrarNuevoProducto(con, suCodigoECI, "CARDENAS-FONSECA", 99999999);            
            con.commit();
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
        List<String> np=new LinkedList<>();
        String consulta = "INSERT INTO ORD_PRODUCTOS VALUES ( ?, ?, ?)";         
         try {
             PreparedStatement ps = con.prepareStatement(consulta);
             ps.setInt(1, codigo);
             ps.setString(2, nombre);
             ps.setInt(3, precio);
             con.commit();
             System.out.println("insert: "+ ps.executeUpdate());
             con.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        
        
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido){
        List<String> np=new LinkedList<>();
        //Crear prepared statement
        String consulta = "SELECT nombre FROM ORD_PRODUCTOS op JOIN ORD_DETALLE_PEDIDO odp ON op.codigo= odp.pedido_fk" +
                " where odp.pedido_fk = ?";         
         try {
             PreparedStatement ps = con.prepareStatement(consulta);
             ps.setString(1, String.valueOf(codigoPedido));
             ResultSet result = ps.executeQuery();
             while( result.next()) {
            	 np.add(result.getString("nombre"));
             }
		} catch (SQLException e) {
			e.printStackTrace();
		}
        
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido){
  
        String consulta = "SELECT SUM(cantidad*precio) FROM ORD_DETALLE_PEDIDO odp " +
                "JOIN ORD_PRODUCTOS op ON (op.codigo = odp.producto_fk) where pedido_fk =?;";
        int total = 0;
         try {
             PreparedStatement ps = con.prepareStatement(consulta);
             ps.setString(1, String.valueOf(codigoPedido));
             ResultSet result = ps.executeQuery();
             while( result.next()) {
                 total += result.getInt(1); 
             }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return total;
    }
    

    
    
    
}