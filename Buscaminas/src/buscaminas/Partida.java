/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.usuarios.jugador;

/**
 *
 * @author Federico
 */
public class Partida {

    private jugador jugador1;
    private jugador jugador2;
    private int turnosJugados;
    private jugador turnoJugador;
    private Tablero tablero;

    public Partida(jugador jugador1, Tablero tablero) {
        this.jugador1 = jugador1;
        this.tablero = tablero;
        this.turnosJugados = 0;
    }

    public jugador getJugador1() {
        return jugador1;
    }

    public jugador getJugador2() {
        return jugador2;
    }

    public int getTurnosJugados() {
        return turnosJugados;
    }

    public jugador getTurnoJugador() {
        return turnoJugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public Partida(jugador jugador1) {
        this.jugador1 = jugador1;
        this.turnosJugados = 0;
    }

    public void setJugador1(jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setTurnosJugados(int turnosJugados) {
        this.turnosJugados = turnosJugados;
    }

    public void setTurnoJugador(jugador turnoJugador) {
        this.turnoJugador = turnoJugador;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }
}
