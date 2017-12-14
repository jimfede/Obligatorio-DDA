/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;

import ClienteBuscaminas.ControladoraCliente;
import CommonBuscaminas.Model.mensajes.Evento;
import ClienteBuscaminas.View.ITableroView;
import CommonBuscaminas.Interfaces.IObservadorRemoto;
import CommonBuscaminas.Model.mensajes.Mensaje;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Federico
 */
public class PartidaController extends MouseAdapter implements IObservadorRemoto, Remote, Serializable {

    private ITableroView tablero;
    private String idPartida;

    public PartidaController(ITableroView tableroView, String xidPartida) {
        this.tablero = tableroView;
        this.idPartida = xidPartida;
        agregarObservadores(xidPartida);
    }

    private void agregarObservadores(String idPartida) {
        try {
            ControladoraCliente.getInstance().getFacade().agregarObservadores(idPartida, this);
        } catch (RemoteException e) {
            System.out.println("Error de conmunicación RMI en: ");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Error en: ");
            e.printStackTrace();
        }
    }

    public void procesarMensajeTablero(Object arg) {
        this.tablero.procesarMensajeTablero((Mensaje) arg);
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        try {
            //Mensaje a envair
            Mensaje myMensaje = new Mensaje(Evento.CASILLERO_SELECCIONADO, this.tablero.obtenerCeldaSeleccionada());
            //Obtengo la Fachada, a traves de la gestora cliente, 
            //y ejecuto el metodo remoto de Partida procesarMensajePartida
            ControladoraCliente.getInstance().getFacade().procesarMensajePartida(idPartida, myMensaje);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object aux) throws RemoteException {
        procesarMensajeTablero(aux);
    }

}
