/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Daniel
 */
public class UsuarioDAO {

    private Connection DB;

    public boolean crearUsuario(UsuarioVO user) {
        throw new NotImplementedException();
    }

    public UsuarioVO leerUsuario(String nombreUsuario) {
        throw new NotImplementedException();
    }

    public boolean actualizarUsuario(int ID, UsuarioVO user) {
        throw new NotImplementedException();
    }

    public boolean eliminarUsuario(int ID) {
        throw new NotImplementedException();
    }

    public boolean cargarSaldo(int ID, float monto) {
        throw new NotImplementedException();
    }

}
