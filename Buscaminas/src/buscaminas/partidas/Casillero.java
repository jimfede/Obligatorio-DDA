/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.partidas;

/**
 *
 * @author Federico
 */
public class Casillero {

    private int coordenadaX;
    private int coordenadaY;
    private boolean descubierto;
    private Mina mina;

    public Casillero(int coordenadaX, int coordenadaY) {
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
        this.descubierto = false;
    }

    //SOLO PARA PRUEBAS
    public String toString() {
        return String.valueOf(this.coordenadaX + " " + this.coordenadaY);
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

    public void setMina(Mina mina) {
        this.mina = mina;
    }

    public Mina getMina() {
        return mina;
    }

    public boolean isDescubierto() {
        return descubierto;
    }

    public void setDescubierto(boolean descubierto) {
        this.descubierto = descubierto;
    }

}
