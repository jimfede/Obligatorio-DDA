/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.apuestas;

import Model.usuarios.Jugador;

/**
 *
 * @author Federico
 */
public class Apuesta {

    private Jugador apostador;
    private double monto;

    public Apuesta(Jugador apostador, double monto) {
        this.apostador = apostador;
        this.monto = monto;
    }

    public Jugador getApostador() {
        return apostador;
    }

    public double getMonto() {
        return monto;
    }

    public void setApostador(Jugador apostador) {
        this.apostador = apostador;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
