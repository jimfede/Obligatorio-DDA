/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Interfaces;

import ClienteBuscaminas.Model.apuestas.Apuesta;
import ClienteBuscaminas.Model.mensajes.Mensaje;
import ClienteBuscaminas.Model.partidas.Casillero;
import ClienteBuscaminas.Model.partidas.Partida;
import ClienteBuscaminas.Model.usuarios.Jugador;
import ClienteBuscaminas.Model.usuarios.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public interface IFacadeRemota extends Remote {

    public Usuario iniciarSesion(String nombreUsuario, String clave) throws RemoteException;

    public void cerrarSesion(String nombreUsuario) throws RemoteException;

    public Partida nuevaPartida(Jugador player, int x, int y, Apuesta aInicial) throws RemoteException;

    public void nuevaApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException;

    public void pagarApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException;

    public void apuestaInicial(String idPartida, Jugador apostador) throws RemoteException;

    public void jugarTurno(String idPartida, Jugador player, Casillero casillero) throws RemoteException;

    public void agregarObservadores(String idPartida, IObservadorRemoto obs) throws RemoteException;

    public void procesarMensajePartida(String idPartida, Mensaje mensaje) throws RemoteException;

}
