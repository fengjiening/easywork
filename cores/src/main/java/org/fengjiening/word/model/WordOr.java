package org.fengjiening.word.model;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.fengjiening.api.Result;
import org.fengjiening.exception.WorkException;
import org.fengjiening.office.or.OfficeOr;
import org.fengjiening.util.WordUtil;
import org.fengjiening.word.annotation.Title;
import org.fengjiening.word.annotation.Values;
import org.fengjiening.word.annotation.Word;

import javax.print.Doc;
import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;


/**
 * Created by fengjiening on 2020/9/4.
 */
@Slf4j
public class WordOr extends OfficeOr{

    private static volatile WordOr instance;

    private static boolean flag = true;
    /**
     * private constructor to prevent client from instantiating.
     */
    private WordOr() {
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
    public static WordOr getInstance() {
        WordOr result = instance;
        if (result == null) {
            // So to make sure we need to lock on an object to get mutual exclusion.
            synchronized (WordOr.class) {
                // Again assign the instance to local variable to check if it was initialized by some
                result = instance;
                if (result == null) {
                    instance = result = new WordOr();
                }
            }
        }
        return result;
    }

    public Result tempFile2Word( Class clazz,Object obj)throws WorkException{
        Class<?> aClass = null;
        try {
            aClass = Class.forName(clazz.getName());
        } catch (ClassNotFoundException e) {
            assert false:e.getMessage();
        }
        assert clazz!=null||obj !=null: "clazz or obj is null";
        //检查是否有word 注解
        assert clazz.isAnnotationPresent(Word.class):"no @Word annotation";
        //获取类注解信息

        Word doca = aClass.getAnnotation(Word.class);
        String fileName = doca.fileName();
        String trmpFile = doca.trmpFile();
        String fileTpe = doca.fileType();
        String newPath = doca.newPath();
        short bgColor= doca.bgColor();
        log.debug("doca 属性 {}",doca.fileName());
        assert new File(trmpFile).isFile()||new File(newPath).isDirectory():"trmpFile or trmpFile is invalid";

        Field[] declaredFields = clazz.getDeclaredFields();
        //判断该方法是否包含MyAnnotation注解
        Arrays.stream(declaredFields).forEach((field)->{
            if(field.isAnnotationPresent(Values.class)){
                // 获取注解值
                Map<String,Object> vmap =null;
                field.setAccessible(true);
                try {
                    vmap =(Map<String,Object>)field.get(obj);
                } catch (IllegalAccessException e) {
                    assert false:"no @Word annotation";
                }
                WordUtil.createWord(trmpFile,newPath,fileName,vmap);
            }
        });
        return Result.ok();

    }


}
