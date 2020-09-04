package org.fengjiening.office.factory;

import org.apache.naming.factory.MailSessionFactory;
import org.fengjiening.excel.model.ExcelOr;
import org.fengjiening.office.core.OfficeFactory;
import org.fengjiening.office.enums.OfficeEnum;
import org.fengjiening.office.or.OfficeOr;
import org.fengjiening.word.model.WordOr;

/**
 * Created by fengjiening on 2020/9/4.
 */
public class WordFactory implements OfficeFactory{
    @Override
    public OfficeOr CreateOffice(OfficeEnum type) {
        switch (type) {
            case WORD:
                return WordOr.getInstance();
            case EXCEL:
                return ExcelOr.getInstance();
            default:
                throw new IllegalArgumentException("KingdomType not supported.");
        }
    }
}
