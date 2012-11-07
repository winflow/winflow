/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;
import com.avaje.ebean.text.csv.CsvReader;
import org.joda.time.DateTime;
import parsers.Brokerage;
import play.Logger;
import play.data.validation.Constraints;
import play.db.ebean.Model;
import play.db.ebean.Transactional;

import javax.persistence.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author Jatinder Singh on 2012-11-01 at 8:04 PM
 */
@Entity
@Table(name = "ACTIVE_TRADE")
public class ActiveTrade extends TimeStampable {

    @Column(name = "OPTION_STRIKE")
    public double strike;

    @Column(name = "OPTION_RIGHT")
    public String right;

    public String localSymbol;

    public String securityType;

    public DateTime expiry;

    public int position;

    public int multiplier;

    public String exchange;

    public String primaryExchange;

    public String currency;

    public DateTime transactionDate;

    public double originalPrice;

    /**
     * Finder for quering into database
     */
    public static Model.Finder<String, ActiveTrade> find = new Model.Finder(String.class, ActiveTrade.class);

    @Transactional
    public static void create(File file, String brokerage) {
        try {
            FileReader fileReader = new FileReader(file);
            final EbeanServer server = Ebean.getServer(null);

            CsvReader<ActiveTrade> csvReader = server.createCsvReader(ActiveTrade.class);
            csvReader = Brokerage.addBrokerProperties(csvReader, brokerage);

            final Transaction transaction = Ebean.beginTransaction();
            transaction.setBatchMode(true);
            transaction.setBatchSize(5);

            try {
                csvReader.process(fileReader, Brokerage.getParser(brokerage));
                transaction.commit();
            } finally {
                transaction.end();
            }
        } catch (FileNotFoundException e) {
            Logger.error("File not found error ", e);
        } catch (Exception e) {
            Logger.error("Exception ", e);
        }
    }

    public static ActiveTrade create(ActiveTrade activeTrade) {
        activeTrade.save();
        return activeTrade;
    }

    /**
     * Retrieves all users from db
     */
    public static List<ActiveTrade> findAll() {
        return find.orderBy("createdAt desc").findList();
    }

    /**
     * Retrieves all active trades using the expiry date
     *
     * @param expiry
     * @return
     */
    public static List<ActiveTrade> findByExpiryDate(DateTime expiry) {
        return find.where()
                    .eq("expiry", expiry)
                    .findList();
    }

    /**
     * Retrieves all active trades where expiry date is greater than passed date
     *
     * @param expiry
     * @return
     */
    public static List<ActiveTrade> findByExpiryDateGTE(DateTime expiry) {
        return find.where()
                .ge("expiry", expiry)
                .findList();
    }

    /**
     * Retrieves all active trades where expiry date is less than passed date
     *
     * @param expiry
     * @return
     */
    public static List<ActiveTrade> findByExpiryDateLTE(DateTime expiry) {
        return find.where()
                .le("expiry", expiry)
                .findList();
    }

    /**
     * Retrieves all active trades using the symbol
     *
     * @param localSymbol
     * @return
     */
    public static List<ActiveTrade> findByLocalSymbol(String localSymbol) {
        return find.where()
                .eq("localSymbol", localSymbol)
                .findList();
    }

    /**
     * Retrieves all active trades for the passed security type
     *
     * @param securityType
     * @return
     */
    public static List<ActiveTrade> findBySecurityType(String securityType) {
        return find.where()
                .eq("securityType", securityType)
                .findList();
    }
}
