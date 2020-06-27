/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.dao;

import ec.edu.ups.idao.IVehiculoDao;
import ec.edu.ups.modelo.Vehiculo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/**
 *
 * @author Anahi
 */
public class VehiculoDao implements IVehiculoDao{
    private Set<Vehiculo> vehiculos;

    public VehiculoDao() {
        vehiculos = new HashSet<>();
    }

    @Override
    public boolean create(Vehiculo vehiculo) {
        if (!vehiculos.contains(vehiculo)) {
            vehiculos.add(vehiculo);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public Vehiculo read(String placa) {
        Vehiculo vv = new Vehiculo();

        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getPlaca().equals(placa)) {
                vv = v;
                return v;
            }
        }
        if (vv.getPlaca() != null) {
            return vv;
        } else {
            return null;
        }
    }

    @Override
    public void update(Vehiculo vehiculo) {
        Iterator<Vehiculo> it = vehiculos.iterator();
        while (it.hasNext()) {
            Vehiculo v = it.next();
            if (v.getPlaca().equals(vehiculo.getPlaca())) {
                it.remove();
            }
        }
        vehiculos.add(vehiculo);
    }

    @Override
    public void delete(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
        }
    }

    @Override
    public Set<Vehiculo> findAll() {
        return vehiculos;
    }

}
