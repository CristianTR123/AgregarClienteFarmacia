/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ModeloDAO;

import modelo.Cliente;

/**
 *
 * @author Cristian
 */
public interface iClienteDao {
    /*public Cliente obtenerClientebyid(String idCliente);*/
    public Cliente buscarClienteNombre(String nombre);   
    public Cliente buscarClienteId(int idCliente);  
}
