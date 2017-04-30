package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.guest;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-04-26T23:52:30")
@StaticMetamodel(ad.class)
public class ad_ { 

    public static volatile SingularAttribute<ad, guest> owner;
    public static volatile SingularAttribute<ad, Integer> price;
    public static volatile SingularAttribute<ad, String> header;
    public static volatile CollectionAttribute<ad, guest> guestCollection;
    public static volatile SingularAttribute<ad, Long> id;
    public static volatile SingularAttribute<ad, String> text;

}