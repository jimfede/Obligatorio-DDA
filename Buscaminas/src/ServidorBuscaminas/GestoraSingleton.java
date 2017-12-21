/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas;

import CommonBuscaminas.Model.partidas.Partida;
import CommonBuscaminas.Model.usuarios.Administrador;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Sesion;
import CommonBuscaminas.Model.usuarios.Usuario;
import CommonBuscaminas.Model.usuarios.Usuario.rol;
import ServidorBuscaminas.DAL.DB;
import ServidorBuscaminas.DAL.UsuarioDAO;
import ServidorBuscaminas.DAL.UsuarioVO;
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
    protected final DB myDb = new DB("localhost", "3306", "buscaminas", "root", "");

    /**
     * (Singleton) Constructor de ControladoraSingleton
     */
    protected GestoraSingleton() {
        usuarios = new ArrayList<>();
        sesiones = new ArrayList<>();
        partidas = new ArrayList<>();
    }

    /**
     * Devuelve la actual instancia Singleton, o crea una nueva, de
     * GestoraBuscaminas
     *
     * @return Instancia de GestoraBuscaminas
     */
    public static GestoraSingleton getInstance() {
        if (instance == null) {
            instance = new GestoraSingleton();
        }
        return instance;
    }

    public Partida obtenerPartida(String id) {
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
        UsuarioDAO usrDao = new UsuarioDAO(myDb);

        if (!sesionIniciada(nombreUsuario)) {
            UsuarioVO vo = usrDao.leerUsuario(nombreUsuario);
            if (vo != null) {
                if (vo.getRol().equals(Usuario.rol.jugador.toString())) {
                    Jugador miJ = new Jugador(vo.getNombreUsuario(), vo.getClave(), vo.getNombreCompleto());
                    miJ.setCredito(vo.getCredito());
                    miJ.setRolUsuario(rol.jugador);
                    miUser = (Usuario) miJ;
                } else {
                    Administrador miA = new Administrador(vo.getNombreUsuario(), vo.getClave(), vo.getNombreCompleto());
                    miA.setRolUsuario(rol.administrador);
                    miUser = (Usuario) miA;
                }
            }
        }

        if (miUser != null) {
            sesiones.add(new Sesion(miUser));
        }

        return miUser;
    }

    public boolean nuevoJugador(String nombreUsuario, String clave, String nombreCompleto) {
        return new UsuarioDAO(myDb).crearUsuario(new UsuarioVO(nombreUsuario, clave, nombreCompleto, rol.jugador.toString(), 0));
    }

    public boolean nuevoAdministrador(String nombreUsuario, String clave, String nombreCompleto) {
        return new UsuarioDAO(myDb).crearUsuario(new UsuarioVO(nombreUsuario, clave, nombreCompleto, rol.administrador.toString(), 0));
    }

    /**
     * Verifica que el usuario (nombreUsuario) no esté ya logeado en el sistema
     *
     * @param nombreUsuario Nombre del usuario a verificar
     * @return True si el usuario ya está logeado | False sinó
     */
    public boolean sesionIniciada(String nombreUsuario) {
        for (Sesion s : sesiones) {
            if (s.getSesionUsuario().getNombreUsuario().equals(nombreUsuario) && !s.getSesionUsuario().isSesioniniciada()) {
                return true;
            }
        }
        return false;
    }

    public void cerrarSesion(String nombreUsuario) {
        if (sesionIniciada(nombreUsuario)) {
            for (Sesion s : sesiones) {
                if (s.getSesionUsuario().getNombreUsuario().equals(nombreUsuario)) {
                    sesiones.remove(s);
                    //Busco una partida ya iniciada por el usuario. Si existe, 
                    //elimina de la partida al jugador y la partida actualiza su estado, dejando ganar al otro jugador
                    BuscarPartidaAbandonada(nombreUsuario);
                    break;
                }
            }
        }
    }

    public void BuscarPartidaAbandonada(String nombreUsuario) {
        for (Partida partida : partidas) {
            if (!partida.isPartidaIniciada() && partida.getJugador1().getNombreUsuario().equals(nombreUsuario)) {
                partidas.remove(partida);
                break;
            }
        }
    }

    public boolean cargarSaldo(Jugador Jugador, double monto) {
        return new UsuarioDAO(myDb).cargarSaldo(Jugador.getIdUsuario(), monto);
    }

    //2 ANTECESOR, GestoraCliente.nuevaPartida
    public Partida nuevaPartida(Jugador player, int x, int y, double aInicial) {
        if (true) {

        }
        Partida nuevaPartida = new Partida(player, x, y, aInicial);
        this.partidas.add(nuevaPartida);
        return nuevaPartida;
    }

    public String buscarPartidaNoIniciada(Jugador jugador) {
        for (Partida partida : partidas) {
            if (!partida.isPartidaIniciada() && partida.saldoSuficiente(jugador, partida.getApuestaInicial())) {
                return partida.getIdPartida();
            }
        }
        return null;
    }

    //3 ANTECESOR, GestoraCliente.inicializarPartida
    public boolean unirseAPartida(String idPartida, Jugador jugador) {
        Partida miPartida = obtenerPartida(idPartida);
        if (miPartida != null) {
            miPartida.setJugador2(jugador);
            miPartida.setTurnoJugador(jugador);
            miPartida.comenzarPartida();
            return true;
        }
        return false;
    }

    public boolean chequearSaldoInicio(double monto, Jugador jugador) {
        return jugador.getCredito() >= monto;
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
        GestoraSingleton.usuarios = usuarios;
    }

    public void setSesiones(ArrayList<Sesion> sesiones) {
        GestoraSingleton.sesiones = sesiones;
    }

    public void setPartidas(ArrayList<Partida> partidas) {
        GestoraSingleton.partidas = partidas;
    }

}
