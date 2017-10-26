/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.apuestas.Apuesta;
import buscaminas.tablero.Tablero;
import buscaminas.tablero.Casillero;
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
        
        ControladoraSingleton.getInstance();
        
        jugador j1 = new jugador("BB", "bb", "Babita Bernardotti");
        jugador j2 = new jugador("CD", "cd", "Chrysa Darridon");
        jugador j3 = new jugador("NR", "nr", "Nerty Raittie");
        jugador j4 = new jugador("KP", "kp", "Katerine Pigeram");
        jugador j5 = new jugador("LB", "lb", "Lindy Belamy");
        jugador j6 = new jugador("CC", "cc", "Carr Cordelet");
        administrador adm1 = new administrador("admin", "admin", "Stanton Tregunnah");

        //PRUEBAS
        //para probar partida inicial
        Partida primeraPartida = new Partida(j1, new Tablero(3, 3), new Apuesta(j1, 500));
        //prueba de detalles de partida
        System.out.print("JUGADOR 1: " + primeraPartida.getJugador1().getNombreCompleto() + " - ");
        System.out.println("POZO: " + primeraPartida.getPozo().totalPozo());
        //para ver tablero con bombas
        for (Casillero k : primeraPartida.getTablero().getCasilleros()) {
            if (k.getMina() != null) {
                System.out.print("KBoom en ");
            }
            System.out.println(k);
        }

    }

}
