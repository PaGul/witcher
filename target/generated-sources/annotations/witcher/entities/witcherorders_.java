package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.entities.witcherordersPK;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-01T19:11:07")
@StaticMetamodel(witcherorders.class)
public class witcherorders_ { 

    public static volatile SingularAttribute<witcherorders, witcherordersPK> witcherordersPK;
    public static volatile SingularAttribute<witcherorders, ad> ad;
    public static volatile SingularAttribute<witcherorders, guest> guest;
    public static volatile SingularAttribute<witcherorders, byte[]> proof;
    public static volatile SingularAttribute<witcherorders, Integer> notificated;

}