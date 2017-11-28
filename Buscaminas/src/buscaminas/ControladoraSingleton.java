/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.partidas.Partida;
import buscaminas.usuarios.Jugador;
import buscaminas.usuarios.Sesion;
import buscaminas.usuarios.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class ControladoraSingleton {

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Sesion> sesiones;
    private static ArrayList<Partida> partidas;
    private static ControladoraSingleton instance = null;

    /**
     * (Singleton) Constructor de ControladoraSingleton
     */
    protected ControladoraSingleton() {
        this.usuarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    /**
     * Devuelve la actual instancia Singleton, o crea una nueva, de
     * ControladoraSingleton
     *
     * @return Instancia de ControladoraSingleton
     */
    public static ControladoraSingleton getInstance() {
        if (instance == null) {
            instance = new ControladoraSingleton();
        }
        return instance;
    }

    /**
     * Inicia la sesion de un usuario, para un Nombre de Usuario y una Clave
     * dada siempre que exista en el sistema o este no esté ya logeado
     *
     * @param nombreUsuario Nombre del usuario a logear
     * @param clave Clave del usuario a logear
     */
    public static void iniciarSesion(String nombreUsuario, String clave) {
        if (!sesionIniciada(nombreUsuario)) {
            for (Usuario u : usuarios) {
                if (u.getNombreUsuario() == nombreUsuario && u.getClave() == clave) {
                    sesiones.add(new Sesion(u));
                    u.setSesioniniciada(true);
                }
            }
        }
    }

    /**
     * Verifica que el usuario (nombreUsuario) no esté ya logeado en el sistema
     *
     * @param nombreUsuario Nombre del usuario a verificar
     * @return True si el usuario ya está logeado | False sinó
     */
    public static boolean sesionIniciada(String nombreUsuario) {
        for (Sesion s : sesiones) {
            if (s.getSesionUsuario().getNombreUsuario() == nombreUsuario && !s.getSesionUsuario().isSesioniniciada()) {
                return true;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean cargarSaldo(Jugador Jugador, double monto) {
        Usuario usuarioJugador = (Usuario) Jugador;
        for (Usuario k : this.usuarios) {
            if (k.equals(usuarioJugador)) {
                Jugador.setCredito(Jugador.getCredito() + monto);
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public static ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public static ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public static void setUsuarios(ArrayList<Usuario> usuarios) {
        ControladoraSingleton.usuarios = usuarios;
    }

    public static void setSesiones(ArrayList<Sesion> sesiones) {
        ControladoraSingleton.sesiones = sesiones;
    }

    public static void setPartidas(ArrayList<Partida> partidas) {
        ControladoraSingleton.partidas = partidas;
    }

}
