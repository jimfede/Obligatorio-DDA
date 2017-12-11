package ServidorBuscaminas;

import ServidorBuscaminas.Fachada.FacadeRemota;
import CommonBuscaminas.Model.usuarios.Jugador;
import CommonBuscaminas.Model.usuarios.Usuario;
import ServidorBuscaminas.RMIServidor.RmiServer;
import java.io.IOException;
import java.rmi.NoSuchObjectException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

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

//Zona de pruebas

GestoraSingleton.getInstance().nuevoJugador("Daniel", "123", "Daniel Cisa");
GestoraSingleton.getInstance().nuevoJugador("Federico", "321", "Federico Castrillon");
GestoraSingleton.getInstance().nuevoAdministrador("Jorge", "123", "Jorgito");

//FIN zona de pruebas
        try {
            System.in.read();
        } catch (IOException ex) {
        }

        UnicastRemoteObject.unexportObject(mifacade, true);
    }
}
