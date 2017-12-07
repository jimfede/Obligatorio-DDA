/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.RMIServidor;

import ServidorBuscaminas.Fachada.FacadeRemota;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public class RmiServer {
    
    public static void RMIinit(int puerto){
        if (System.getSecurityManager() == null) {
            System.setSecurityManager(new RMISecurityManager());
        }
        try {
            FacadeRemota facade = new FacadeRemota();
            Naming.rebind("rmi://localhost:" + puerto + "/Fachada", facade);
        }
        catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            System.exit(1);
        }
        catch (Exception e) {
            System.err.println("Excepcion en RMIServer:");
            e.printStackTrace();
            System.exit(1);
        }
    }
    
}
