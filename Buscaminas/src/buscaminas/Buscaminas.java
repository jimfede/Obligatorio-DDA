/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

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

        jugador nuevoJugador = new jugador();
        administrador nuevoAdministrador = new administrador();
        System.out.println(nuevoJugador.getRolUsuario());
        System.out.println(nuevoAdministrador.getRolUsuario());

    }

}
