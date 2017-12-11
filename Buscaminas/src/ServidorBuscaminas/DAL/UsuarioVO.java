/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServidorBuscaminas.DAL;

/**
 *
 * @author Daniel
 */
public class UsuarioVO {

    private String nombreUsuario;
    private String clave;
    private String nombreCompleto;
    private String rol;
    private double credito;
    private int usuarioId;

    public UsuarioVO(String nombreUsuario, String clave, String nombreCompleto, String rol, double credito, int usuarioId) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.credito = credito;
        this.usuarioId = usuarioId;
    }

    public UsuarioVO(String nombreUsuario, String clave, String nombreCompleto, String rol, double credito) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.credito = credito;
    }

    public UsuarioVO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    
    
}
