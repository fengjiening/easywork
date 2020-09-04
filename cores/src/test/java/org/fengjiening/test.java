package org.fengjiening;


import lombok.extern.slf4j.Slf4j;
import org.apache.poi.hwpf.HWPFDocument;
import org.checkerframework.checker.units.qual.C;
import org.fengjiening.exception.WorkException;
import org.fengjiening.office.core.OfficeFactory;
import org.fengjiening.office.enums.OfficeEnum;
import org.fengjiening.office.factory.WordFactory;
import org.fengjiening.office.or.OfficeOr;
import org.fengjiening.util.WordUtil;
import org.fengjiening.word.annotation.Title;
import org.fengjiening.word.annotation.Word;
import org.fengjiening.word.model.WordOr;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.rmi.ServerError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by fengjiening on 2020/9/1.
 */
@Slf4j
public class test {
    @Test
   public void test(){
        System.err.println(121);
    }

    @Test
    public void test1() throws WorkException {
        Doc doc =new Doc();
        doc.setTitle("dddd");
        //获取AnnotationTest2的Class实例
        Class<Doc> c = Doc.class;

        //检查是否有word 注解
        if (!c.isAnnotationPresent(Word.class)) throw new WorkException("no @Word annotation");
        //获取类注解信息
        Word doca = c.getAnnotation(Word.class);
        log.debug("doca 属性 {}",doca.fileName());


        //获取需要处理的方法Method实例
        //Method method = c.getMethod("execute", new Class[]{});
        Field[] declaredFields = c.getDeclaredFields();
        Method[] methods = c.getMethods();
        //判断该方法是否包含MyAnnotation注解
        Arrays.stream(declaredFields).forEach((field)->{

            if(field.isAnnotationPresent(Title.class)){
                Title title = field.getAnnotation(Title.class);
                // 获取注解值
               // boolean annValue = title.bold();
                //log.debug("获取注解 值{} ",annValue);
                //获取注解字段值
                String name =null;
                field.setAccessible(true);
                try {
                    name =field.get(doc).toString();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
                log.debug("字段名{}===字段值 {}",field.getName(),name);


            }

        });

    }
    @Test
    public void tWord() throws WorkException {
        HashMap<String, Object> params = new HashMap<>();
        // 渲染文本
        params.put("name", "XXX工程");
        params.put("no", "123456");
        DocTemp temp =new DocTemp();
        temp.setValues(params);

        Class<DocTemp> c = DocTemp.class;
        //创建工厂
        WordOr wordOr =(WordOr) new WordFactory().CreateOffice(OfficeEnum.WORD);
        wordOr.tempFile2Word(DocTemp.class,temp);
    }
}
