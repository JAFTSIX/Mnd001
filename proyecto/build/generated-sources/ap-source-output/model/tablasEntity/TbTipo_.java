package model.tablasEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.tablasEntity.TbArticulo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-02T09:55:15")
@StaticMetamodel(TbTipo.class)
public class TbTipo_ { 

    public static volatile CollectionAttribute<TbTipo, TbArticulo> tbArticuloCollection;
    public static volatile SingularAttribute<TbTipo, Integer> idTipo;
    public static volatile SingularAttribute<TbTipo, String> nombre;

}