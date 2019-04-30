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
@Table(name = "TB_PROVEEDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbProveedor.findAll", query = "SELECT t FROM TbProveedor t")
    , @NamedQuery(name = "TbProveedor.findByIdProveedor", query = "SELECT t FROM TbProveedor t WHERE t.idProveedor = :idProveedor")
    , @NamedQuery(name = "TbProveedor.findByNombre", query = "SELECT t FROM TbProveedor t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbProveedor.findByCorreo", query = "SELECT t FROM TbProveedor t WHERE t.correo = :correo")
    , @NamedQuery(name = "TbProveedor.findByTelefono", query = "SELECT t FROM TbProveedor t WHERE t.telefono = :telefono")})
public class TbProveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "TELEFONO")
    private Long telefono;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedor")
    private Collection<TbArticulo> tbArticuloCollection;

    public TbProveedor() {
    }

    public TbProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
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
        hash += (idProveedor != null ? idProveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbProveedor)) {
            return false;
        }
        TbProveedor other = (TbProveedor) object;
        if ((this.idProveedor == null && other.idProveedor != null) || (this.idProveedor != null && !this.idProveedor.equals(other.idProveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+"  [ID: "+idProveedor+"]";
    }
    
}
