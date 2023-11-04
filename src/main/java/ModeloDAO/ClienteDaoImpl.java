/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Excepciones.ExcpecionesDao;
import Persistencia.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author Cristian
 */
public class ClienteDaoImpl implements iClienteDao {
    final String INSERT = "INSERT INTO cliente(rfcCliente,nombreCliente,apellidoPaterno,apellidoMaterno,numeroTelefono,correoElectronico,calleCliente,numeroExterior,numeroInterior,codigoPostal,colonia,municipio,estado,pais,fechaRegistro,estatus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    final String DELETE = "DELETE FROM cliente WHERE idCliente=?";
    final String UPDATE = "UPDATE cliente SET rfcCliente=?,nombreCliente=?,apellidoPaterno=?,apellidoMaterno=?,numeroTelefono=?,correoElectronico=?,calleCliente=?,numeroExterior=?,numeroInterior=?,codigoPostal=?,colonia=?,municipio=?,estado=?,pais=?,fechaRegistro=?,estatus=? WHERE idCliente=?";
   
    Conexion conexion = new Conexion();
    Connection conn = conexion.obtenerConexion();
    
        public ClienteDaoImpl()
    {
        this.conexion= new Conexion();
    }
        
    
    public Cliente obtenerClienteyid(String idCliente) {
        /**
         * primero me conecto
         */
       
       Cliente user =null;
       String sql = "SELECT * FROM cliente WHERE idCliente ="+idCliente;
       
       try{
           
           /**
            * Realizo la consulta a la base de datos
            */
           Statement sentencia = conn.createStatement();
           ResultSet resultado = sentencia.executeQuery(sql);
            /**
             * Se recorren las tuplas retornadas
             */
            user = new Cliente();
             
            while (resultado.next()) {
          
               user.setId(resultado.getInt("id"));
               user.setRfc(resultado.getString("Rfc"));
               user.setNombre(resultado.getString("nombre"));
               user.setApellidoPaterno(resultado.getString("apellidoPaterno"));
               user.setApellidoMaterno(resultado.getString("apellidoMaterno"));
               user.setNumeroTelefonico(resultado.getString("numeroTelefonico"));
               user.setCorreo(resultado.getString("correo"));
               user.setCalle(resultado.getString("calle"));              
               user.setNumeroExterior(resultado.getInt("numeroExterior"));
               user.setNumeroInterior(resultado.getInt("numeroInterior"));
               user.setCodigoPostal(resultado.getInt("codigoPostal"));
               user.setColonia(resultado.getString("colonia"));
               user.setMunicipio(resultado.getString("municipio"));
               user.setEstado(resultado.getString("estado"));
               user.setPais(resultado.getString("pais"));
               user.setFechaRegistro(resultado.getString("fechaRegistro"));
               user.setEstatus(resultado.getString("estatus"));
            }
            
            conn.close(); 
       }catch(SQLException ex){
       
       }
       return user;
    }
    
