/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.Controller;


import CommonBuscaminas.Interfaces.IObservadorRemoto;
import java.io.Serializable;
import java.rmi.RemoteException;

/**
 *
 * @author Federico
 */
public class AdaptadorPartidaController implements IObservadorRemoto, Serializable{

    private final PartidaController partidaControler;
    
    public AdaptadorPartidaController(PartidaController partidaCon) throws RemoteException{
        this.partidaControler = partidaCon;
    }
    
    @Override
    public void update(Object aux) throws RemoteException {
        partidaControler.procesarMensajeTablero(aux);
    }    
}
