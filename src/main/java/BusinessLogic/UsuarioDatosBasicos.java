/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.util.Date;

/**
 *
 * @author Juan Cubillos
 */

// Implementacion concepto herencia: Clase hija, JSCG, UNAD, 20190703

public class UsuarioDatosBasicos extends PersonaDatosBasicos {

    private Integer idUsuario;
    private String usuario;
    private Boolean bloqueado;

    // Implementacion concepto herencia: Método constructor, JSCG, UNAD, 20190703
    
    public UsuarioDatosBasicos(Integer idPersona, String nombre, String apellido, Integer edad, Date fechaNacimiento, String identificacion, Integer idUsuario, String usuario, Boolean bloqueado) {
        // Implementacion concepto herencia: Implementación, JSCG, UNAD, 20190703
        super(idPersona, nombre, apellido, edad, fechaNacimiento, identificacion);
        this.idUsuario = idUsuario;
        this.usuario = usuario;
        this.bloqueado = bloqueado;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Boolean getBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(Boolean bloqueado) {
        this.bloqueado = bloqueado;
    }
}
