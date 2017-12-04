/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Model.mensajes.Mensaje;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Federico
 */
public interface IPartidaRemota extends Remote {

    public void agregarObservador(IObservadorRemoto observer) throws RemoteException;

    public void procesarMensajePartida(Mensaje mensaje) throws RemoteException;

    public Object getTableroRemote() throws RemoteException;
}
