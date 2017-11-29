/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.partidas;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Federico
 */
public class TimerApuesta {

    //Propiedad de tipo Timer, con nombre del Thread (Hilo) asociado
    private Timer timer = new Timer("CuentaRegresivaApuesta");

    /**
     * Constructor. Crea una nueva instancia de TimerApuesta, con la tarea a
     * ejecutar (tiempoCumplido) cuando se acabo el tiempo (miliSegundos)
     *
     * @param miliSegundos
     */
    public TimerApuesta(long miliSegundos) {
        this.timer.schedule(tiempoCumplido, miliSegundos);
    }

    /**
     * Tarea a ser ejecutada cuando se termina el tiempo (Timer)
     */
    private TimerTask tiempoCumplido = new TimerTask() {
        @Override
        public void run() {
            //se supone que aca tengo que llamar al metodo de terminar partida, aun no se como.
            System.out.println("Thread " + Thread.currentThread().getName());
            timer.cancel();
        }
    };

    /**
     * Cancela el Timer actual
     */
    public void cancelarTimerApuesta() {
        this.timer.cancel();
    }

    /**
     * Devuelve el Timer actual
     *
     * @return Timer
     */
    public Timer getTimer() {
        return timer;
    }

    /**
     * Devuelve la tarea a realizar
     *
     * @return TimerTask
     */
    public TimerTask getTiempoCumplido() {
        return tiempoCumplido;
    }

}
