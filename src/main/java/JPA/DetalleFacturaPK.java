/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Juan Cubillos
 */
@Embeddable
public class DetalleFacturaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "id_detalle_factura", nullable = false)
    private int idDetalleFactura;
    @Basic(optional = false)
    @Column(name = "id_factura", nullable = false)
    private int idFactura;

    public DetalleFacturaPK() {
    }

    public DetalleFacturaPK(int idDetalleFactura, int idFactura) {
        this.idDetalleFactura = idDetalleFactura;
        this.idFactura = idFactura;
    }

    public int getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(int idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDetalleFactura;
        hash += (int) idFactura;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaPK)) {
            return false;
        }
        DetalleFacturaPK other = (DetalleFacturaPK) object;
        if (this.idDetalleFactura != other.idDetalleFactura) {
            return false;
        }
        if (this.idFactura != other.idFactura) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.DetalleFacturaPK[ idDetalleFactura=" + idDetalleFactura + ", idFactura=" + idFactura + " ]";
    }
    
}
