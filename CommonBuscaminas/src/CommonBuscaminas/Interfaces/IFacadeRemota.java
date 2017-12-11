/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Interfaces;

import CommonBuscaminas.Model.apuestas.Apuesta;
import CommonBuscaminas.Model.mensajes.Mensaje;
import CommonBuscaminas.Model.partidas.Casillero;
import CommonBuscaminas.Model.partidas.Tablero;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Usuario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public interface IFacadeRemota extends Remote {

    public Usuario iniciarSesion(String nombreUsuario, String clave) throws RemoteException;

    public void cerrarSesion(String nombreUsuario) throws RemoteException;

    /**
     * Crea una nueva partida en el sistema remoto
     * @param player
     * @param x
     * @param y
     * @param aInicial
     * @return Devuelve un Object[] con 2 objetos maximo (1 = PartidaId, 2 = Tablero de la partida)
     * @throws RemoteException 
     */
    public String nuevaPartida(Jugador player, int x, int y, Apuesta aInicial) throws RemoteException;
    
    public Tablero obtenerTablero(String partidaId) throws RemoteException;

    public void nuevaApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException;

    public void pagarApuesta(String idPartida, Jugador apostador, double Monto) throws RemoteException;

    public void apuestaInicial(String idPartida, Jugador apostador) throws RemoteException;

    public void jugarTurno(String idPartida, Jugador player, Casillero casillero) throws RemoteException;

    public void agregarObservadores(String idPartida, IObservadorRemoto obs) throws RemoteException;

    public void procesarMensajePartida(String idPartida, Mensaje mensaje) throws RemoteException;

}