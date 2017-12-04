/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.mensajes.Mensaje;
import Interfaces.IObservadorRemoto;
import Interfaces.IPartidaRemota;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Federico
 */
public class AdaptadorPartidaController extends UnicastRemoteObject implements IObservadorRemoto{

    private PartidaController partidaControler;
    
    public AdaptadorPartidaController(PartidaController pc) throws RemoteException{
        this.partidaControler = pc;
    }
    
    @Override
    public void update(IPartidaRemota fachada, Object aux) throws RemoteException {
        partidaControler.procesarMensajeTablero(aux);
    }

    
}
