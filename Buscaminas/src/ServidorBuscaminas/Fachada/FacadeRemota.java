/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.Fachada;

import CommonBuscaminas.Interfaces.IFacadeRemota;
import CommonBuscaminas.Interfaces.IObservadorRemoto;
import ServidorBuscaminas.GestoraSingleton;
import CommonBuscaminas.Model.apuestas.Apuesta;
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
public class FacadeRemota implements IFacadeRemota, IObservadorRemoto {

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
    public String nuevaPartida(Jugador player, int x, int y, Apuesta aInicial) throws RemoteException {
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
    public void apuestaInicial(String idPartida, Jugador jugador) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).pagarApuestaInicial(jugador);
    }

    @Override
    public void jugarTurno(String idPartida, Jugador player, Casillero casillero) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).jugarTurno(player, casillero);
    }

    @Override
    public void agregarObservadores(String idPartida, IObservadorRemoto obs) throws RemoteException {
        //Obtengo mi fachada remota
        FacadeRemota miFacadeRemota = FacadeRemota.getInstance();
        //Le agrego el IObservadorRemoto pasado como parametro
        miFacadeRemota.observadores.add(obs);
        //Obtengo la partida a la cual le voy a insertar la Fachada como Observador
        Partida miPartida = GestoraSingleton.getInstance().obtenerPartida(idPartida);
        //Agrego a mi partida la fachada como Observador
        miPartida.agregarObservador(miFacadeRemota);
    }

    @Override
    public void procesarMensajePartida(String idPartida, Mensaje mensaje) throws RemoteException {
        GestoraSingleton.getInstance().obtenerPartida(idPartida).procesarMensajePartida(mensaje);
    }

    @Override
    public void update(Object aux) throws RemoteException {
        notificarObservadores(aux);
    }

    public void notificarObservadores(Object arg) throws RemoteException {
        for (int i = observadores.size() - 1; i >= 0; i--) {
            observadores.get(i).update(arg);
        }
    }
}
