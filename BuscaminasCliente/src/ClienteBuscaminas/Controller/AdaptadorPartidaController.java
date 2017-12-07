/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;

import ClienteBuscaminas.Interfaces.IObservadorRemoto;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Federico
 */
public class AdaptadorPartidaController extends UnicastRemoteObject implements IObservadorRemoto{

    private final PartidaController partidaControler;
    
    public AdaptadorPartidaController(PartidaController pc) throws RemoteException{
        this.partidaControler = pc;
    }
    
    @Override
    public void update(Object aux) throws RemoteException {
        partidaControler.procesarMensajeTablero(aux);
    }

    
}
