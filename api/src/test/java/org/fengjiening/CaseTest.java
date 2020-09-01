package org.fengjiening;

import lombok.extern.slf4j.Slf4j;
import org.fengjiening.enums.TotalOperator;
import org.junit.Test;

/**
 * Created by fengjiening on 2020/9/1.
 */
@Slf4j
public class CaseTest {

    @Test
    public void test(){
        /**
         * 获取某一值是否在某一个范围内 传统做法 系统中会有大量的IFelse
         * If a value is in a certain range, there will be a large number of ifels in the traditional system
         *
         * 使用 枚举方法改变代码的冗余
         * Using enumeration method to change code redundancy
         */
        TotalOperator writeOperator = TotalOperator.codeOf(0);
        log.debug("获取某一个操作：{}",writeOperator.getType());
        log.debug("操作结果：{}", TotalOperator.contains(1,writeOperator));

        log.debug("=============================================");

        TotalOperator writeOperator1 = TotalOperator.codeOf(4);
        log.debug("获取某一个操作：{}",writeOperator1.getType());
        log.debug("操作结果：{}", TotalOperator.contains(1,writeOperator1));

    }


    @Test
    public void normal(){
        int cases=0;
        if(cases==1){
            //todo 执行 cases=1 的时候逻辑

            // pass
        }else if(cases==2){
            //todo 执行 cases=1 的时候逻辑

            // pass
        }else if(cases==3){
            //todo 执行 cases=1 的时候逻辑

            // pass
        }else if(cases==4){
            //todo 执行 cases=1 的时候逻辑

            // pass
        }else if( cases>4 && cases<=10 ){
            //todo 执行 cases=1 的时候逻辑

            // pass
        }else if( cases>10 && cases<50 ){
            //todo 执行 cases=1 的时候逻辑
            // pass
        }else{
            //todo 执行 cases其他 的时候逻辑

            // pass
        }

    }
}
