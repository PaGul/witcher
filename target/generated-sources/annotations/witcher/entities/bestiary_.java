package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-03T18:11:02")
@StaticMetamodel(bestiary.class)
public class bestiary_ { 

    public static volatile SingularAttribute<bestiary, ad> ad;
    public static volatile SingularAttribute<bestiary, String> name;
    public static volatile SingularAttribute<bestiary, String> description;
    public static volatile SingularAttribute<bestiary, byte[]> photo;
    public static volatile SingularAttribute<bestiary, Integer> id;

}