/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RMI;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Daniel
 */
public class ClienteRMI {

    public static Object obtenerConexionRMI(String Host, String puerto, String Objeto) {
        try {
            return (Object) Naming.lookup("//" + Host + ":" + puerto + "/" + Objeto);
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
