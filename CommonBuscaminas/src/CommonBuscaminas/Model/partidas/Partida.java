/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.partidas;

import CommonBuscaminas.Model.mensajes.Evento;
import CommonBuscaminas.Model.mensajes.Mensaje;
import CommonBuscaminas.Model.apuestas.Apuesta;
import CommonBuscaminas.Model.apuestas.Pozo;
import CommonBuscaminas.Interfaces.IObservadorRemoto;
import CommonBuscaminas.Model.usuarios.Jugador;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.UUID;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Federico
 */
public final class Partida {

    private final String idPartida;
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
    private boolean partidaIniciada;
    private double apuestaInicial;
    private ArrayList<IObservadorRemoto> observadores = new ArrayList<>();

    /**
     * Constructor de Partida. Instancia una nueva partida para un jugador, y se
     * debita el saldo inicial apostado por el mismo
     *
     * @param jugador1
     * @param x
     * @param y
     * @param apuestaInicial
     */
    public Partida(Jugador jugador1, int x, int y, Double apuestaInicial) {
        this.jugador1 = jugador1;
        this.jugador2 = null;
        this.turnoJugador = jugador2;
        this.tablero = new Tablero(x, y);
        this.turnosJugados = 0;
        this.pozo = new Pozo();
        this.apuestaInicial = apuestaInicial;
        this.idPartida = UUID.randomUUID().toString();
    }

    public void notificarObservadores(Object arg) throws RemoteException {
        for (int i = observadores.size() - 1; i >= 0; i--) {
            observadores.get(i).update(arg);
        }
    }

    /**
     * <b>(RMI)</b> Metodo de interfaz IPartidaRemota que permite añadir
     * Observadores de manera remota.
     *
     * @param observer
     * @throws RemoteException
     */
    public void agregarObservador(IObservadorRemoto observer) {
        this.observadores.add(observer);
    }

    /**
     * Genera una nueva apuesta, con tiempo de caducidad para responder a la
     * oferta, y se valida que:<br>
     * <b>
     * <p>
     * 1. El jugador apostante posea en su cuenta la cantidad de saldo
     * suficiente para apostar.
     * </p>
     * <p>
     * 2. El jugador apostante posea el turno de jugar
     * </p>
     * </b>
     *
     * @param apostador Jugador apostador
     * @param monto Monto de Credito a apostar
     * @return
     */
    public boolean nuevaApuesta(Jugador apostador, double monto) {
        if (this.turnoJugador == jugador1) {
        }
        if (saldoSuficiente(apostador) && this.turnoJugador == apostador) {
            this.pozo.recibirApuesta(new Apuesta(apostador, monto));
            actualizarSaldo(apostador, monto);
            //this.timerApuesta = new TimerApuesta(5000);
            return true;
        } else {
            return false;
        }
    }

    public boolean pagarApuesta(Jugador apostador, double monto) {
        if (saldoSuficiente(apostador) && this.turnoJugador == apostador) {
            this.pozo.recibirApuesta(new Apuesta(apostador, monto));
            actualizarSaldo(apostador, monto);
            this.timerApuesta.cancelarTimerApuesta();
            return true;
        } else {
            return false;
        }

    }

    /**
     * Verifica que el jugador pasado como Apostador, posea la cantidad
     * suficiente de saldo en su cuenta, pasada como monto
     * <p>
     * <i>
     * <b>Podria ser implementado como una funcion del Jugador, ya que solo este
     * posee un atributo credito</b>
     * </i</p>
     *
     * @param apostador Jugador apostante
     * @param monto Monto del credito del jugador a validar
     * @return True si tiene suficiente | False sinó
     */
    public boolean saldoSuficiente(Jugador apostador) {
        return this.apuestaInicial <= apostador.getCredito();
    }

    /**
     * Actualiza el saldo del jugador apostador
     *
     * @param apostador Jugador apostador
     * @param monto Monto de credito del jugador apostador a actualizar
     */
    public void actualizarSaldo(Jugador apostador, double monto) {
        apostador.setCredito(apostador.getCredito() - monto);
    }

    public void setSaldoFinal() {
        this.saldoJ1 = this.jugador1.getCredito();
        this.saldoJ2 = this.jugador2.getCredito();
    }

    /**
     * Realiza una jugada para un Jugador dado, sobre un casillero especifico.
     *
     * @param jugador Jugador actual
     * @param casillero Casillero a jugar
     * @return True si la jugada fue satisfactoria | False si hubo un problema
     */
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
                    finalizarPartida();
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void comenzarPartida() {
        this.setPartidaIniciada(true);
        nuevaApuesta(this.jugador1, this.getApuestaInicial());
        nuevaApuesta(this.jugador2, this.getApuestaInicial());
//        notificarObservadores(new Mensaje(Evento.JUGADA_REALIZADA, "Comenzo partida"));
    }

    public void finalizarPartida() {
        //TODO: Metodo finalizar partida sin terminar
        // tres condiciones
        //1 - por descrubrir mina
        //2 - por tiempo cumplido de jugada
        //3 - por tiempo cuplido de aceptar apuesta
        //4 - no pagar apuesta

        // cambiar estado a finalizada
        // pasar bolsa de apuesta a ganador
        // notificar a jugadores con cartelito
        throw new NotImplementedException();
    }

    /**
     * Intercala el turno actual en funcion del jugador que haya realizado una
     * jugada con anterioridad
     *
     * @param jugador Jugador Actual
     */
    public void turnoJugadoPor(Jugador jugador) {
        if (jugador == jugador1) {
            this.turnoJugador = this.jugador2;
        }
        if (jugador == jugador2) {
            this.turnoJugador = this.jugador1;
        }
    }

    public void procesarMensajePartida(Mensaje mensaje) {
        if (mensaje.getEvento() == Evento.CASILLERO_SELECCIONADO) {
            int[] coord = (int[]) mensaje.getAux();
            Casillero casilleroSeleccionado = (Casillero) this.tablero.obtenerCasillero(coord[0], coord[1]);
            try {
                if (casilleroSeleccionado.isDescubierto()) {
                    notificarObservadores(new Mensaje(Evento.JUGADA_NO_PERMITIDA, "Jugada No permitida"));
                } else {
                    casilleroSeleccionado.setDescubierto(true);
                    notificarObservadores(new Mensaje(Evento.JUGADA_REALIZADA, null));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public TimerApuesta getTimerApuesta() {
        return timerApuesta;
    }

    public void setTimerApuesta(TimerApuesta timerApuesta) {
        this.timerApuesta = timerApuesta;
    }

    public String getIdPartida() {
        return idPartida;
    }

    public boolean isPartidaIniciada() {
        return partidaIniciada;
    }

    public void setPartidaIniciada(boolean partidaIniciada) {
        this.partidaIniciada = partidaIniciada;
    }

    public double getApuestaInicial() {
        return apuestaInicial;
    }

    public void setApuestaInicial(double apuestaInicial) {
        this.apuestaInicial = apuestaInicial;
    }
    
    

}
