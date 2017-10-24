/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Federico
 */
public class administrador extends usuario{

    public administrador() {
        this.rolUsuario = RolSingleton.getInstance().getRolAdministrador();
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
