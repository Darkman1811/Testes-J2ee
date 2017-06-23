package testEntity.Beans;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import testEntity.Beans.Adresse;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-06-25T13:41:10")
@StaticMetamodel(Human.class)
public class Human_ { 

    public static volatile SingularAttribute<Human, Adresse> adresse;
    public static volatile SingularAttribute<Human, Integer> id;
    public static volatile SingularAttribute<Human, String> prenom;
    public static volatile SingularAttribute<Human, String> nom;
    public static volatile SingularAttribute<Human, Integer> age;

}