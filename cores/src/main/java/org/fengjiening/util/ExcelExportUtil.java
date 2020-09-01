package org.fengjiening.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.enmus.ExcelType;
import org.jeecgframework.poi.excel.entity.params.ExcelExportEntity;
import org.jeecgframework.poi.excel.export.ExcelExportServer;
import org.jeecgframework.poi.excel.export.template.ExcelExportOfTemplateUtil;

/**
 * Created by fengjiening on 2020/9/1.
 */
public final class ExcelExportUtil {
    private ExcelExportUtil() {
    }

    public static Workbook exportExcel(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet, String[] exportFields) {
        Object workbook;
        if(ExcelType.HSSF.equals(entity.getType())) {
            workbook = new HSSFWorkbook();
        } else if(dataSet.size() < 1000) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new SXSSFWorkbook();
        }

        (new ExcelExportServer()).createSheet((Workbook)workbook, entity, pojoClass, dataSet, exportFields);
        return (Workbook)workbook;
    }

    public static Workbook exportExcel(ExportParams entity, Class<?> pojoClass, Collection<?> dataSet) {
        Object workbook;
        if(ExcelType.HSSF.equals(entity.getType())) {
            workbook = new HSSFWorkbook();
        } else if(dataSet.size() < 1000) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new SXSSFWorkbook();
        }

        (new ExcelExportServer()).createSheet((Workbook)workbook, entity, pojoClass, dataSet, (String[])null);
        return (Workbook)workbook;
    }

    public static Workbook exportExcel(ExportParams entity, List<ExcelExportEntity> entityList, Collection<? extends Map<?, ?>> dataSet) {
        Object workbook;
        if(ExcelType.HSSF.equals(entity.getType())) {
            workbook = new HSSFWorkbook();
        } else if(dataSet.size() < 1000) {
            workbook = new XSSFWorkbook();
        } else {
            workbook = new SXSSFWorkbook();
        }

        (new ExcelExportServer()).createSheetForMap((Workbook)workbook, entity, entityList, dataSet);
        return (Workbook)workbook;
    }

    public static Workbook exportExcel(List<Map<String, Object>> list, String type) {
        Object workbook;
        if(ExcelType.HSSF.equals(type)) {
            workbook = new HSSFWorkbook();
        } else {
            workbook = new XSSFWorkbook();
        }

        Iterator var3 = list.iterator();

        while(var3.hasNext()) {
            Map<String, Object> map = (Map)var3.next();
            ExcelExportServer server = new ExcelExportServer();
            server.createSheet((Workbook)workbook, (ExportParams)map.get("title"), (Class)map.get("entity"), (Collection)map.get("data"), (String[])null);
        }

        return (Workbook)workbook;
    }

    public static Workbook exportExcel(TemplateExportParams params, Class<?> pojoClass, Collection<?> dataSet, Map<String, Object> map) {
        return (new ExcelExportOfTemplateUtil()).createExcleByTemplate(params, pojoClass, dataSet, map);
    }

    public static Workbook exportExcel(TemplateExportParams params, Map<String, Object> map) {
        return (new ExcelExportOfTemplateUtil()).createExcleByTemplate(params, (Class)null, (Collection)null, map);
    }
}
