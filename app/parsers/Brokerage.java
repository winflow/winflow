/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package parsers;

import com.avaje.ebean.text.csv.CsvReader;
import models.ActiveTrade;
import utils.WinFlowUtil;

/**
 * @author Jatinder Singh on 2012-11-02 at 9:00 PM
 */
public class Brokerage {

    /**
     * Adds broker fields to save into db
     *
     * @param csvReader
     * @param brokerage
     * @return
     */
    public static CsvReader<ActiveTrade> addBrokerProperties(CsvReader<ActiveTrade> csvReader, String brokerage) {
        switch (BrokerageType.valueOf(brokerage)) {
            case FIDELITY:
                csvReader.setIgnoreHeader();
                csvReader.addProperty("localSymbol");
                csvReader.addProperty("securityType");
                csvReader.addDateTime("expiry", WinFlowUtil.getStringDateFormat());
                csvReader.addProperty("strike");
                csvReader.addProperty("right");
                csvReader.addProperty("position");
                csvReader.addProperty("multiplier");
                csvReader.addProperty("exchange");
                csvReader.addProperty("primaryExchange");
                csvReader.addProperty("currency");
                csvReader.addDateTime("transactionDate", WinFlowUtil.getStringDateFormat());
                csvReader.addProperty("originalPrice");
                break;
            case IB:
                csvReader.setIgnoreHeader();
                csvReader.addProperty("securityType");
                csvReader.addProperty("localSymbol");
                csvReader.addDateTime("expiry", WinFlowUtil.getStringDateFormat());
                csvReader.addProperty("strike");
                csvReader.addProperty("right");
                csvReader.addProperty("position");
                csvReader.addProperty("multiplier");
                csvReader.addProperty("exchange");
                csvReader.addProperty("currency");
                csvReader.addProperty("primaryExchange");
                csvReader.addDateTime("transactionDate", WinFlowUtil.getStringDateFormat());
                csvReader.addProperty("originalPrice");
                break;
            case MERRILL:
                break;
        }

        return csvReader;
    }
}
