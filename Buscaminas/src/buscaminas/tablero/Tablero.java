/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.tablero;

import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class Tablero {

    private int casillerosX;
    private int casillerosY;
    private String color1;
    private String color2;
    private ArrayList<Casillero> casilleros = new ArrayList<>();

    public Tablero(int casillerosX, int casillerosY) {
        this.casillerosX = casillerosX;
        this.casillerosY = casillerosY;
        int i = 1;
        int j = 1;
        while (i <= casillerosX) {
            while (j <= casillerosY) {
                Casillero casillero = new Casillero(i, j);
                this.casilleros.add(casillero);
                j++;
            }
            j = 1;
            i++;
        }
        insertarMina();
    }

    public boolean checkMedidasTablero(int casillerosX, int casillerosY) {
        if (casillerosX * casillerosY >= 9 || casillerosX * casillerosY <= 100) {
            return true;
        } else {
            return false;
        }
    }

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
