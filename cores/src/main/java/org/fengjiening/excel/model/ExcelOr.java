package org.fengjiening.excel.model;

import org.fengjiening.office.or.OfficeOr;

/**
 * Created by fengjiening on 2020/9/4.
 */
public class ExcelOr extends OfficeOr{

    private static volatile ExcelOr instance;

    private static boolean flag = true;
    /**
     * private constructor to prevent client from instantiating.
     */
    private ExcelOr() {
        // to prevent instantiating by Reflection call
        if (flag) {
            flag = false;
        } else {
            throw new IllegalStateException("Already initialized.");
        }
    }
    /**
     * Public accessor.
     *
     * @return an instance of the class.
     */
    public static ExcelOr getInstance() {
        ExcelOr result = instance;
        if (result == null) {
            // So to make sure we need to lock on an object to get mutual exclusion.
            synchronized (ExcelOr.class) {
                // Again assign the instance to local variable to check if it was initialized by some
                result = instance;
                if (result == null) {

                    instance = result = new ExcelOr();
                }
            }
        }
        return result;
    }
}
