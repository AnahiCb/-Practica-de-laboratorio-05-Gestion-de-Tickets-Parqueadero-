/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.*;

/**
 *
 * @author Anahi
 */
public class Vehiculo {
    private String placa;
    private String marca;
    private String modelo;
    private List<Ticket> listaTickets;

    public Vehiculo() {
    }

    
    public Vehiculo(String placa, String marca, String modelo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;

        listaTickets = new ArrayList<>();
    }

 
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Ticket> getListaTickets() {
        return listaTickets;
    }

    public void agregarTicket(Ticket ticket) {
        listaTickets.add(ticket);
    }

    public void actualizarTicket(Ticket ticket) {
        if(listaTickets.contains(ticket)){
            int index = listaTickets.indexOf(ticket);
            listaTickets.set(index, ticket);
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.placa);
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
        final Vehiculo other = (Vehiculo) obj;
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vehiculo\n" + "placa=" + placa + ", marca=" + marca + ", modelo="
                + modelo + ", ticket=" + listaTickets;
    }
}
