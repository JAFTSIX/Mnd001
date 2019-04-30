/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tablasEntity;

import java.io.Serializable;
import java.util.Collection;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Fabian
 */
@Entity
@Table(name = "TB_LICENCIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbLicencia.findAll", query = "SELECT t FROM TbLicencia t")
    , @NamedQuery(name = "TbLicencia.findByIdLicencia", query = "SELECT t FROM TbLicencia t WHERE t.idLicencia = :idLicencia")
    , @NamedQuery(name = "TbLicencia.findByDueno", query = "SELECT t FROM TbLicencia t WHERE t.dueno = :dueno")
    , @NamedQuery(name = "TbLicencia.findByPais", query = "SELECT t FROM TbLicencia t WHERE t.pais = :pais")
    , @NamedQuery(name = "TbLicencia.findByTelefono", query = "SELECT t FROM TbLicencia t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TbLicencia.findByCorreo", query = "SELECT t FROM TbLicencia t WHERE t.correo = :correo")})
public class TbLicencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_LICENCIA")
    private Integer idLicencia;
    @Size(max = 30)
    @Column(name = "DUENO")
    private String dueno;
    @Size(max = 20)
    @Column(name = "PAIS")
    private String pais;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLicencia")
    private Collection<TbArticulo> tbArticuloCollection;

    public TbLicencia() {
    }

    public TbLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public Integer getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(Integer idLicencia) {
        this.idLicencia = idLicencia;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @XmlTransient
    public Collection<TbArticulo> getTbArticuloCollection() {
        return tbArticuloCollection;
    }

    public void setTbArticuloCollection(Collection<TbArticulo> tbArticuloCollection) {
        this.tbArticuloCollection = tbArticuloCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLicencia != null ? idLicencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbLicencia)) {
            return false;
        }
        TbLicencia other = (TbLicencia) object;
        if ((this.idLicencia == null && other.idLicencia != null) || (this.idLicencia != null && !this.idLicencia.equals(other.idLicencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return dueno+"  [ID: " + idLicencia + "]";
    }
    
}
