/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClienteBuscaminas.RMI;


import ServidorBuscaminas.Interfaces.IFacadeRemota;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Daniel
 */
public class ClienteRMI {

    public static Remote obtenerConexionRMI(String Host, String puerto, String Objeto) {
        Util.setCodebase(IFacadeRemota.class);
        try {
            //Registry miRegistro = LocateRegistry.getRegistry();
           return Naming.lookup("//" + Host + ":" + puerto + "/" + Objeto);
           // return Naming.lookup(Objeto);
        } catch (RemoteException e) {
            System.err.println("Error de comunicacion: " + e.toString());
            return null;
        } catch (Exception e) {
            System.err.println("Excepcion en:");
            e.printStackTrace();
            return null;
        }
    }
}
