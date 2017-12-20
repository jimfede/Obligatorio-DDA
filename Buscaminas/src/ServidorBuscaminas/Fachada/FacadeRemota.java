/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.Fachada;

import CommonBuscaminas.Interfaces.IFacadeRemota;
import CommonBuscaminas.Interfaces.IObservadorRemoto;
import CommonBuscaminas.Model.mensajes.Evento;
import ServidorBuscaminas.GestoraSingleton;
import CommonBuscaminas.Model.mensajes.Mensaje;
import CommonBuscaminas.Model.partidas.Casillero;
import CommonBuscaminas.Model.partidas.Partida;
import CommonBuscaminas.Model.partidas.Tablero;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Usuario;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class FacadeRemota implements IFacadeRemota {

    private ArrayList<IObservadorRemoto> observadores = new ArrayList<>();
    private static FacadeRemota miFacade;

    protected FacadeRemota() {
    }

    public static FacadeRemota getInstance() {
        if (miFacade == null) {
            return miFacade = new FacadeRemota();
        }
        return miFacade;
    }

    @Override
    public Usuario iniciarSesion(String nombreUsuario, String clave) throws RemoteException {
        return GestoraSingleton.getInstance().iniciarSesion(nombreUsuario, clave);
    }

    @Override
    public void cerrarSesion(String nombreUsuario) throws RemoteException {
        GestoraSingleton.getInstance().cerrarSesion(nombreUsuario);
    }

    @Override
    public String nuevaPartida(Jugador player, int x, int y, double aInicial) throws RemoteException {
        return GestoraSingleton.getInstance().nuevaPartida(player, x, y, aInicial).getIdPartida();
    }

    @Override
    public Tablero obtenerTablero(String partidaId) throws RemoteException {
        return GestoraSingleton.getInstance().obtenerPartida(partidaId).getTablero();
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
    public String buscarPartidaNoIniciada(Jugador jugador) throws RemoteException {
        return GestoraSingleton.getInstance().buscarPartidaNoIniciada(jugador);
    }

    @Override
    public void jugarTurno(String idPartida, Jugador player, Casillero casillero) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).jugarTurno(player, casillero);
    }

    @Override
    public void agregarObservadores(String idPartida, IObservadorRemoto obs) throws RemoteException {
//        FacadeRemota miFacadeRemota = FacadeRemota.getInstance();
//        miFacadeRemota.observadores.add(obs);
        Partida miPartida = GestoraSingleton.getInstance().obtenerPartida(idPartida);
        if (miPartida != null) {
            miPartida.agregarObservador(obs);
        }else{
            System.err.println("No se encontró una partida con el id: " + idPartida);
        }

    }

    @Override
    public void procesarMensajePartida(String idPartida, Mensaje mensaje) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).procesarMensajePartida(mensaje);
    }

    @Override
    public boolean unirseAPartida(String idPartida, Jugador jugador) throws RemoteException {
        return GestoraSingleton.getInstance().unirseAPartida(idPartida, jugador);
    }

    @Override
    public boolean chequearSaldoInicio(Double monto, Jugador jugador) {
        return GestoraSingleton.getInstance().chequearSaldoInicio(monto, jugador);
    }

    @Override
    public Evento jugarTurno(String idPartida, Jugador jugador, int[] coordenadas) throws RemoteException {
        return GestoraSingleton.getInstance().obtenerPartida(idPartida).jugarTurno(jugador, new Casillero(coordenadas[0], coordenadas[1]));
    }
}
