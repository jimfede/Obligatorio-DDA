/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.usuarios.Jugador;
import buscaminas.usuarios.Sesion;
import buscaminas.usuarios.Usuario;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Federico
 */
public class ControladoraSingleton {

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Sesion> sesiones;
    private static ControladoraSingleton instance = null;

    protected ControladoraSingleton() {
        this.usuarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    public static ControladoraSingleton getInstance() {
        if (instance == null) {
            instance = new ControladoraSingleton();
        }
        return instance;
    }

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
}

//    public boolean cargarSaldo(Jugador Jugador, double monto) {
//        Usuario usuarioJugador = (Usuario) Jugador;
//        for (Usuario k : this.usuarios) {
//            if (k.equals(usuarioJugador)) {
//                Jugador.setCredito(Jugador.getCredito() + monto);
//                return true;
//            } else {
//                return false;
//            }
//        }
//        return false;
//    }

