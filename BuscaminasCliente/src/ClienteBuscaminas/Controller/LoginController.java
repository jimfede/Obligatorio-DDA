/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;

import ClienteBuscaminas.GestoraCliente;
import ClienteBuscaminas.View.Principal;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Usuario;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/**
 *
 * @author dcisa
 */
public class LoginController {

    public static void iniciarSesionUsuario(String nombreUsuario, String clave) throws RemoteException {
        Usuario miUsuario = GestoraCliente.getInstance().getFacade().iniciarSesion(nombreUsuario, clave);
        if (miUsuario != null) {

            GestoraCliente.getInstance().setMyUsuario(miUsuario);

            if (miUsuario.getRolUsuario().equals(Usuario.rol.jugador)) {
                
                String idPartida = buscarPartidaNoIniciada(((Jugador) miUsuario));
                
                if (idPartida != null) {
                    GestoraCliente.getInstance().inicializarPartida(idPartida);

                } else {
                    new Principal().setVisible(true);
                }
            } else {
//                Agregar un Panel solo para administradores
            }
        } else {
            JOptionPane.showMessageDialog(null, "No existe ese usuario en el sistema :(");
        }

    }

    public static String buscarPartidaNoIniciada(Jugador jugador) throws RemoteException {
        return GestoraCliente.getInstance().getFacade().buscarPartidaNoIniciada(jugador);
    }
}
