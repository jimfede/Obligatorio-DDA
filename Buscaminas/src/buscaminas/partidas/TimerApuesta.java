/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas.partidas;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Federico
 */
public class TimerApuesta {

    private Timer timer = new Timer("CuentaRegresivaApuesta");

    public TimerApuesta(long miliSegundos) {
        this.timer.schedule(tiempoCumplido, miliSegundos);
    }

    private TimerTask tiempoCumplido = new TimerTask() {
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName());
            timer.cancel();
        }
    };
    
    public void cancelarTimerApuesta(){
        this.timer.cancel();
    }

    public Timer getTimer() {
        return timer;
    }

    public TimerTask getTiempoCumplido() {
        return tiempoCumplido;
    }

}
