/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import parsers.BrokerageType;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Jatinder Singh on 2012-11-07 at 11:03 AM
 */
@Entity
@Table(name = "TRADE_PROPERTY")
public class TradeProperty extends TimeStampable {
    public String name;

    public int rank;

    @Enumerated(EnumType.STRING)
    public BrokerageType brokerageType;

    public boolean isDate;

    public boolean ignore;

    /**
     * Finder for quering into database
     */
    public static Model.Finder<String, TradeProperty> find = new Model.Finder(String.class, TradeProperty.class);

    /**
     * Get all properties by brokerage type
     */
    public static List<TradeProperty> findByBrokerageType(BrokerageType brokerageType) {
        return find.where()
                    .eq("brokerageType", brokerageType)
                    .orderBy("rank")
                    .findList();
    }

    public static TradeProperty create(TradeProperty tradeProperty) {
        tradeProperty.save();
        return tradeProperty;
    }

}
