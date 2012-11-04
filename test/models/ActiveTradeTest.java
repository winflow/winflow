/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package models;

import org.joda.time.DateTime;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import java.util.List;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

/**
 * @author Jatinder Singh on 2012-11-04 at 2:49 AM
 */
public class ActiveTradeTest {

    @Test
    public void findByExpiryDate() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findByExpiryDate(new DateTime());

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }

    @Test
    public void findByExpiryDateGTE() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findByExpiryDateGTE(new DateTime());

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }

    @Test
    public void findByExpiryDateLTE() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findByExpiryDateLTE(new DateTime());

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }

    @Test
    public void findByLocalSymbol() {
        running(fakeApplication(inMemoryDatabase()), new Runnable() {
            @Override
            public void run() {
                List<ActiveTrade> activeTrade = ActiveTrade.findByLocalSymbol("RIMM");

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
                List<ActiveTrade> activeTrade = ActiveTrade.findBySecurityType("Option");

                assertThat(activeTrade).isNotNull();
                assertThat(activeTrade.size()).isGreaterThan(0);
            }
        });
    }
}
