package org.fengjiening.example;

import org.fengjiening.excel.ExcelEntityView;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;


/**
 * Unit test for simple App.
 */
public class GenExcelFile
{
    public static List<User> list = new ArrayList<>();
    static {
        list.add(new User("上海", "小名", 17));
        list.add(new User("北京", "小红", 18));
        list.add(new User("深圳", "小蓝", 19));
        list.add(new User("广州", "小灰", 20));
        list.add(new User("杭州", "小黄", 21));
        list.add(new User("贵阳", "小白", 22));
    }
    @Test
    public void testExe() throws Exception {
        //模拟数据 fileName,Collection exportList ,Class entityClass,String path
        new ExcelEntityView(list,User.class,"c://","文件","这是一个标题").toExcelFile();
    }
}
