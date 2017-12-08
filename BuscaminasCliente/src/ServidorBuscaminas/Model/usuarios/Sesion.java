/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.Model.usuarios;

/**
 *
 * @author Federico
 */
public class Sesion {

    private Usuario sesionUsuario;

    /**
     * Constructor de Sesion
     * @param usuarioConSesion 
     */
    public Sesion(Usuario usuarioConSesion) {
        this.sesionUsuario = usuarioConSesion;
    }

    
    public Usuario getSesionUsuario() {
        return sesionUsuario;
    }

    public void setSesionUsuario(Usuario sesionUsuario) {
        this.sesionUsuario = sesionUsuario;
    }

}
