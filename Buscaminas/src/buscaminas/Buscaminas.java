/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.usuarios.administrador;
import buscaminas.usuarios.jugador;

/**
 *
 * @author Federico
 */
public class Buscaminas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        jugador j1 = new jugador("BB", "bb", "Babita Bernardotti");
        jugador j2 = new jugador("CD", "cd", "Chrysa Darridon");
        jugador j3 = new jugador("NR", "nr", "Nerty Raittie");
        jugador j4 = new jugador("KP", "kp", "Katerine Pigeram");
        jugador j5 = new jugador("LB", "lb", "Lindy Belamy");
        jugador j6 = new jugador("CC", "cc", "Carr Cordelet");

        administrador adm1 = new administrador("admin", "admin", "Stanton Tregunnah");

        Partida primeraPartida = new Partida(j1, new Tablero(3, 3));

        //PRUEBAS
        for (Casillero k : primeraPartida.getTablero().getCasilleros()) {
            if (k.getMina() != null) {
                System.out.println("KBoom en " + k.getCoordenadaX() + " " + k.getCoordenadaY());
            }
            System.out.println(k);
        }

    }

}
