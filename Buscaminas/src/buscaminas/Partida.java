/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.apuestas.Apuesta;
import buscaminas.apuestas.Pozo;
import buscaminas.tablero.Tablero;
import buscaminas.usuarios.jugador;

/**
 *
 * @author Federico
 */
public final class Partida {

    private jugador jugador1;
    private jugador jugador2;
    private int turnosJugados;
    private jugador turnoJugador;
    private Tablero tablero;
    private Pozo pozo;
    private double saldoJ1;
    private double saldoJ2;

    public Partida(jugador jugador1, Tablero tablero, Apuesta apuestaInicial) {
        this.jugador1 = jugador1;
        this.tablero = tablero;
        this.turnosJugados = 0;
        this.pozo = new Pozo();
        this.pozo.recibirApuesta(apuestaInicial);
        ControladoraSingleton.getInstance().actualizarSaldo(jugador1, apuestaInicial.getMonto());
    }

    public void nuevaApuesta(jugador apostador, double monto) {
        if (saldoSuficiente(apostador, monto)) {
            this.pozo.recibirApuesta(new Apuesta(apostador, monto));
            ControladoraSingleton.getInstance().actualizarSaldo(apostador, monto);
        }
    }

    public boolean saldoSuficiente(jugador apostador, double monto) {
        return monto <= apostador.getCredito();
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

    public Pozo getPozo() {
        return pozo;
    }

    public double getSaldoJ1() {
        return saldoJ1;
    }

    public double getSaldoJ2() {
        return saldoJ2;
    }

    public void setPozo(Pozo pozo) {
        this.pozo = pozo;
    }

    public void setSaldoJ1(double saldoJ1) {
        this.saldoJ1 = saldoJ1;
    }

    public void setSaldoJ2(double saldoJ2) {
        this.saldoJ2 = saldoJ2;
    }

}
