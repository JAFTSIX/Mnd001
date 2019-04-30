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
@Table(name = "TB_TIPO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbTipo.findAll", query = "SELECT t FROM TbTipo t")
    , @NamedQuery(name = "TbTipo.findByIdTipo", query = "SELECT t FROM TbTipo t WHERE t.idTipo = :idTipo")
    , @NamedQuery(name = "TbTipo.findByNombre", query = "SELECT t FROM TbTipo t WHERE t.nombre = :nombre")})
public class TbTipo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO")
    private Integer idTipo;
    @Size(max = 15)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipo")
    private Collection<TbArticulo> tbArticuloCollection;

    public TbTipo() {
    }

    public TbTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        hash += (idTipo != null ? idTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbTipo)) {
            return false;
        }
        TbTipo other = (TbTipo) object;
        if ((this.idTipo == null && other.idTipo != null) || (this.idTipo != null && !this.idTipo.equals(other.idTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+"  [ID: " + idTipo + "]";
    }
    
}
