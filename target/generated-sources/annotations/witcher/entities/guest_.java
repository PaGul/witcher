package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;
import witcher.entities.creditcard;
import witcher.entities.customer;
import witcher.entities.witcher;
import witcher.entities.witcherorders;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-13T02:27:58")
@StaticMetamodel(guest.class)
public class guest_ { 

    public static volatile SingularAttribute<guest, Integer> crCardId;
    public static volatile SingularAttribute<guest, Integer> rating;
    public static volatile SingularAttribute<guest, String> login;
    public static volatile CollectionAttribute<guest, ad> adCollection;
    public static volatile SingularAttribute<guest, String> secretquestion;
    public static volatile SingularAttribute<guest, creditcard> creditcard;
    public static volatile SingularAttribute<guest, String> password;
    public static volatile SingularAttribute<guest, String> secretanswer;
    public static volatile SingularAttribute<guest, witcher> witcher;
    public static volatile SingularAttribute<guest, String> name;
    public static volatile CollectionAttribute<guest, witcherorders> witcherordersInterfaceCollection;
    public static volatile SingularAttribute<guest, Integer> id;
    public static volatile SingularAttribute<guest, Integer> userType;
    public static volatile SingularAttribute<guest, String> email;
    public static volatile SingularAttribute<guest, customer> customer;

}