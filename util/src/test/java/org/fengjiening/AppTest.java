package org.fengjiening;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;
import org.fengjiening.example.User;
import org.fengjiening.excel.ExcelEntityView;
import org.fengjiening.util.DozerUtil;
import org.junit.Test;

import java.util.*;


/**
 * Unit test for simple App.
 */
@Slf4j
public class AppTest 
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
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testExe() throws Exception {
        //模拟数据 fileName,Collection exportList ,Class entityClass,String path
        new ExcelEntityView(list,User.class,"文件","文件","这是一个标题").toExcelFile();
    }

    @Test
    public void transfor()
    {
        User a=new User("上海", "小名", 17);
        User b=DozerUtil.transfor(a,User.class);
        log.debug("转换属性后对象-{}",b.toString());

    }
}
