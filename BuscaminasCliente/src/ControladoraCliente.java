
import Interfaces.IFacadeRemota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Daniel
 */
public class ControladoraCliente {

    // INICIO SINGLETON
    
    private static ControladoraCliente singleton;
    private IFacadeRemota facade;

    protected ControladoraCliente() {
    }

    public static ControladoraCliente getInstance() {
        if (singleton == null) {
            return singleton = new ControladoraCliente();
        }
        return singleton;
    }
    
    //FIN SINGLETON

    public IFacadeRemota getFacade() {
        return facade;
    }

    public void setFacade(IFacadeRemota facade) {
        this.facade = facade;
    }
    
    
    
}
