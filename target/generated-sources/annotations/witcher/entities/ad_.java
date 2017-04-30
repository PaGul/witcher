package witcher.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.guest;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-01T02:23:05")
@StaticMetamodel(ad.class)
public class ad_ { 

    public static volatile SingularAttribute<ad, Date> date;
    public static volatile SingularAttribute<ad, guest> owner;
    public static volatile SingularAttribute<ad, Integer> price;
    public static volatile SingularAttribute<ad, Integer> rating;
    public static volatile SingularAttribute<ad, String> header;
    public static volatile SingularAttribute<ad, Long> id;
    public static volatile SingularAttribute<ad, String> text;

}