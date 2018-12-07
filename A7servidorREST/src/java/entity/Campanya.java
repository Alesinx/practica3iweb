/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author JaGaRo
 */
@Entity
@Table(name = "CAMPANYA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Campanya.findAll", query = "SELECT c FROM Campanya c")
    , @NamedQuery(name = "Campanya.findByIdcampanya", query = "SELECT c FROM Campanya c WHERE c.idcampanya = :idcampanya")
    , @NamedQuery(name = "Campanya.findByFecha", query = "SELECT c FROM Campanya c WHERE c.fecha = :fecha")
    , @NamedQuery(name = "Campanya.findByNombrecampanya", query = "SELECT c FROM Campanya c WHERE c.nombrecampanya = :nombrecampanya")})
public class Campanya implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCAMPANYA")
    private Integer idcampanya;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 20)
    @Column(name = "NOMBRECAMPANYA")
    private String nombrecampanya;
    @JoinColumn(name = "MODULO_IDMODULO", referencedColumnName = "IDMODULO")
    @ManyToOne(optional = false)
    private Modulo moduloIdmodulo;

    public Campanya() {
    }

    public Campanya(Integer idcampanya) {
        this.idcampanya = idcampanya;
    }

    public Campanya(Integer idcampanya, Date fecha) {
        this.idcampanya = idcampanya;
        this.fecha = fecha;
    }

    public Integer getIdcampanya() {
        return idcampanya;
    }

    public void setIdcampanya(Integer idcampanya) {
        this.idcampanya = idcampanya;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombrecampanya() {
        return nombrecampanya;
    }

    public void setNombrecampanya(String nombrecampanya) {
        this.nombrecampanya = nombrecampanya;
    }

    public Modulo getModuloIdmodulo() {
        return moduloIdmodulo;
    }

    public void setModuloIdmodulo(Modulo moduloIdmodulo) {
        this.moduloIdmodulo = moduloIdmodulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcampanya != null ? idcampanya.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Campanya)) {
            return false;
        }
        Campanya other = (Campanya) object;
        if ((this.idcampanya == null && other.idcampanya != null) || (this.idcampanya != null && !this.idcampanya.equals(other.idcampanya))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Campanya[ idcampanya=" + idcampanya + " ]";
    }
    
}
