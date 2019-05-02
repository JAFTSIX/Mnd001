package model.tablasEntity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.tablasEntity.TbArtista;
import model.tablasEntity.TbLicencia;
import model.tablasEntity.TbProveedor;
import model.tablasEntity.TbTipo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-02T09:55:15")
@StaticMetamodel(TbArticulo.class)
public class TbArticulo_ { 

    public static volatile SingularAttribute<TbArticulo, Date> fecha;
    public static volatile SingularAttribute<TbArticulo, BigDecimal> precio;
    public static volatile SingularAttribute<TbArticulo, String> img;
    public static volatile SingularAttribute<TbArticulo, String> descrip;
    public static volatile SingularAttribute<TbArticulo, TbLicencia> idLicencia;
    public static volatile SingularAttribute<TbArticulo, TbArtista> idArtista;
    public static volatile SingularAttribute<TbArticulo, TbProveedor> idProveedor;
    public static volatile SingularAttribute<TbArticulo, Integer> noArticulo;
    public static volatile SingularAttribute<TbArticulo, Integer> cant;
    public static volatile SingularAttribute<TbArticulo, TbTipo> idTipo;
    public static volatile SingularAttribute<TbArticulo, String> nombre;

}