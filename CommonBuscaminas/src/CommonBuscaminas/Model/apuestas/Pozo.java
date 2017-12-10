/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommonBuscaminas.Model.apuestas;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Federico
 */
public class Pozo implements Serializable{

    private ArrayList<Apuesta> Apuestas;

    public void recibirApuesta(Apuesta apuesta) {
        this.Apuestas = new ArrayList<>();
        this.Apuestas.add(apuesta);
    }

    public double totalPozo() {
        double totalPozo = 0.0;
        for (Apuesta i : Apuestas) {
            totalPozo = totalPozo + i.getMonto();
        }
        return totalPozo;
    }

    public ArrayList<Apuesta> getApuestas() {
        return Apuestas;
    }

}
