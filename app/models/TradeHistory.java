/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import play.db.ebean.Model;

/**
 * @author Jatinder Singh on 2012-11-07 at 10:46 AM
 */
public class TradeHistory extends TimeStampable {


    /**
     * Finder for quering into database
     */
    public static Model.Finder<String, TradeHistory> find = new Model.Finder(String.class, TradeHistory.class);

}
