/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;

import ClienteBuscaminas.GestoraCliente;
import CommonBuscaminas.Model.mensajes.Evento;
import ClienteBuscaminas.View.ITableroView;
import CommonBuscaminas.Interfaces.IObservadorRemoto;
import CommonBuscaminas.Model.mensajes.Mensaje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Federico
 */
public class PartidaController extends MouseAdapter implements IObservadorRemoto {

    private ITableroView tablero;
    private String idPartida;

    public PartidaController(ITableroView tableroView, String xidPartida) throws RemoteException{
        this.tablero = tableroView;
        this.idPartida = xidPartida;
        agregarObservadores(xidPartida);
    }

    private void agregarObservadores(String idPartida) {
        try {
            GestoraCliente.getInstance().getFacade().agregarObservadores(idPartida, (IObservadorRemoto) UnicastRemoteObject.exportObject(this, 0));
        } catch (RemoteException e) {
            System.out.println("Error de conmunicación RMI en: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error en: ");
            e.printStackTrace();
        }
    }

    public void procesarMensajeTablero(Object arg, Object msg) {
        this.tablero.procesarMensajeTablero(arg, (Mensaje) msg);
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        try {
            //Mensaje a envair
            Mensaje myMensaje = new Mensaje(Evento.CASILLERO_SELECCIONADO, this.tablero.obtenerCeldaSeleccionada());
            //Obtengo la Fachada, a traves de la gestora cliente, 
            //y ejecuto el metodo remoto de Partida procesarMensajePartida
            GestoraCliente.getInstance().getFacade().procesarMensajePartida(idPartida, myMensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object aux, Object msg) throws RemoteException {
        procesarMensajeTablero(aux, msg);
    }

}
