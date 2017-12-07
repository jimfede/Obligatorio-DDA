package ClienteBuscaminas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import ClienteBuscaminas.Interfaces.IFacadeRemota;
import ClienteBuscaminas.RMI.ClienteRMI;
import ClienteBuscaminas.View.Principal;
import javax.swing.JOptionPane;

/**
 *
 * @author Federico
 */
public class MainCliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IFacadeRemota fachada = (IFacadeRemota) ClienteRMI.obtenerConexionRMI("localhost", "1099", "Fachada");
        if (fachada != null) {
            System.out.println("Conexión satisfactoria");
            ControladoraCliente.getInstance().setFacade(fachada);
        } else {
            System.err.println("No se pudo realizar la conexión con el Servidor de RMI");
            JOptionPane.showMessageDialog(null, "No se pudo establecer comunicacion con el servidor remoto");
            System.exit(0);
        }
        new Principal().setVisible(true);
    }
    
}
