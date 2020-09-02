package org.fengjiening.example;

import lombok.extern.slf4j.Slf4j;
import org.fengjiening.excel.ExcelEntityView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fengjiening on 2020/9/2.
 */
@Controller
@Slf4j
public class ControllerExcelFile
{
    private   List<User> list = new ArrayList<>();
    @PostConstruct
    public void init() {
        log.debug("PostConstruct  init");
        list.add(new User("上海", "小名", 17));
        list.add(new User("北京", "小红", 18));
        list.add(new User("深圳", "小蓝", 19));
        list.add(new User("广州", "小灰", 20));
        list.add(new User("杭州", "小黄", 21));
        list.add(new User("贵阳", "小白", 22));
    }
    @RequestMapping("/test")
    public ModelAndView test(){
        log.debug("test  导出Excel");
        ExcelEntityView excelEntityView =new ExcelEntityView(list, User.class,"","文件","标题");
        return new ModelAndView(excelEntityView);
    }
}
