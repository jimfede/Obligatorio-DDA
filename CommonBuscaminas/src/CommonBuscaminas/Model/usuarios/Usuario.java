/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.usuarios;

import java.io.Serializable;

/**
 *
 * @author Federico
 */
public class Usuario implements Serializable{

    Integer idUsuario;
    String nombreUsuario;
    String clave;
    String nombreCompleto;
    rol rolUsuario;
    boolean sesioniniciada;
    enum rol {
        administrador, jugador
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

    public rol getRolUsuario() {
        return rolUsuario;
    }

    public boolean isSesioniniciada() {
        return sesioniniciada;
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

    public void setRolUsuario(rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setSesioniniciada(boolean sesioniniciada) {
        this.sesioniniciada = sesioniniciada;
    }
    
    

}
