/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import ec.edu.ups.idao.*;
import ec.edu.ups.dao.*;
import java.util.Set;


/**
 *
 * @author Anahi
 */
public class ControladorCliente {

    private Cliente cliente;
    private Vehiculo vehiculo;

    private IClienteDao clienteDAO;
    private IVehiculoDao vehiculoDAO;
    private ITicketDao ticketDAO;

    public ControladorCliente(ClienteDao clienteDAO, VehiculoDao vehiculoDAO, TicketDao ticketDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculoDAO = vehiculoDAO;
        this.ticketDAO = ticketDAO;
    }

    public boolean crearCliente(String cedula, String nombre,String apellido, String tipo, String numeroT, String operadora,
            String calleP, String calleS, String numeroC) {

        Telefono tele = new Telefono(numeroT, tipo, operadora);
        Direccion dir = new Direccion(calleP, calleS, numeroC);

        cliente = new Cliente(cedula, nombre,apellido, tele, dir);
        if (clienteDAO.create(cliente)) {
            return true;
        } else {
            return false;
        }
    }

    public void agregarVehiculo(Vehiculo vehiculo, String cedulas) {
        // vehiculo = new Vehiculo(placa, marca, modelo);
        System.out.println("\n" + vehiculo);
        this.cliente = clienteDAO.read(cedulas);
        // vehiculoDAO.create(vehiculo);
        if (cliente == null || vehiculo == null) {
            System.out.println(cliente);
        } else {
            cliente.agregarVehiculo(vehiculo);
            clienteDAO.update(cliente);
            System.out.println(cliente);
            // System.out.println(cliente);
        }

    }

    public void actualizarVehiculo(Cliente cliente, Vehiculo vehiculo) {
        
        vehiculoDAO.update(vehiculo);
        cliente.actualizarVehiculo(vehiculo);
        clienteDAO.update(cliente);
        System.out.println("\nactualizado:\n" + cliente);
    }

    public Cliente buscarCliente(String cedula) {
        cliente = clienteDAO.read(cedula);
        System.out.println(cliente);
        return cliente;
    }

    public Cliente buscarPorVehiculo(String placa) {
        cliente = clienteDAO.buscarPorVehiculo(placa);
        if (cliente == null) {
            return null;
        } else {
            return cliente;
        }
    }

    public Set<Cliente> findAll() {
        return clienteDAO.findAll();
    }
}
