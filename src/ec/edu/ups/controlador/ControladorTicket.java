/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.modelo.*;
import ec.edu.ups.idao.*;
import java.util.Date;
import java.util.Set;

/**
 *
 * @author Anahi
 */
public class ControladorTicket {
    private Cliente cliente;
    private Vehiculo vehiculo;
    private Ticket ticket;

    private IClienteDao clienteDAO;
    private IVehiculoDao vehiculoDAO;
    private ITicketDao ticketDAO;

    public ControladorTicket(IClienteDao clienteDAO, IVehiculoDao vehiculoDAO, ITicketDao ticketDAO) {
        this.clienteDAO = clienteDAO;
        this.vehiculoDAO = vehiculoDAO;
        this.ticketDAO = ticketDAO;
    }

    public Ticket crear(int numero, Date entrada) {

        ticket = new Ticket(numero, entrada);
        ticketDAO.create(ticket);

        return ticket;
    }

    public Ticket actualizarTicket(Ticket ticket, Date fechaSalida, double pago, String tiempo) {
        ticket.setFechaSalida(fechaSalida);
        ticket.setTotal(pago);
        ticket.setTiempo(tiempo);

        ticketDAO.update(ticket);
        return ticket;
    }

    public Ticket encontrarTicket(int numero) {
        ticket = ticketDAO.read(numero);

        return ticket;
    }

    public double calcularTiempo(Date fechaEntrada, Date fechaSalida) {

        double tiempo = ticket.calcularPago(fechaEntrada, fechaSalida);

        return tiempo;
    }

    public double calcularPago(double tiempo) {
        int tt = (int) Math.round(tiempo);
        tt = tt / 10;
        double pago = (tt * 25) / 100;
        return pago;
    }

    public String calcularHorasMinutos(double time) {

        int tiempoMinutos = (int) Math.round(time);

        if (tiempoMinutos >= 1440) {
            int dia = tiempoMinutos / 1440;
            String dias = dia + "" + "d";
            int horas = ((tiempoMinutos / 1440) - dia) * 60;
            int minutos = (((tiempoMinutos / 60) - horas)) * 60;
            String hour = horas + "" + "h;";
            String minute = minutos + "" + "min";
            String total = dias + " " + hour + " " + minute;
            return total;
        } else if (tiempoMinutos > 60) {
            int horas = (tiempoMinutos / 60);
            int minutos = (((tiempoMinutos / 60) - horas)) * 60;
            String hour = horas + "" + "h;";
            String minute = minutos + "" + "min";
            String total = hour + " " + minute;
            return total;
        } else {
            int minutos = tiempoMinutos;
            String minute = minutos + "" + "min";
            return minute;
        }
    }

    public Set<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    public int numeroTicket() {
        int conta = ticketDAO.devolverNumero();
        return (++conta);
    }
}
