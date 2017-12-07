package ClienteBuscaminas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ClienteBuscaminas.Interfaces.IFacadeRemota;
import ClienteBuscaminas.RMI.ClienteRMI;
import ClienteBuscaminas.View.Principal;

/**
 *
 * @author Federico
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Principal().setVisible(true);
        IFacadeRemota fachada = (IFacadeRemota) ClienteRMI.obtenerConexionRMI("localhost", "1099", "Fachada");
        if (fachada != null) {
            System.out.println("Conexión satisfactoria");
            ControladoraCliente.getInstance().setFacade(fachada);
        } else {
            System.err.println("No se pudo realizar la conexión con el Servidor de RMI");
        }
    }
    
}
