package ClienteBuscaminas;

import ClienteBuscaminas.Controller.PartidaController;
import ClienteBuscaminas.View.TableroView;
import CommonBuscaminas.Model.usuarios.Usuario;
import CommonBuscaminas.Interfaces.IFacadeRemota;
import CommonBuscaminas.Model.partidas.Tablero;
import CommonBuscaminas.Model.usuarios.Jugador;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Daniel
 */
public class GestoraCliente {

    // INICIO SINGLETON
    private static GestoraCliente singleton;
    private IFacadeRemota facade;
    private Usuario myUsuario;

    protected GestoraCliente() {
    }

    public static GestoraCliente getInstance() {
        if (singleton == null) {
            return singleton = new GestoraCliente();
        }
        return singleton;
    }

    //FIN SINGLETON
    public IFacadeRemota getFacade() {
        return facade;
    }

    // 2.1 - ANTECESOR, GestoraCliente.nuevaPartida
    public void inicializarPartidaJugador(String idPartida) throws RemoteException {
        Tablero miTablero = GestoraCliente.getInstance().getFacade().obtenerTablero(idPartida);
        TableroView tableroView = new TableroView(miTablero);
        PartidaController partidaController = new PartidaController(tableroView, idPartida);
        tableroView.agregarMouseListener(partidaController);
        tableroView.setVisible(true);
//        unirseAPartida devuelve un Boolean
    }

    public void unirseAPartida(String idPartida, Jugador jugador) {
        try {
            inicializarPartidaJugador(idPartida);
            GestoraCliente.getInstance().getFacade().unirseAPartida(idPartida, (Jugador) GestoraCliente.getInstance().getMyUsuario());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // 1 NUEVA PARTIDA
    public void nuevaPartida(Jugador jugador, int x, int y, double apuesta) throws RemoteException {
        if (facade.chequearSaldoInicio(apuesta, jugador)) {
            String idPartida = GestoraCliente.getInstance().getFacade().nuevaPartida(jugador, x, y, apuesta);
            if (idPartida != null) {
                inicializarPartidaJugador(idPartida);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Saldo insuficiente");
        }

    }

    public boolean checkMedidasTablero(int casillerosX, int casillerosY) {
        if ((casillerosX * casillerosY) >= 9 && (casillerosX * casillerosY) <= 100) {
            return true;
        } else {
            return false;
        }
    }

    public void setFacade(IFacadeRemota facade) {
        this.facade = facade;
    }

    public Usuario getMyUsuario() {
        return myUsuario;
    }

    public void setMyUsuario(Usuario myUsuario) {
        this.myUsuario = myUsuario;
    }

}
