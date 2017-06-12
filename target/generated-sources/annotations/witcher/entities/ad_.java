package witcher.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.bestiary;
import witcher.entities.guest;
import witcher.entities.witcherorders;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-13T02:27:58")
@StaticMetamodel(ad.class)
public class ad_ { 

    public static volatile SingularAttribute<ad, guest> owner;
    public static volatile SingularAttribute<ad, Integer> price;
    public static volatile SingularAttribute<ad, Date> adDate;
    public static volatile SingularAttribute<ad, Integer> monsterId;
    public static volatile CollectionAttribute<ad, witcherorders> witcherordersCollection;
    public static volatile SingularAttribute<ad, Integer> rating;
    public static volatile SingularAttribute<ad, String> header;
    public static volatile SingularAttribute<ad, bestiary> bestiary;
    public static volatile SingularAttribute<ad, Integer> id;
    public static volatile SingularAttribute<ad, String> text;

}