    public void crearCliente(Cliente user) throws ExcpecionesDao {
        PreparedStatement stat = null;
        ResultSet rs= null;
        try{
            stat = conn.prepareStatement(INSERT);
             stat.setString(1, user.getRfc());
            stat.setString(2, user.getNombre());
            stat.setString(3, user.getApellidoPaterno());
            stat.setString(4, user.getApellidoMaterno());
            stat.setString(5, user.getNumeroTelefonico());
            stat.setString(6, user.getCorreo());
            stat.setString(7, user.getCalle());
            stat.setInt(8, user.getNumeroExterior());
            stat.setInt(9, user.getNumeroInterior());
            stat.setInt(10, user.getCodigoPostal());
            stat.setString(11, user.getColonia());
            stat.setString(12, user.getMunicipio());
            stat.setString(13, user.getEstado());
            stat.setString(14, user.getPais());
            stat.setString(15, user.getFechaRegistro());
            stat.setString(16, user.getEstatus());
            stat.executeUpdate();
        }catch(SQLException ex){
            throw new ExcpecionesDao("Eror en sql", ex);
        }finally{
            if(rs!=null){
                try{
                    rs.close();
                }catch (SQLException ex){
                    new ExcpecionesDao("Error en sql", ex);
                }
            }
            if(stat !=null){
                try {
                    stat.close();
                }catch(SQLException ex){
                    throw new ExcpecionesDao("Error en sql", ex);
                }
            }
        }
        
    }
  
    
    public void eliminarCliente(Cliente user) throws ExcpecionesDao {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(DELETE);
            stat.setInt(1, user.getId());//modificacion
            System.out.println(user.getId());
            if(stat.executeUpdate()== 0){
                throw new ExcpecionesDao("El Cliente no se borró");
            }
        }catch(SQLException ex){
            throw new ExcpecionesDao("Error de SQL", ex);
        }finally{
            if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new ExcpecionesDao("Error de SQL", ex);
                }
            }
        }
    }

    public void actualizarCliente(Cliente user) throws ExcpecionesDao {
        PreparedStatement stat = null;
        try{
            stat = conn.prepareStatement(UPDATE);
            stat.setString(1, user.getRfc());
            stat.setString(2, user.getNombre());
            stat.setString(3, user.getApellidoPaterno());
            stat.setString(4, user.getApellidoMaterno());
            stat.setString(5, user.getNumeroTelefonico());
            stat.setString(6, user.getCorreo());
            stat.setString(7, user.getCalle());
            stat.setInt(8, user.getNumeroExterior());
            stat.setInt(9, user.getNumeroInterior());
            stat.setInt(10, user.getCodigoPostal());
            stat.setString(11, user.getColonia());
            stat.setString(12, user.getMunicipio());
            stat.setString(13, user.getEstado());
            stat.setString(14, user.getPais());
            stat.setString(15, user.getFechaRegistro());
            stat.setString(16, user.getEstatus());
            stat.setInt(17, user.getId());
            
            stat.execute();
             if(stat.executeUpdate()==0){
                throw new ExcpecionesDao("No se actualizó la categoría");
            }
        }catch(SQLException ex){
            throw new ExcpecionesDao("Error de SQL", ex);
        }finally{
            if(stat!=null){
                try{
                    stat.close();
                }catch(SQLException ex){
                    throw new ExcpecionesDao("Error de SQL", ex);
                }
            }
        }                
    }
    
    /*@Override
    public Cliente buscarClienteId(int idCliente) {
        Conexion conexion = new Conexion();
        Cliente user = null;
        String sql = "SELECT * FROM cliente WHERE idCliente ="+idCliente;
        
        try {
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            user = new Cliente();
            while (resultado.next()) {
               user.setId(resultado.getInt("id"));
               user.setRfc(resultado.getString("Rfc"));
               user.setNombre(resultado.getString("nombre"));
               user.setApellidoPaterno(resultado.getString("apellidoPaterno"));
               user.setApellidoMaterno(resultado.getString("apellidoMaterno"));
               user.setNumeroTelefonico(resultado.getString("numeroTelefonico"));
               user.setCorreo(resultado.getString("correo"));
               user.setCalle(resultado.getString("calle"));              
               user.setNumeroExterior(resultado.getInt("numeroExterior"));
               user.setNumeroInterior(resultado.getInt("numeroInterior"));
               user.setCodigoPostal(resultado.getInt("codigoPostal"));
               user.setColonia(resultado.getString("colonia"));
               user.setMunicipio(resultado.getString("municipio"));
               user.setEstado(resultado.getString("estado"));
               user.setPais(resultado.getString("pais"));
               user.setFechaRegistro(resultado.getString("fechaRegistro"));
               user.setEstatus(resultado.getString("estatus"));
                
            }
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    */
    @Override
    public Cliente buscarClienteNombre(String nombre) {
        Conexion conexion = new Conexion();
        Cliente user = null;
      
        String sql = "SELECT * FROM cliente WHERE nombreCliente like '%"+nombre+"%'"; //collate Latin1_General_CI_AI
        
        try {
            Connection conn = conexion.obtenerConexion();
            Statement sentencia = conn.createStatement();
            ResultSet resultado = sentencia.executeQuery(sql);
            
            
            while (resultado.next()) {
               user = new Cliente(); 
               user.setId(resultado.getInt("idCliente"));
               user.setRfc(resultado.getString("rfcCliente"));
               user.setNombre(resultado.getString("nombreCliente"));
               user.setApellidoPaterno(resultado.getString("apellidoPaterno"));
               user.setApellidoMaterno(resultado.getString("apellidoMaterno"));
               user.setNumeroTelefonico(resultado.getString("numeroTelefono"));
               user.setCorreo(resultado.getString("correoElectronico"));
               user.setCalle(resultado.getString("calleCliente"));              
               user.setNumeroExterior(resultado.getInt("numeroExterior"));
               user.setNumeroInterior(resultado.getInt("numeroInterior"));
               user.setCodigoPostal(resultado.getInt("codigoPostal"));
               user.setColonia(resultado.getString("colonia"));
               user.setMunicipio(resultado.getString("municipio"));
               user.setEstado(resultado.getString("estado"));
               user.setPais(resultado.getString("pais"));
               user.setFechaRegistro(resultado.getString("fechaRegistro"));
               user.setEstatus(resultado.getString("estatus"));
                
                }
                    conn.close(); 
            
            } catch (SQLException ex) {
                Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            return user;
    }
    public void getTodosClientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*@Override
    public Cliente obtenerClientebyid(String idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
*/
    @Override
    public Cliente buscarClienteId(int idCliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
     
    
}