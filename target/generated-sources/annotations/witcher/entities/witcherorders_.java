package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;
import witcher.entities.guest;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-13T02:27:58")
@StaticMetamodel(witcherorders.class)
public class witcherorders_ { 

    public static volatile SingularAttribute<witcherorders, ad> adId;
    public static volatile SingularAttribute<witcherorders, guest> witcherId;
    public static volatile SingularAttribute<witcherorders, byte[]> proof;
    public static volatile SingularAttribute<witcherorders, Integer> id;
    public static volatile SingularAttribute<witcherorders, Integer> notificated;

}