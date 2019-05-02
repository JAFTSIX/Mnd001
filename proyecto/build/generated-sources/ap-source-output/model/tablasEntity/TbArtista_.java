package model.tablasEntity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.tablasEntity.TbArticulo;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-05-02T09:55:15")
@StaticMetamodel(TbArtista.class)
public class TbArtista_ { 

    public static volatile SingularAttribute<TbArtista, Integer> idArtista;
    public static volatile SingularAttribute<TbArtista, String> correo;
    public static volatile CollectionAttribute<TbArtista, TbArticulo> tbArticuloCollection;
    public static volatile SingularAttribute<TbArtista, Long> telefono;
    public static volatile SingularAttribute<TbArtista, String> empresa;
    public static volatile SingularAttribute<TbArtista, String> nombre;

}