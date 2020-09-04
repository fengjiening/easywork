package org.fengjiening.office.core;

import org.fengjiening.office.enums.OfficeEnum;
import org.fengjiening.office.or.OfficeOr;
import org.fengjiening.word.model.WordOr;

/**
 * Created by fengjiening on 2020/9/4.
 * wps 工厂
 */
public interface OfficeFactory {


    OfficeOr CreateOffice(OfficeEnum type);

}
