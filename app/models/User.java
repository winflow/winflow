package models;

import java.util.*;
import javax.persistence.*;

import org.joda.time.DateTime;
import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

/**
 * Saves user information and provides a way to authenticate
 * user into the system
 */
@Entity
@Table(name="ACCOUNT")
public class User extends Model {

	@Id
	@Constraints.Required
	@Formats.NonEmpty
	public String email;

	@Constraints.Required
	public String firstName;

    @Constraints.Required
    public String lastName;

	@Constraints.Required
	public String password;

    public DateTime createdOn;

    public DateTime updatedOn;

	/**
	 *	Finder for quering into database
	 */
	public static Model.Finder<String, User> find = new Model.Finder(String.class, User.class);

	/**
	 *	Retrieves all users from db
	 */
	public static List<User> findAll() {
		return find.all();
	}

	/**
	 *	Retrieves a user from email
	 */
	public static User findByEmail(String email) {
		return find.where().eq("email", email).findUnique();
	}

	/**
	 *	Authenticates a user using email and password
	 */
	public static User authenticate(String email, String password) {
		return find.where()
                    .eq("email", email)
                    .eq("password", password)
                    .findUnique();
	}
}