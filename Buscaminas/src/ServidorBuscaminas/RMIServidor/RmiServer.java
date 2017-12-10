/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.RMIServidor;

import ServidorBuscaminas.Fachada.FacadeRemota;
import CommonBuscaminas.Interfaces.IFacadeRemota;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Daniel
 */
public class RmiServer {

    public static FacadeRemota RMIinit() {
        
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        
        Util.setCodebase(IFacadeRemota.class);
        Registry registroRMI = null;
        FacadeRemota miFachada = new FacadeRemota();

        try {
            IFacadeRemota ifacade = (IFacadeRemota) UnicastRemoteObject.exportObject(miFachada, 1099);
            registroRMI = LocateRegistry.createRegistry(1099);
            registroRMI.rebind("Fachada", ifacade);
            return miFachada;
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            try {
                UnicastRemoteObject.unexportObject(registroRMI, true);
            } catch (Exception e2) {
            }
            System.exit(0);
        } catch (Exception e) {
            System.err.println("Excepcion en RMIServer:");
            e.printStackTrace();
            try {
                UnicastRemoteObject.unexportObject(registroRMI, true);
            } catch (Exception e2) {
            }
            System.exit(0);
        }
        return miFachada;
    }

}
