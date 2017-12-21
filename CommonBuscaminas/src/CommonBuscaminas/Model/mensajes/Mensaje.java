/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.mensajes;

import CommonBuscaminas.Model.usuarios.Jugador;
import java.io.Serializable;

/**
 *
 * @author Federico
 */
public class Mensaje implements Serializable {

    private Evento evento;
    private Object aux;
    private Jugador jugador;

    public Mensaje(Evento evento, Object aux) {
        this.evento = evento;
        this.aux = aux;
    }

    public Mensaje(Evento evento, Object aux, Jugador jugador) {
        this.evento = evento;
        this.aux = aux;
        this.jugador = jugador;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Object getAux() {
        return aux;
    }

    public void setAux(Object aux) {
        this.aux = aux;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

}
