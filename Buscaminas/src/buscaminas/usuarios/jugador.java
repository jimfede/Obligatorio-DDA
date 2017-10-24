/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.usuarios;

/**
 *
 * @author Federico
 */
public class jugador extends usuario {

    Double credito;

    public jugador(String nombreUsuario, String clave, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.rolUsuario = RolSingleton.getInstance().getRolJugador();
        this.sesioniniciada = false;
        this.credito = 0.0;
    }

    public Double getCredito() {
        return credito;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getRolUsuario() {
        return rolUsuario;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setRolUsuario(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

}
