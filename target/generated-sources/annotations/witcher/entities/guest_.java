package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.ad;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-05-01T02:23:05")
@StaticMetamodel(guest.class)
public class guest_ { 

    public static volatile SingularAttribute<guest, String> password;
    public static volatile SingularAttribute<guest, Integer> balance;
    public static volatile SingularAttribute<guest, String> secretanswer;
    public static volatile SingularAttribute<guest, String> name;
    public static volatile SingularAttribute<guest, Integer> rating;
    public static volatile SingularAttribute<guest, Integer> id;
    public static volatile SingularAttribute<guest, Integer> userType;
    public static volatile SingularAttribute<guest, String> login;
    public static volatile CollectionAttribute<guest, ad> adCollection;
    public static volatile SingularAttribute<guest, String> secretquestion;
    public static volatile SingularAttribute<guest, String> email;

}