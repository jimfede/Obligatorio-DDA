/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.RMIServidor;

/**
 *
 * @author dcisa
 */
public class Util {
    
    private static final String CODEBASE = "java.rmi.server.codebase";
    
    public static void setCodebase(Class<?> c){
        String ruta = c.getProtectionDomain().getCodeSource().getLocation().toString();
        
        String path = System.getProperty(CODEBASE);
        
        if (path != null && !path.isEmpty()) {
            ruta = path + " " + ruta;
        }
        
        System.setProperty(CODEBASE, ruta);
    }
    
}
