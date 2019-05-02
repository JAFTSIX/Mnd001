package model.tablasEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.tablasEntity.TbArticulo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-02T09:55:15")
@StaticMetamodel(TbLicencia.class)
public class TbLicencia_ { 

    public static volatile SingularAttribute<TbLicencia, String> dueno;
    public static volatile SingularAttribute<TbLicencia, Integer> idLicencia;
    public static volatile SingularAttribute<TbLicencia, String> correo;
    public static volatile CollectionAttribute<TbLicencia, TbArticulo> tbArticuloCollection;
    public static volatile SingularAttribute<TbLicencia, Long> telefono;
    public static volatile SingularAttribute<TbLicencia, String> pais;

}