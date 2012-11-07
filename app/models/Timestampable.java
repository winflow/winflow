/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.joda.time.DateTime;
import play.data.format.Formats;
import play.db.ebean.Model;

/**
 * @author Jatinder Singh on 2012-11-03 at 12:52 AM
 */
@MappedSuperclass
public class TimeStampable extends Model {

    @Id
    @GeneratedValue
    @Formats.NonEmpty
    public Long id;

    @Column(name = "created_at")
    public DateTime createdAt = new DateTime();

    @Column(name = "updated_at")
    public DateTime updatedAt = new DateTime();
}
