/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.rmi.RemoteException;

/**
 *
 * @author Federico
 */
public interface IObservadorRemoto {

    /**
     * Actualiza el estado de un observador, pasandole como argumento un objeto.
     * @param aux
     * @throws RemoteException 
     */
    public void update(Object aux) throws RemoteException;

}
