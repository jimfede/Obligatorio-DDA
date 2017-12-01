/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminascliente.Interfaces;

import java.rmi.RemoteException;

/**
 *
 * @author Federico
 */
public interface IObservadorRemoto {

    public void update(IPartidaRemota fachada, Object aux) throws RemoteException;

}
