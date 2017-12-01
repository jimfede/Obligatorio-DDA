/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminascliente.Controller;

import Model.mensajes.Mensaje;
import buscaminascliente.Interfaces.IObservadorRemoto;
import buscaminascliente.Interfaces.IPartidaRemota;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Federico
 */
public class AdaptadorPartidaController extends UnicastRemoteObject implements IObservadorRemoto{

    private PartidaController pcontroller;
    private IPartidaRemota partida;

    
    public AdaptadorPartidaController(PartidaController pc) throws RemoteException{
        this.pcontroller = pc;
        this.partida.agregarObservador(this);
    }
    
    @Override
    public void update(IPartidaRemota fachada, Object aux) throws RemoteException {
        pcontroller.procesarMensajeTablero(aux);
    }

    
}
