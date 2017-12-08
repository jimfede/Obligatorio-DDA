/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.Fachada;

import ServidorBuscaminas.Interfaces.IFacadeRemota;
import ServidorBuscaminas.Interfaces.IObservadorRemoto;
import ServidorBuscaminas.Model.GestoraSingleton;
import ServidorBuscaminas.Model.apuestas.Apuesta;
import ServidorBuscaminas.Model.mensajes.Mensaje;
import ServidorBuscaminas.Model.partidas.Casillero;
import ServidorBuscaminas.Model.partidas.Partida;
import ServidorBuscaminas.Model.usuarios.Jugador;
import ServidorBuscaminas.Model.usuarios.Usuario;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public class FacadeRemota implements IFacadeRemota {
//    
//    public FacadeRemota() throws RemoteException{
//        super();
//    }
    
    @Override
    public Usuario iniciarSesion(String nombreUsuario, String clave) throws RemoteException {
        return GestoraSingleton.getInstance().iniciarSesion(nombreUsuario, clave);
    }
    
    @Override
    public void cerrarSesion(String nombreUsuario) throws RemoteException {
        GestoraSingleton.getInstance().cerrarSesion(nombreUsuario);
    }
    
    @Override
    public Partida nuevaPartida(Jugador player, int x, int y, Apuesta aInicial) throws RemoteException {
        return GestoraSingleton.getInstance().nuevaPartida(player, x, y, aInicial);
    }
    
    @Override
    public void nuevaApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).nuevaApuesta(apostador, Monto);
    }
    
    @Override
    public void pagarApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).pagarApuesta(apostador, Monto);
    }
    
    @Override
    public void apuestaInicial(String idPartida, Jugador jugador) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).pagarApuestaInicial(jugador);
    }
    
    @Override
    public void jugarTurno(String idPartida, Jugador player, Casillero casillero) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).jugarTurno(player, casillero);
    }
    
    @Override
    public void agregarObservadores(String idPartida, IObservadorRemoto obs) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).agregarObservador(obs);
    }
    
    @Override
    public void procesarMensajePartida(String idPartida, Mensaje mensaje) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).procesarMensajePartida(mensaje);
    }
    
}
