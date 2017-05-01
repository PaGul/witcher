package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;
import witcher.entities.guest;
import witcher.entities.witcher_ordersPK;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-01T17:15:38")
@StaticMetamodel(witcher_orders.class)
public class witcher_orders_ { 

    public static volatile SingularAttribute<witcher_orders, witcher_ordersPK> witcher_ordersPK;
    public static volatile SingularAttribute<witcher_orders, ad> ad;
    public static volatile SingularAttribute<witcher_orders, guest> guest;
    public static volatile SingularAttribute<witcher_orders, Integer> notificated;

}