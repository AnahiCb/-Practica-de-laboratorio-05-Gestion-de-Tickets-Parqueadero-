/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;
import ec.edu.ups.idao.IClienteDao;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Vehiculo;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Anahi
 */
public class ClienteDao implements IClienteDao {

    private Set<Cliente> clientes;

    public ClienteDao() {
        clientes = new HashSet<Cliente>();
    }

    @Override
    public boolean create(Cliente cliente) {
        if (!clientes.contains(cliente)) {
            clientes.add(cliente);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Cliente read(String cedula) {
        Cliente cl = new Cliente();
        Iterator<Cliente> it = clientes.iterator();
        while (it.hasNext()) {
            Cliente c = it.next();
            System.out.println("\n" + c.getCedula() + " " + cedula);
            if (c.getCedula().equals(cedula)) {
                System.out.println(c);
                cl = c;
                return c;
            }
        }

        if (cl.getNombre() != null) {
            return cl;
        } else {
            return null;
        }

    }

    @Override
    public void update(Cliente cliente) {
        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
            clientes.add(cliente);
        }

    }

    @Override
    public void delete(Cliente cliente) {

        if (clientes.contains(cliente)) {
            clientes.remove(cliente);
        }
    }

    @Override
    public Cliente buscarPorVehiculo(String placa) {

        Iterator<Cliente> it = clientes.iterator();

        while (it.hasNext()) {
            Cliente c = it.next();
            for (Vehiculo ve : c.getListaVehiculos()) {
                if (ve.getPlaca().equals(placa)) {
                    return c;
                }
                break;
            }
        }
        return null;

    }

    @Override
    public Set<Cliente> findAll() {
        return clientes;
    }

    
}
