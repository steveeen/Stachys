package de.kuub.stachys.transfer;

import de.kuub.stachys.domain.Loginuser.UserTypes;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2011-08-29T12:35:32.267+0200")
@StaticMetamodel(LoginuserPersonDTO.class)
public class LoginuserPersonDTO_ {
	public static volatile SingularAttribute<LoginuserPersonDTO, Integer> user_id;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> logname;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> hashtype;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> salt;
	public static volatile SingularAttribute<LoginuserPersonDTO, UserTypes> usertype;
	public static volatile SingularAttribute<LoginuserPersonDTO, Integer> pers_id;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> name;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> firstname;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> email;
	public static volatile SingularAttribute<LoginuserPersonDTO, String> location;
}
