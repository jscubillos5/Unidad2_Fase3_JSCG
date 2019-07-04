package BusinessLogic;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juan Cubillos
 */

// Implementacion concepto herencia: Clase padre, JSCG, UNAD, 20190703

public class PersonaDatosBasicos implements Serializable {

    private Integer idPersona;
    private String nombre;
    private String apellido;
    private Integer edad;
    private Date fechaNacimiento;
    private String identificacion;

    public PersonaDatosBasicos(Integer idPersona, String nombre, String apellido, Integer edad, Date fechaNacimiento, String identificacion) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
