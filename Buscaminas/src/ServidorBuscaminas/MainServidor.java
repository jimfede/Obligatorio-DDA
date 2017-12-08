package ServidorBuscaminas;

import ServidorBuscaminas.Fachada.FacadeRemota;
import ServidorBuscaminas.Interfaces.IFacadeRemota;
import ServidorBuscaminas.RMIServidor.RmiServer;
import ServidorBuscaminas.RMIServidor.Util;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.NoSuchObjectException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Federico
 */
public class MainServidor {

    public static void main(String[] args) throws NoSuchObjectException {
        FacadeRemota mifacade = RmiServer.RMIinit();

        System.out.println("Servidor Iniciado! presiona una tecla para Terminar");
        
        try {
            System.in.read();
        } catch (IOException ex) {
        }
        
        UnicastRemoteObject.unexportObject(mifacade, true);
    }
}
