/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.idao;
import ec.edu.ups.modelo.Cliente;
import java.util.Set;
/**
 *
 * @author Anahi
 */
public interface IClienteDao {
    public boolean create(Cliente cliente);
    
    public Cliente read(String cedula);
    
    public void update(Cliente cliente);
    
    public void delete(Cliente cliente);
    
    public Cliente buscarPorVehiculo(String placa);
    
    public Set<Cliente> findAll();
}
