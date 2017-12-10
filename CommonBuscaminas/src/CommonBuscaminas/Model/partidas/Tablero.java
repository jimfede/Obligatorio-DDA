/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.partidas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class Tablero implements Serializable{

    private int casillerosX;
    private int casillerosY;
    private String color1;
    private String color2;
    private ArrayList<Casillero> casilleros = new ArrayList<>();

    /**
     * Constructor de Tablero. Crea una nueva instancia de Tablero, con X & Y
     * casilleros, y coloca la primera mina en el tablero.
     *
     * @param casillerosX Cantidad de Casilleros en X
     * @param casillerosY Cantidad de Casilleros en Y
     */
    public Tablero(int casillerosX, int casillerosY) {
        this.casillerosX = casillerosX;
        this.casillerosY = casillerosY;
        int i = 0;
        int j = 0;
        while (i <= casillerosX) {
            while (j <= casillerosY) {
                Casillero casillero = new Casillero(i, j);
                this.casilleros.add(casillero);
                j++;
            }
            j = 0;
            i++;
        }
        insertarMina();
    }

    /**
     * Valida si el area del tablero es mayor o igual a 9 O menor o igual a 100
     * como area maxima de casilleros en el tablero @param casillerosX Cantidad
     * de Casilleros en X
     *
     * @param casillerosX
     * @param casillerosY
     * @
     * param casillerosY Cantidad de Casilleros en Y
     * @return True si esta dentro de las medidas | False sinó
     */
    public boolean checkMedidasTablero(int casillerosX, int casillerosY) {
        if (casillerosX * casillerosY >= 9 || casillerosX * casillerosY <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public Object obtenerCasillero(int x, int y) {
        for (Casillero i : casilleros) {
            if (i.getCoordenadaX() == x && i.getCoordenadaY() == y) {
                return i;
            }
        }
        return null;
    }

    /**
     * Inserta una mina de manera aleatoria donde no hayan otras minas o la
     * casilla esté descubierta en el tablero actual.
     */
    public void insertarMina() {
        Mina nuevaMina = minaRandom(this.casillerosX, this.casillerosY);
        boolean minaInsertada = false;
        do {
            for (Casillero k : casilleros) {
                if (k.getMina() == null && !k.isDescubierto()) {
                    if (k.getCoordenadaX() == nuevaMina.getCoordenadaX() && k.getCoordenadaY() == nuevaMina.getCoordenadaY()) {
                        k.setMina(nuevaMina);
                        minaInsertada = true;
                    }
                }
            }
        } while (minaInsertada == false);
    }

    /**
     * Calcula de manera aleatoria, donde colocar la proxima mina, dentro de un
     * rango maximo de X e Y
     *
     * @param casillerosX Cantidad de Casilleros en X
     * @param casillerosY Cantidad de Casilleros en Y
     * @return Nuevo Objeto mina a colocar.
     */
    public Mina minaRandom(int casillerosX, int casillerosY) {
        Mina nuevaMina = new Mina((int) (Math.random() * casillerosX) + 1, (int) (Math.random() * casillerosY) + 1);
        return nuevaMina;
    }

    public int getCasillerosX() {
        return casillerosX;
    }

    public int getCasillerosY() {
        return casillerosY;
    }

    public String getColor1() {
        return color1;
    }

    public String getColor2() {
        return color2;
    }

    public ArrayList<Casillero> getCasilleros() {
        return casilleros;
    }

    public void setCasillerosX(int casillerosX) {
        this.casillerosX = casillerosX;
    }

    public void setCasillerosY(int casillerosY) {
        this.casillerosY = casillerosY;
    }

    public void setColor1(String color1) {
        this.color1 = color1;
    }

    public void setColor2(String color2) {
        this.color2 = color2;
    }

    public void setCasilleros(ArrayList<Casillero> casilleros) {
        this.casilleros = casilleros;
    }

}
