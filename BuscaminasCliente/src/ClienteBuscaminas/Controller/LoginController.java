/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;

import ClienteBuscaminas.ControladoraCliente;
import CommonBuscaminas.Model.usuarios.Usuario;
import java.rmi.RemoteException;

/**
 *
 * @author dcisa
 */
public class LoginController {

    public static Usuario iniciarSesionUsuario(String nombreUsuario, String clave) throws RemoteException {
        return ControladoraCliente.getInstance().getFacade().iniciarSesion(nombreUsuario, clave);
    }

}
