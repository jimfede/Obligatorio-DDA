/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.partidas;

import buscaminas.apuestas.Apuesta;
import buscaminas.apuestas.Pozo;
import buscaminas.partidas.Casillero;
import buscaminas.partidas.Tablero;
import buscaminas.usuarios.Jugador;

/**
 *
 * @author Federico
 */
public final class Partida {

    private Jugador jugador1;
    private Jugador jugador2;
    private int turnosJugados;
    private Jugador turnoJugador;
    private Tablero tablero;
    private Pozo pozo;
    private double saldoJ1;
    private double saldoJ2;
    private Jugador ganador;
    private TimerApuesta timerApuesta;

    /**
     * Documen
     *
     * @param jugador1
     * @param tablero
     * @param apuestaInicial
     */
    public Partida(Jugador jugador1, Tablero tablero, Apuesta apuestaInicial) {
        this.jugador1 = jugador1;
        this.jugador2 = null;
        this.turnoJugador = jugador2;
        this.tablero = tablero;
        this.turnosJugados = 0;
        this.pozo = new Pozo();
        this.pozo.recibirApuesta(apuestaInicial);
        actualizarSaldo(jugador1, apuestaInicial.getMonto());
    }

    public boolean pagarApuestaInicial(Jugador jugadorInvitado) {
        if (saldoSuficiente(jugadorInvitado, this.pozo.totalPozo())) {
            actualizarSaldo(jugadorInvitado, this.pozo.totalPozo());
            return true;
        } else {
            return false;
        }
    }

    public boolean nuevaApuesta(Jugador apostador, double monto) {
        if (saldoSuficiente(apostador, monto) && this.turnoJugador == apostador) {
            this.pozo.recibirApuesta(new Apuesta(apostador, monto));
            actualizarSaldo(apostador, monto);
            this.timerApuesta = new TimerApuesta(5000);
            return true;
        } else {
            return false;
        }
    }

    public boolean pagarApuesta(Jugador apostador, double monto) {
        if (saldoSuficiente(apostador, monto) && this.turnoJugador == apostador) {
            this.pozo.recibirApuesta(new Apuesta(apostador, monto));
            actualizarSaldo(apostador, monto);
            this.timerApuesta.cancelarTimerApuesta();
            return true;
        } else {
            return false;
        }

    }

    public boolean saldoSuficiente(Jugador apostador, double monto) {
        return monto <= apostador.getCredito();
    }

    public void actualizarSaldo(Jugador apostador, double monto) {
        apostador.setCredito(apostador.getCredito() - monto);
    }

    public void setSaldoFinal() {
        this.saldoJ1 = this.jugador1.getCredito();
        this.saldoJ2 = this.jugador2.getCredito();
    }

    public boolean jugarTurno(Jugador jugador, Casillero casillero) {
        if (this.turnoJugador == jugador) {
            if (casillero.isDescubierto() == false) {
                if (casillero.getMina() == null) {
                    casillero.setDescubierto(true);
                    turnoJugadoPor(jugador);
                    this.turnosJugados++;
                    if (this.turnosJugados % 2 == 0) {
                        this.getTablero().insertarMina();
                    }
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void turnoJugadoPor(Jugador jugador) {
        if (jugador == jugador1) {
            this.turnoJugador = this.jugador2;
        }
        if (jugador == jugador2) {
            this.turnoJugador = this.jugador1;
        }
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public int getTurnosJugados() {
        return turnosJugados;
    }

    public Jugador getTurnoJugador() {
        return turnoJugador;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public void setTurnosJugados(int turnosJugados) {
        this.turnosJugados = turnosJugados;
    }

    public void setTurnoJugador(Jugador turnoJugador) {
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

    public Jugador getGanador() {
        return ganador;
    }

    public void setGanador(Jugador ganador) {
        this.ganador = ganador;
    }

}
