/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Anahi
 */
public class Ticket {
    private int numero;
    private Date fechaEntrada;
    private Date fechaSalida;
    private double total;
    private String tiempo;

    public Ticket() {
    }

    
    public Ticket(int numero, Date fechaEntrada) {
        this.numero = numero;
        this.fechaEntrada = fechaEntrada;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    public double calcularPago(Date fechaE, Date fechaS) {

        int hora = (fechaE.getHours() * 3600);
        int minutos = (fechaE.getMinutes() * 60);
        int segundos = (fechaE.getSeconds());

        int tiempo1 = hora + minutos + segundos;

        int hora2 = (fechaS.getHours() * 3600);
        int minutos2 = (fechaS.getMinutes() * 60);
        int segundos2 = (fechaS.getSeconds());

        int tiempo2 = hora2 + minutos2 + segundos2;

        double tiempoTotal = (tiempo2 - tiempo1) / 60;

        return tiempoTotal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.numero;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ticket other = (Ticket) obj;
        if (this.numero != other.numero) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Ticket\n" + "numero=" + numero + ", fechaEntrada=" + fechaEntrada
                + ", fechaSalida=" + fechaSalida + ", total=" + total;
    }
}
