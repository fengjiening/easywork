package org.fengjiening.excel.view;

import org.springframework.web.servlet.view.AbstractView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by fengjiening on 2020/9/1.
 */
public class ExcelAbstractExcelView  extends AbstractView {
    private static final String CONTENT_TYPE = "application/vnd.ms-excel";
    protected static final String HSSF = ".xls";
    protected static final String XSSF = ".xlsx";

    public ExcelAbstractExcelView() {
        this.setContentType("application/vnd.ms-excel");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception{

    };

    protected boolean isIE(HttpServletRequest request) {
        return request.getHeader("USER-AGENT").toLowerCase().indexOf("msie") > 0 || request.getHeader("USER-AGENT").toLowerCase().indexOf("rv:11.0") > 0;
    }
}
