/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.Model;

import ServidorBuscaminas.Model.apuestas.Apuesta;
import ServidorBuscaminas.Model.partidas.Partida;
import ServidorBuscaminas.Model.usuarios.Jugador;
import ServidorBuscaminas.Model.usuarios.Sesion;
import ServidorBuscaminas.Model.usuarios.Usuario;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class GestoraSingleton {

    private static ArrayList<Usuario> usuarios;
    private static ArrayList<Sesion> sesiones;
    private static ArrayList<Partida> partidas;
    private static GestoraSingleton instance = null;

    /**
     * (Singleton) Constructor de ControladoraSingleton
     */
    protected GestoraSingleton() {
        this.usuarios = new ArrayList<>();
        this.sesiones = new ArrayList<>();
    }

    /**
     * Devuelve la actual instancia Singleton, o crea una nueva, de
 GestoraBuscaminas
     *
     * @return Instancia de GestoraBuscaminas
     */
    public static GestoraSingleton getInstance() {
        if (instance == null) {
            instance = new GestoraSingleton();
        }
        return instance;
    }

    public Partida obtenerPartida(String id){
        for (Partida par : partidas) {
            if (par.getIdPartida().equals(id)) {
                return par;
            }
        }
        return null;
    }
    
    /**
     * Inicia la sesion de un usuario, para un Nombre de Usuario y una Clave
     * dada siempre que exista en el sistema o este no esté ya logeado
     *
     * @param nombreUsuario Nombre del usuario a logear
     * @param clave Clave del usuario a logear
     * @return Usuario || null
     */
    public Usuario iniciarSesion(String nombreUsuario, String clave) {
        Usuario miUser = null;
        if (!sesionIniciada(nombreUsuario)) {
            for (Usuario u : usuarios) {
                if (u.getNombreUsuario() == nombreUsuario && u.getClave() == clave) {
                    miUser = u;
                    sesiones.add(new Sesion(u));
                    u.setSesioniniciada(true);
                }
            }
        }
        return miUser;
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
    
    public void cerrarSesion(String nombreUsuario){
        if (sesionIniciada(nombreUsuario)) {
            for (Sesion s : sesiones) {
                if (s.getSesionUsuario().getNombreUsuario().equals(nombreUsuario)) {
                    sesiones.remove(s);
                    return;
                }
            }
        }
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
    
    public Partida nuevaPartida(Jugador player, int x, int y, Apuesta aInicial){
        Partida nuevaPartida;
        try{
        nuevaPartida = new Partida(player, x, y, aInicial);
        }catch(RemoteException e){
            e.printStackTrace();
            return null;
        }
        partidas.add(nuevaPartida);
        return nuevaPartida;
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
        GestoraSingleton.usuarios = usuarios;
    }

    public static void setSesiones(ArrayList<Sesion> sesiones) {
        GestoraSingleton.sesiones = sesiones;
    }

    public static void setPartidas(ArrayList<Partida> partidas) {
        GestoraSingleton.partidas = partidas;
    }

}
