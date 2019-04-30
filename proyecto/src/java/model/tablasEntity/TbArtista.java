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
@Table(name = "TB_ARTISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbArtista.findAll", query = "SELECT t FROM TbArtista t")
    , @NamedQuery(name = "TbArtista.findByIdArtista", query = "SELECT t FROM TbArtista t WHERE t.idArtista = :idArtista")
    , @NamedQuery(name = "TbArtista.findByNombre", query = "SELECT t FROM TbArtista t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbArtista.findByCorreo", query = "SELECT t FROM TbArtista t WHERE t.correo = :correo")
    , @NamedQuery(name = "TbArtista.findByTelefono", query = "SELECT t FROM TbArtista t WHERE t.telefono = :telefono")
    , @NamedQuery(name = "TbArtista.findByEmpresa", query = "SELECT t FROM TbArtista t WHERE t.empresa = :empresa")})
public class TbArtista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ARTISTA")
    private Integer idArtista;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 30)
    @Column(name = "CORREO")
    private String correo;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Size(max = 30)
    @Column(name = "EMPRESA")
    private String empresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idArtista")
    private Collection<TbArticulo> tbArticuloCollection;

    public TbArtista() {
    }

    public TbArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
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

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
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
        hash += (idArtista != null ? idArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbArtista)) {
            return false;
        }
        TbArtista other = (TbArtista) object;
        if ((this.idArtista == null && other.idArtista != null) || (this.idArtista != null && !this.idArtista.equals(other.idArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre+"  [ID:" + idArtista + "]";
    }
    
}
