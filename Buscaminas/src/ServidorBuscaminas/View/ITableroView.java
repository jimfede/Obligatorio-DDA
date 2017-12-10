/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.View;

import ServidorBuscaminas.Controller.PartidaController;
import CommonBuscaminas.Model.mensajes.Mensaje;
import CommonBuscaminas.Model.partidas.Casillero;

/**
 *
 * @author Federico
 */
public interface ITableroView {

    int[] obtenerCeldaSeleccionada();

    void procesarMensajeTablero(Mensaje mensaje);

    void agregarMouseListener(PartidaController partidaController);

}
