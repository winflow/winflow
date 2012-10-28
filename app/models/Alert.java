package models;

import java.util.*;

import play.db.ebean.*;
import play.data.validation.Constraints.*;

import javax.persistence.*;

@Entity
public class Alert extends Model {
	
	@Id
	public Long id;

	@Required
	public String label;

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