/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Interfaces.IFacadeRemota;
import Model.mensajes.Evento;
import Model.mensajes.Mensaje;
import View.ITableroView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Federico
 */
public class PartidaController extends MouseAdapter {

    private ITableroView tablero;
    private String idPartida;

    public PartidaController(ITableroView tableroView, String xidPartida) {
        this.tablero = tableroView;
        this.idPartida = xidPartida;
        try {
            ControladoraCliente.getInstance().agregarObservador(new AdaptadorPartidaController(this));
        } catch (RemoteException ex) {
            Logger.getLogger(PartidaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procesarMensajeTablero(Object arg) {
        this.tablero.procesarMensajeTablero((Mensaje) arg);
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        try {
            this.partida.procesarMensajePartida(new Mensaje(Evento.CASILLERO_SELECCIONADO, this.tablero.obtenerCeldaSeleccionada()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
