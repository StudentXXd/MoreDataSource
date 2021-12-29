package com.fantasi.xxd.config;

/**
 * @author xxd
 * @date 2019/12/17 15:10
 */
public enum DBTypeEnum {
    db1Source("db1"),
    db2Source("db2")
    ;

    private String value;

    DBTypeEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
