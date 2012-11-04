/**
 * Copyright 2012 Winflow Financial Group Corporation.
 *      http://www.winflowfinancial.com
 */
package utils;

import java.text.SimpleDateFormat;

/**
 * @author Jatinder Singh on 2012-11-03 at 12:16 AM
 */
public class WinFlowUtil {

    /**
     * Use this method wherever possible to keep date
     * format consistent throughout the application
     *
     * @return
     */
    public static SimpleDateFormat getSimpleDateFormat() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public static String getStringDateFormat() {
        return "yyyy-MM-dd HH:mm:ss";
    }
}
