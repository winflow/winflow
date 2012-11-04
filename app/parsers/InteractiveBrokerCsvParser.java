/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package parsers;

import com.avaje.ebean.text.csv.DefaultCsvCallback;
import play.Logger;
import utils.WinFlowUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Jatinder Singh on 2012-11-03 at 1:16 AM
 */
public class InteractiveBrokerCsvParser<ActiveTrade> extends DefaultCsvCallback<ActiveTrade> {

    /**
     * A good place to change incoming data in a format we expect
     *
     * @param row
     * @param line
     * @return
     */
    @Override
    public boolean processLine(int row, String[] line) {
        SimpleDateFormat incomingFormat = new SimpleDateFormat("yyyyMMdd");

        try {
            // Format expiry date sits at index 2
            line[2] = WinFlowUtil.getSimpleDateFormat().format(incomingFormat.parse(line[10]));

            // Format transactionDate sits at index 10
            line[10] = WinFlowUtil.getSimpleDateFormat().format(incomingFormat.parse(line[10]));
        } catch (ParseException e) {
            Logger.error("Date parse error ", e);
        }

        return true;
    }

    @Override
    public void processBean(int row, String[] line, ActiveTrade bean) {
        server.save(bean, transaction);
    }
}
