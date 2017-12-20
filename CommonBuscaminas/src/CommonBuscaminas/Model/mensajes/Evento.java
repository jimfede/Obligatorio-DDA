/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.mensajes;

import java.io.Serializable;

/**
 *
 * @author Federico
 */
public enum Evento implements Serializable {
    CASILLERO_SELECCIONADO,
    JUGADA_REALIZADA,
    JUGADA_NO_PERMITIDA,
    TURNO_INCORRECTO,
    NUEVA_MINA,
    JUEGO_TERMINADO
}
