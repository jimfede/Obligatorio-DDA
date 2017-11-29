/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.partidas.Partida;
import View.ITableroView;
import java.awt.event.MouseAdapter;
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
    }

    @Override
    public void update(Observable o, Object o1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
