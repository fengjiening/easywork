package org.fengjiening;

import lombok.extern.slf4j.Slf4j;
import org.fengjiening.example.User;
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
public class tec
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
            list.add(new User("上海1", "小名", 17));
            list.add(new User("北京1", "小红", 18));
            list.add(new User("深圳1", "小蓝", 19));
            list.add(new User("广州1", "小灰", 20));
            list.add(new User("杭州1", "小黄", 21));
            list.add(new User("贵阳1", "小白", 22));
            // Step.3 AutoPoi 导出Excel
            ModelAndView mv = new ModelAndView(new ExcelEntityView(list,User.class,"c://","文件","这是一个标题"));
            return mv;
        }
}
