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
public class Direccion {
    
    private String callePrincipal;
    private String calleSecundaria;
    private String numero;

    public Direccion(String callePrincipal, String calleSecundaria, String numero) {
        this.callePrincipal = callePrincipal;
        this.calleSecundaria = calleSecundaria;
        this.numero = numero;
    }

    public String getCallePrincipal() {
        return callePrincipal;
    }

    public void setCallePrincipal(String callePrincipal) {
        this.callePrincipal = callePrincipal;
    }

    public String getCalleSecundaria() {
        return calleSecundaria;
    }

    public void setCalleSecundaria(String calleSecundaria) {
        this.calleSecundaria = calleSecundaria;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return callePrincipal + " " + calleSecundaria + " " + numero;
    }
}
