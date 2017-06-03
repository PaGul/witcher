package witcher.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import witcher.entities.creditcard;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2017-06-03T18:11:02")
@StaticMetamodel(bank.class)
public class bank_ { 

    public static volatile SingularAttribute<bank, String> name;
    public static volatile SingularAttribute<bank, Long> id;
    public static volatile SingularAttribute<bank, Double> commision;
    public static volatile SingularAttribute<bank, creditcard> creditcard;

}