/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.apuestas.Apuesta;
import buscaminas.tablero.Tablero;
import buscaminas.tablero.Casillero;
import buscaminas.usuarios.Administrador;
import buscaminas.usuarios.Jugador;

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
        
        Jugador j1 = new Jugador("BB", "bb", "Babita Bernardotti");
        Jugador j2 = new Jugador("CD", "cd", "Chrysa Darridon");
        Jugador j3 = new Jugador("NR", "nr", "Nerty Raittie");
        Jugador j4 = new Jugador("KP", "kp", "Katerine Pigeram");
        Jugador j5 = new Jugador("LB", "lb", "Lindy Belamy");
        Jugador j6 = new Jugador("CC", "cc", "Carr Cordelet");
        Administrador adm1 = new Administrador("admin", "admin", "Stanton Tregunnah");

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
