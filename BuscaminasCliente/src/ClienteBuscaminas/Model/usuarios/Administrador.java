/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Model.usuarios;

/**
 *
 * @author Federico
 */
public class Administrador extends Usuario{

    /**
     * Constructor de Administrador
     * @param nombreUsuario Nombre de usuario
     * @param clave Clave del usuario
     * @param nombreCompleto Nombre completo del usuario
     */
    public Administrador(String nombreUsuario, String clave, String nombreCompleto) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.rolUsuario = rol.administrador;
        this.sesioniniciada = false;
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

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public rol getRolUsuario() {
        return rolUsuario;
    }

    public boolean isSesioniniciada() {
        return sesioniniciada;
    }

    public void setRolUsuario(rol rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void setSesioniniciada(boolean sesioniniciada) {
        this.sesioniniciada = sesioniniciada;
    }
   
}
