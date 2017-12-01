/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Model.partidas.Partida;
import Model.usuarios.Jugador;
import Model.usuarios.Sesion;
import Model.usuarios.Usuario;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class GestoraBuscaminas {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Sesion> sesiones;
    private ArrayList<Partida> partidas;

    public GestoraBuscaminas() {
        this.usuarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    /**
     * Inicia la sesion de un usuario, para un Nombre de Usuario y una Clave
     * dada siempre que exista en el sistema o este no esté ya logeado
     *
     * @param nombreUsuario Nombre del usuario a logear
     * @param clave Clave del usuario a logear
     */
    public void iniciarSesion(String nombreUsuario, String clave) {
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
    public boolean sesionIniciada(String nombreUsuario) {
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

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Sesion> getSesiones() {
        return sesiones;
    }

    public ArrayList<Partida> getPartidas() {
        return partidas;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        this.sesiones = sesiones;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        this.partidas = partidas;
    }

}
