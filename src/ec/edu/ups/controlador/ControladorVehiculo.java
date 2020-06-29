/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.VehiculoDao;
import ec.edu.ups.modelo.*;
import ec.edu.ups.idao.*;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author Anahi
 */
public class ControladorVehiculo {
    private Vehiculo vehiculo;
    private Ticket ticket;

    private IVehiculoDao vehiculoDAO;

    public ControladorVehiculo(VehiculoDao vehiculoDAO) {
        this.vehiculoDAO = vehiculoDAO;
    }

    public Vehiculo crearVehiculo(String placa, String marca, String modelo) {
        vehiculo = new Vehiculo(placa, marca, modelo);
        if (vehiculoDAO.create(vehiculo)) {
            return vehiculo;
        }
        return null;
    }

    public Vehiculo actualizarVehiculo(Vehiculo vehiculo, Ticket ticket) {
        vehiculo.actualizarTicket(ticket);
        return vehiculo;
    }

    public Vehiculo buscarVehiculo(String placa) {

        vehiculo = vehiculoDAO.read(placa);
        if (vehiculo == null) {
            return null;
        } else {
            return vehiculo;
        }
    }

    public Vehiculo buscarPorTicket(Ticket ticket) {
        Set<Vehiculo> vehiculos = vehiculoDAO.findAll();
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            vehiculo = it.next();
            for (Ticket t : vehiculo.getListaTickets()) {
                if (t.getNumero() == ticket.getNumero()) {
                    return vehiculo;
                }
                break;
            }
        }
        return null;

    }
}
