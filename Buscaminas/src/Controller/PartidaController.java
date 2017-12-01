/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Evento;
import Model.Mensaje;
import Model.partidas.Partida;
import View.ITableroView;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Federico
 */
public class PartidaController extends MouseAdapter implements Observer {

    private ITableroView tablero;
    private Partida partida;

    public PartidaController(ITableroView tableroView, Partida partida) {
        this.tablero = tableroView;
        this.partida = partida;
        this.partida.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.tablero.procesarMensajeTablero((Mensaje) arg);
    }

    @Override
    public void mouseClicked(MouseEvent click) {
        this.partida.procesarMensajePartida(new Mensaje(Evento.CASILLERO_SELECCIONADO, this.tablero.obtenerCeldaSeleccionada()));
    }

}
