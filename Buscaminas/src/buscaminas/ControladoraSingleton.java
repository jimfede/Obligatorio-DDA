/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import buscaminas.usuarios.jugador;
import buscaminas.usuarios.usuario;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class ControladoraSingleton {

    private static ArrayList<usuario> usuarios;

    private static ControladoraSingleton instance = null;

    protected ControladoraSingleton() {
        this.usuarios = new ArrayList<>();
    }

    public static ControladoraSingleton getInstance() {
        if (instance == null) {
            instance = new ControladoraSingleton();
        }
        return instance;
    }

    public void actualizarSaldo(jugador apostador, double monto) {
        apostador.setCredito(apostador.getCredito() - monto);
    }

    public ArrayList<usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<usuario> usuarios) {
        this.usuarios = usuarios;
    }

}
