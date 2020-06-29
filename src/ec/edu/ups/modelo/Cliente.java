/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.ArrayList;
import java.util.*;
import java.util.Objects;

/**
 *
 * @author Anahi
 */
public class Cliente {
    private String cedula;
    private String nombre;
    private String apellido;
    private Telefono telefono;
    private Direccion direccion;
    private List<Vehiculo> listaVehiculos;

    public Cliente(String cedula, String nombre,String apellido, Telefono telefono, Direccion direccion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        listaVehiculos = new ArrayList<>();
    }

    public Cliente() {
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Telefono getTelefono() {
        return telefono;
    }

    public void setTelefono(Telefono telefono) {
        this.telefono = telefono;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public void actualizarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.contains(vehiculo)) {
            int index = listaVehiculos.indexOf(vehiculo);
            listaVehiculos.set(index, vehiculo);
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (listaVehiculos.contains(vehiculo)) {
            listaVehiculos.remove(vehiculo);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.cedula);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente:\n" + "cedula=" + cedula + ", nombre=" + nombre
                + "\ntelefono=" + telefono + "\ndireccion=" + direccion
                + "\nlistaVehiculos=" + listaVehiculos + '}';
    }
}
