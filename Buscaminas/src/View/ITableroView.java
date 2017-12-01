/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.PartidaController;
import Model.Mensaje;
import Model.partidas.Casillero;

/**
 *
 * @author Federico
 */
public interface ITableroView {

    int[] obtenerCeldaSeleccionada();

    void procesarMensajeTablero(Mensaje mensaje);

    void agregarMouseListener(PartidaController partidaController);

}
