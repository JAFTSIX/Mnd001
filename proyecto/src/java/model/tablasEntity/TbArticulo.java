/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.tablasEntity;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Fabian
 */
@Entity
@Table(name = "TB_ARTICULO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TbArticulo.findAll", query = "SELECT t FROM TbArticulo t")
    , @NamedQuery(name = "TbArticulo.findByNoArticulo", query = "SELECT t FROM TbArticulo t WHERE t.noArticulo = :noArticulo")
    , @NamedQuery(name = "TbArticulo.findByNombre", query = "SELECT t FROM TbArticulo t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TbArticulo.findByFecha", query = "SELECT t FROM TbArticulo t WHERE t.fecha = :fecha")
    , @NamedQuery(name = "TbArticulo.findByCant", query = "SELECT t FROM TbArticulo t WHERE t.cant = :cant")
    , @NamedQuery(name = "TbArticulo.findByPrecio", query = "SELECT t FROM TbArticulo t WHERE t.precio = :precio")
    , @NamedQuery(name = "TbArticulo.findByDescrip", query = "SELECT t FROM TbArticulo t WHERE t.descrip = :descrip")
    , @NamedQuery(name = "TbArticulo.findByImg", query = "SELECT t FROM TbArticulo t WHERE t.img = :img")})
public class TbArticulo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "NO_ARTICULO")
    private Integer noArticulo;
    @Size(max = 30)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "CANT")
    private Integer cant;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "PRECIO")
    private BigDecimal precio;
    @Size(max = 600)
    @Column(name = "DESCRIP")
    private String descrip;
    @Size(max = 1000)
    @Column(name = "IMG")
    private String img;
    @JoinColumn(name = "ID_ARTISTA", referencedColumnName = "ID_ARTISTA")
    @ManyToOne(optional = false)
    private TbArtista idArtista;
    @JoinColumn(name = "ID_LICENCIA", referencedColumnName = "ID_LICENCIA")
    @ManyToOne(optional = false)
    private TbLicencia idLicencia;
    @JoinColumn(name = "ID_PROVEEDOR", referencedColumnName = "ID_PROVEEDOR")
    @ManyToOne(optional = false)
    private TbProveedor idProveedor;
    @JoinColumn(name = "ID_TIPO", referencedColumnName = "ID_TIPO")
    @ManyToOne(optional = false)
    private TbTipo idTipo;

    public TbArticulo() {
    }

    public TbArticulo(Integer noArticulo) {
        this.noArticulo = noArticulo;
    }

    public Integer getNoArticulo() {
        return noArticulo;
    }

    public void setNoArticulo(Integer noArticulo) {
        this.noArticulo = noArticulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCant() {
        return cant;
    }

    public void setCant(Integer cant) {
        this.cant = cant;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public TbArtista getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(TbArtista idArtista) {
        this.idArtista = idArtista;
    }

    public TbLicencia getIdLicencia() {
        return idLicencia;
    }

    public void setIdLicencia(TbLicencia idLicencia) {
        this.idLicencia = idLicencia;
    }

    public TbProveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(TbProveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public TbTipo getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(TbTipo idTipo) {
        this.idTipo = idTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noArticulo != null ? noArticulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TbArticulo)) {
            return false;
        }
        TbArticulo other = (TbArticulo) object;
        if ((this.noArticulo == null && other.noArticulo != null) || (this.noArticulo != null && !this.noArticulo.equals(other.noArticulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TbArticulo[ noArticulo=" + noArticulo + " ]";
    }
    
}
