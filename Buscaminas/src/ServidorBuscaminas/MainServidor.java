package ServidorBuscaminas;


import java.util.Scanner;

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

    public static void main(String[] args) {
        System.out.println("Servidor Iniciado, presiona una tecla para Terminar");
        String salida;
        Scanner scanInput = new Scanner(System.in);
        salida = scanInput.nextLine();
        scanInput.close();
    }
}
