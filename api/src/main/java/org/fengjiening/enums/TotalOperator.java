package org.fengjiening.enums;

/**
 * Created by fengjiening on 2020/8/31.
 * 总时长判断
 */
public enum TotalOperator {

    Zero (0,"zero") {
        @Override
        public boolean apply(int a) {
            return 0==a;
        }
    },
    One(1,"one"){
        @Override
        public boolean apply(int a) {
            return a<=60 &&  a>0;
        }
    },
    Two(2,"two"){
        @Override
        public boolean apply(int a) {
            return a<=120 &&  a>60;
        }
    },
    Three(3,"three"){
        @Override
        public boolean apply(int a) {
            return a<=5*60 &&  a>2*60;
        }
    },
    Four(4,"four"){
        @Override
        public boolean apply(int a){
            return  a>5*60;
        }
    };

    public abstract boolean apply(int a);
    public static TotalOperator codeOf(int code){
        TotalOperator[] list = values();
        for(TotalOperator en : values()){
            if(en.getCode() == code){
                return en;
            }
        }
        throw new RuntimeException("没有找到对应的枚举");
    }

    private int code;
    private String type;
    TotalOperator(int code,String type){
        this.code = code;
        this.type = type;
    }
    public int getCode() {
        return code;
    }
    public String getType(){return type;}
    public static boolean contains(int a,TotalOperator operator) {
        return operator.apply(a);
    }
}
