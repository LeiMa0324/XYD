package com.seu.xyd.servlet;

import java.awt.print.Paper;

public enum XYDWebParam {
    NULL(""),
    OP("op"),
    NAME("name"),
    ACCOUNT("account"),
    PW("pw"),
    EMAIL("email"),
    PHONE("phone"),
    MAX_SIZE("max_size"),
    FILE_NAME("file_name"),
    DATE("date"),
    ID("id"),
    DESC("desc"),
    ADDR_PROV("addr_prov"),
    ADDR_CITY("addr_city"),
    ADDR_AREA("addr_area"),
    ADDR_DESC("addr_desc"),
    SHOP_ID("shop_id"),
    
    COOKIE_STRING("cookie_string"),
    ARRAY_STRING("array_string"),

    LNG("lng"),
    LAT("lat"),
    
  //张海越 
    PW_NEW("pw_new"),
    CHARHEMOPNEY("chargemoney"),
    REC_ID("rec_id"),
    RECPROV("recprov"), 
    RECCITY("reccity"), 
    RECAREA("recarea"), 
    RECADDRDETAIL("recaddrdetail"), 
    RECNAME("recname"), 
    RECPHONENUM("recphonenum"),
        
    //马蕾的代码
    KEYWORD("keyword"),
    EMPNAME_KEYWORD("empname_keyword"),
    ORDER_STATE("order_state"),
    BIRTHDAY("birthday"),
    
    //张雅南
    SEARCH_USER_KEYWORD("search_user_keyword"),
    USER_PAGE("user_page"),
    //程君添加的代码
    PAGE("page"),
    GOODSNAME("goodsname"),
    GOODPRICE("goodprice"),
    IMAGE("image"),
     GOODSIDS("goodsids"),
    NUM("num"),
    TYPE("type"),
    
    CODE("code"),
    DETAIL("detail"),
    ROUND_DAYS("round_days"),
    
    PROJECT_ID("pid"),
    CREATE_TIME("create_time"), 
    
    ;
    
    private final String name;
    
    XYDWebParam(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static XYDWebParam valueOfName(String name) {
        for (XYDWebParam one : XYDWebParam.values()) {
            if (one.getName().equals(name))
                return one;
        }
        assert false : "wrong name" + name;
        return NULL;
    }  
}
