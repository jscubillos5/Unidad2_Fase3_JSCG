/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Juan Cubillos
 */
@Entity
@Table(name = "tipo_persona", catalog = "unidad_2_fase_3_301403_2_jscg", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersona.findAll", query = "SELECT t FROM TipoPersona t"),
    @NamedQuery(name = "TipoPersona.findByIdTipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.idTipoPersona = :idTipoPersona"),
    @NamedQuery(name = "TipoPersona.findByDescripcion", query = "SELECT t FROM TipoPersona t WHERE t.descripcion = :descripcion")})
public class TipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PERSONA", nullable = false)
    private Integer idTipoPersona;
    @Column(length = 20)
    private String descripcion;
    @OneToMany(mappedBy = "idTipoPersona")
    private Collection<Persona> personaCollection;

    public TipoPersona() {
    }

    public TipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public Integer getIdTipoPersona() {
        return idTipoPersona;
    }

    public void setIdTipoPersona(Integer idTipoPersona) {
        this.idTipoPersona = idTipoPersona;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPersona != null ? idTipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.idTipoPersona == null && other.idTipoPersona != null) || (this.idTipoPersona != null && !this.idTipoPersona.equals(other.idTipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.TipoPersona[ idTipoPersona=" + idTipoPersona + " ]";
    }
    
}
