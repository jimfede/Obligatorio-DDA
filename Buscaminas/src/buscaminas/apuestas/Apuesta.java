/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.apuestas;

import buscaminas.usuarios.jugador;

/**
 *
 * @author Federico
 */
public class Apuesta {

    private jugador apostador;
    private double monto;

    public Apuesta(jugador apostador, double monto) {
        this.apostador = apostador;
        this.monto = monto;
    }

    public jugador getApostador() {
        return apostador;
    }

    public double getMonto() {
        return monto;
    }

    public void setApostador(jugador apostador) {
        this.apostador = apostador;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
