package org.fengjiening.example;

import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;

/**
 * Created by fengjiening on 2020/9/1.
 */
@Data
public class User {

    @Excel(name = "姓名", width = 15)
    private String name;

    @Excel(name = "地址", width = 15)
    private String addr;

    @Excel(name = "编号", width = 15)
    private Integer no;

    public User(String addr,String name,  Integer no) {
        this.name = name;
        this.addr = addr;
        this.no = no;
    }
}
