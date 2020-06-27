/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

/**
 *
 * @author Anahi
 */
public class Telefono {
    private String numero;
    private String tipo;
    private String operadora;

    public Telefono(String numero, String tipo, String operadora) {
        this.numero = numero;
        this.tipo = tipo;
        this.operadora = operadora;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }

    @Override
    public String toString() {
        return "Telefono\n" + "numero=" + numero + ", tipo=" + tipo + ", operadora=" + operadora;
    }
}
