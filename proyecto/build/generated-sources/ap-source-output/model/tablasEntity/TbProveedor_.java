package model.tablasEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.tablasEntity.TbArticulo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-02T09:55:15")
@StaticMetamodel(TbProveedor.class)
public class TbProveedor_ { 

    public static volatile SingularAttribute<TbProveedor, Integer> idProveedor;
    public static volatile SingularAttribute<TbProveedor, String> correo;
    public static volatile CollectionAttribute<TbProveedor, TbArticulo> tbArticuloCollection;
    public static volatile SingularAttribute<TbProveedor, Long> telefono;
    public static volatile SingularAttribute<TbProveedor, String> nombre;

}