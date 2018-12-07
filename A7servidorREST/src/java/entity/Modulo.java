/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author JaGaRo
 */
@Entity
@Table(name = "MODULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")
    , @NamedQuery(name = "Modulo.findByIdmodulo", query = "SELECT m FROM Modulo m WHERE m.idmodulo = :idmodulo")
    , @NamedQuery(name = "Modulo.findByNombremodulo", query = "SELECT m FROM Modulo m WHERE m.nombremodulo = :nombremodulo")
    , @NamedQuery(name = "Modulo.findByLatitud", query = "SELECT m FROM Modulo m WHERE m.latitud = :latitud")
    , @NamedQuery(name = "Modulo.findByLongitud", query = "SELECT m FROM Modulo m WHERE m.longitud = :longitud")
    , @NamedQuery(name = "Modulo.findByValoralpha", query = "SELECT m FROM Modulo m WHERE m.valoralpha = :valoralpha")
    , @NamedQuery(name = "Modulo.findByValorbeta", query = "SELECT m FROM Modulo m WHERE m.valorbeta = :valorbeta")
    , @NamedQuery(name = "Modulo.findByValorgamma", query = "SELECT m FROM Modulo m WHERE m.valorgamma = :valorgamma")
    , @NamedQuery(name = "Modulo.findByValorkappa", query = "SELECT m FROM Modulo m WHERE m.valorkappa = :valorkappa")
    , @NamedQuery(name = "Modulo.findByIdealidad", query = "SELECT m FROM Modulo m WHERE m.idealidad = :idealidad")
    , @NamedQuery(name = "Modulo.findByResistencia", query = "SELECT m FROM Modulo m WHERE m.resistencia = :resistencia")
    , @NamedQuery(name = "Modulo.findByRendimiento", query = "SELECT m FROM Modulo m WHERE m.rendimiento = :rendimiento")})
public class Modulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDMODULO")
    private Integer idmodulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NOMBREMODULO")
    private String nombremodulo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "LATITUD")
    private BigDecimal latitud;
    @Column(name = "LONGITUD")
    private BigDecimal longitud;
    @Column(name = "VALORALPHA")
    private Double valoralpha;
    @Column(name = "VALORBETA")
    private Double valorbeta;
    @Column(name = "VALORGAMMA")
    private Double valorgamma;
    @Column(name = "VALORKAPPA")
    private Double valorkappa;
    @Column(name = "IDEALIDAD")
    private Double idealidad;
    @Column(name = "RESISTENCIA")
    private Double resistencia;
    @Column(name = "RENDIMIENTO")
    private Double rendimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moduloIdmodulo")
    private List<Campanya> campanyaList;

    public Modulo() {
    }

    public Modulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public Modulo(Integer idmodulo, String nombremodulo) {
        this.idmodulo = idmodulo;
        this.nombremodulo = nombremodulo;
    }

    public Integer getIdmodulo() {
        return idmodulo;
    }

    public void setIdmodulo(Integer idmodulo) {
        this.idmodulo = idmodulo;
    }

    public String getNombremodulo() {
        return nombremodulo;
    }

    public void setNombremodulo(String nombremodulo) {
        this.nombremodulo = nombremodulo;
    }

    public BigDecimal getLatitud() {
        return latitud;
    }

    public void setLatitud(BigDecimal latitud) {
        this.latitud = latitud;
    }

    public BigDecimal getLongitud() {
        return longitud;
    }

    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }

    public Double getValoralpha() {
        return valoralpha;
    }

    public void setValoralpha(Double valoralpha) {
        this.valoralpha = valoralpha;
    }

    public Double getValorbeta() {
        return valorbeta;
    }

    public void setValorbeta(Double valorbeta) {
        this.valorbeta = valorbeta;
    }

    public Double getValorgamma() {
        return valorgamma;
    }

    public void setValorgamma(Double valorgamma) {
        this.valorgamma = valorgamma;
    }

    public Double getValorkappa() {
        return valorkappa;
    }

    public void setValorkappa(Double valorkappa) {
        this.valorkappa = valorkappa;
    }

    public Double getIdealidad() {
        return idealidad;
    }

    public void setIdealidad(Double idealidad) {
        this.idealidad = idealidad;
    }

    public Double getResistencia() {
        return resistencia;
    }

    public void setResistencia(Double resistencia) {
        this.resistencia = resistencia;
    }

    public Double getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Double rendimiento) {
        this.rendimiento = rendimiento;
    }

    @XmlTransient
    public List<Campanya> getCampanyaList() {
        return campanyaList;
    }

    public void setCampanyaList(List<Campanya> campanyaList) {
        this.campanyaList = campanyaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmodulo != null ? idmodulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Modulo)) {
            return false;
        }
        Modulo other = (Modulo) object;
        if ((this.idmodulo == null && other.idmodulo != null) || (this.idmodulo != null && !this.idmodulo.equals(other.idmodulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Modulo[ idmodulo=" + idmodulo + " ]";
    }
    
}
