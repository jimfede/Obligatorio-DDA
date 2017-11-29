/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

/**
 *
 * @author Daniel
 */
public class UsuarioVO {

    private String nombreUsuario;
    private String clave;
    private String nombreCompleto;
    private String rol;
    private Double credito;
    private int usuarioId;

    public UsuarioVO(String nombreUsuario, String clave, String nombreCompleto, String rol, Double credito, int usuarioId) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.credito = credito;
        this.usuarioId = usuarioId;
    }

    
    
}
