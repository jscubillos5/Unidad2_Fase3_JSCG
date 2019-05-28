/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JPA;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juan Cubillos
 */
@Entity
@Table(name = "detalle_factura", catalog = "unidad_2_fase_3_301403_2_jscg", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFactura.findAll", query = "SELECT d FROM DetalleFactura d"),
    @NamedQuery(name = "DetalleFactura.findByIdDetalleFactura", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.idDetalleFactura = :idDetalleFactura"),
    @NamedQuery(name = "DetalleFactura.findByIdFactura", query = "SELECT d FROM DetalleFactura d WHERE d.detalleFacturaPK.idFactura = :idFactura"),
    @NamedQuery(name = "DetalleFactura.findByDescripcionProducto", query = "SELECT d FROM DetalleFactura d WHERE d.descripcionProducto = :descripcionProducto"),
    @NamedQuery(name = "DetalleFactura.findByValorUnitario", query = "SELECT d FROM DetalleFactura d WHERE d.valorUnitario = :valorUnitario")})
public class DetalleFactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFacturaPK detalleFacturaPK;
    @Basic(optional = false)
    @Column(name = "descripcion_producto", nullable = false, length = 100)
    private String descripcionProducto;
    @Basic(optional = false)
    @Column(name = "valor_unitario", nullable = false)
    private double valorUnitario;
    @JoinColumn(name = "id_factura", referencedColumnName = "id_factura", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Factura factura;

    public DetalleFactura() {
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public DetalleFactura(DetalleFacturaPK detalleFacturaPK, String descripcionProducto, double valorUnitario) {
        this.detalleFacturaPK = detalleFacturaPK;
        this.descripcionProducto = descripcionProducto;
        this.valorUnitario = valorUnitario;
    }

    public DetalleFactura(int idDetalleFactura, int idFactura) {
        this.detalleFacturaPK = new DetalleFacturaPK(idDetalleFactura, idFactura);
    }

    public DetalleFacturaPK getDetalleFacturaPK() {
        return detalleFacturaPK;
    }

    public void setDetalleFacturaPK(DetalleFacturaPK detalleFacturaPK) {
        this.detalleFacturaPK = detalleFacturaPK;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Factura getFactura() {
        return factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleFacturaPK != null ? detalleFacturaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFactura)) {
            return false;
        }
        DetalleFactura other = (DetalleFactura) object;
        if ((this.detalleFacturaPK == null && other.detalleFacturaPK != null) || (this.detalleFacturaPK != null && !this.detalleFacturaPK.equals(other.detalleFacturaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JPA.DetalleFactura[ detalleFacturaPK=" + detalleFacturaPK + " ]";
    }
    
}
