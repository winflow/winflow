/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import org.joda.time.DateTime;
import org.junit.*;
import java.util.List;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * @author Jatinder Singh on 2012-11-04 at 2:49 AM
 */
public class ActiveTradeTest {


    @Test
    public void findByLocalSymbol() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findByLocalSymbol("DD");

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }

    @Test
    public void findBySecurityType() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findBySecurityType("OPT");

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }

    public void findByExpiryDate() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                DateTime maDate = new DateTime("2001-09-09T01:46:40Z");

                List<ActiveTrade> activeTrade = ActiveTrade.findByExpiryDate(new DateTime());

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }
}
