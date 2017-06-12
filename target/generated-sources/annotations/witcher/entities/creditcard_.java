package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.bank;
import witcher.entities.guest;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-12T23:15:40")
@StaticMetamodel(creditcard.class)
public class creditcard_ { 

    public static volatile SingularAttribute<creditcard, Integer> bankId;
    public static volatile SingularAttribute<creditcard, bank> bank;
    public static volatile SingularAttribute<creditcard, Integer> balance;
    public static volatile SingularAttribute<creditcard, guest> guest;
    public static volatile SingularAttribute<creditcard, Integer> id;

}