package org.fengjiening.excel;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.fengjiening.excel.view.ExcelAbstractExcelView;
import org.fengjiening.exception.WorkException;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.Map;

/**
 * Created by fengjiening on 2020/9/1.
 */
@Slf4j
public class ExcelEntityView  extends ExcelAbstractExcelView {

    private String fileName;
    private Collection exportList;
    private Class entityClass;
    private String path;
    private  ExportParams entity;

    /**
     * @param exportList 数据集
     * @param entityClass 实体class对象
     * @param path      保存位置
     * @param fileName 文件名
     * @param title 表格标题
     */
    public ExcelEntityView(Collection exportList ,Class entityClass,String path,String fileName,String title) {
        this.fileName=fileName;
        this.exportList=exportList;
        this.entityClass=entityClass;
        this.path=path;
        this.entity=new ExportParams();
        entity.setSecondTitle("系统生成");
        entity.setSheetName(fileName);
        entity.setTitle(title);
        entity.setHeaderColor((short)44);
    }

    /**
     * @param exportList 数据集
     * @param entityClass 实体class对象
     * @param path      保存位置
     * @param fileName 文件名
     * @param title 表格标题
     * @param createName 创建人
     */
    public ExcelEntityView(Collection exportList ,Class entityClass,String path,String fileName,String title,String createName) {
        this.fileName=fileName;
        this.exportList=exportList;
        this.entityClass=entityClass;
        this.path=path;
        this.entity=new ExportParams();
        entity.setSecondTitle(createName);
        entity.setSheetName(fileName);
        entity.setTitle(title);
        entity.setHeaderColor((short)44);
    }

    /**
     * @param exportList 数据集
     * @param entityClass 实体class对象
     * @param path      保存位置
     * @param fileName 文件名
     * @param title 表格标题
     * @param createName 创建人
     * @param sheetName sheet名字
     */
    public ExcelEntityView(Collection exportList ,Class entityClass,String path,String fileName,String title,String createName,String sheetName) {
        this.fileName=fileName;
        this.exportList=exportList;
        this.entityClass=entityClass;
        this.path=path;
        this.entity=new ExportParams();
        entity.setSecondTitle(createName);
        entity.setSheetName(sheetName);
        entity.setTitle(title);
        entity.setHeaderColor((short)44);
    }
    /**
     * @param exportList 数据集
     * @param entityClass 实体class对象
     * @param path      保存位置
     * @param fileName 文件名
     * @param title 表格标题
     * @param createName 创建人
     * @param sheetName sheet名字
     * @param headColor 表头背景
     */
    public ExcelEntityView(Collection exportList ,Class entityClass,String path,String fileName,String title,String createName,String sheetName,short headColor) {
        this.fileName=fileName;
        this.exportList=exportList;
        this.entityClass=entityClass;
        this.path=path;
        this.entity=new ExportParams();
        entity.setSecondTitle(createName);
        entity.setSheetName(sheetName);
        entity.setTitle(title);
        entity.setHeaderColor(headColor);
    }
    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Workbook workbook = null;
        if(fileName==null||exportList==null||entityClass==null||path==null) {
            log.error("请检查参数");
            throw new WorkException("请检查参数");
        }
        if(!new File(path).isDirectory()) {
            log.error("文件路径有误");
            throw new WorkException("文件路径有误");
        }
        workbook = ExcelExportUtil.exportExcel(entity, entityClass, exportList,null );
        String codedFileName=URLEncoder.encode(fileName, "UTF-8");
        if(workbook instanceof HSSFWorkbook) {
            codedFileName = codedFileName + ".xls";
        } else {
            codedFileName = codedFileName + ".xlsx";
        }
        response.setHeader("content-disposition", "attachment;filename=" + codedFileName);
        ServletOutputStream out = response.getOutputStream();
        workbook.write(out);
        out.flush();
    }

    /**
     * 生成文件
     * @throws Exception
     */
    public void toExcelFile() throws Exception {
        if(fileName==null||exportList==null||entityClass==null||path==null) {
            log.error("请检查参数");
            throw new WorkException("请检查参数");
        }
        if(!new File(path).isDirectory()) {
            log.error("文件路径有误");
            throw new WorkException("文件路径有误");
        }
        Workbook workbook = null;
        String[] exportFields = null;
        workbook = ExcelExportUtil.exportExcel(entity, entityClass, exportList, exportFields);
        String codedFileName=fileName;
        if(workbook instanceof HSSFWorkbook) {
            codedFileName = codedFileName + ".xls";
        } else {
            codedFileName = codedFileName + ".xlsx";
        }
        File file =new File(path+codedFileName);
        OutputStream out =new FileOutputStream(file);
        workbook.write(out);
        out.flush();
        out.close();
    }
}
