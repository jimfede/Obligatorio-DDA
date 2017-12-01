/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.GestoraBuscaminas;

/**
 *
 * @author Federico
 */
public class LoginController {

    private GestoraBuscaminas serveradmin;

    /**
     * Constructor de controlador de login.
     * El constructor recibe la clase administradora del servidor que se instancia cuando se corre el MainServidor en el servidor.
 Esta clase administradora GestoraBuscaminas contiene una lista de todas las sesiones y los metodos necesarios para menejo de sesiones.
     * @param serveradmin 
     */
    LoginController(GestoraBuscaminas serveradmin) {
        this.serveradmin = serveradmin;
    }

}
