package models;

import java.util.*;

import org.joda.time.DateTime;
import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Alert extends TimeStampable {

	@Required
	public String label;

    public DateTime createdOn;

    /**
	 *	Creating find helper to initiate queries
	 */
	public static Finder<Long, Alert> find = new Finder(Long.class, Alert.class);
	
	public static List<Alert> all() {
		return find.all();
	}

	public static void create(Alert alert) {
		alert.save();
	}

	public static void delete(Long id) {
		find.ref(id).delete();
	}
}