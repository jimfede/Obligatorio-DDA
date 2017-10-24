package buscaminas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Federico
 */
public class RolSingleton {

    private static String rolAdministrador;
    private static String rolJugador;
    
    private static RolSingleton instance = null;

    protected RolSingleton() {
        this.rolAdministrador = "Administrador";
        this.rolJugador = "Jugador";
    }

    public static RolSingleton getInstance() {
        if (instance == null) {
            instance = new RolSingleton();
        }
        return instance;
    }

    public String getRolAdministrador() {
        return rolAdministrador;
    }

    public String getRolJugador() {
        return rolJugador;
    }

}
