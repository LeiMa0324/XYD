package com.seu.xyd.servlet;

public enum XYDWebOP {
    OP("op"),
    SIGIN("sigin"),
    LOGOUT("logout"),
    REGISTER("register"),
    REGISTER2("register2"),
    FIND_PWD_STEP1("find_pwd_step1"),
    FIND_PWD_STEP2("find_pwd_step2"),
    FIND_PWD_STEP3("find_pwd_step3"),
    GET_NEARBY_SHOP("get_nearby_shop"),
    GET_GOODS_LIST_BY_COOKIE("get_goods_list_by_cookie"),
    
    //张海越添加修改会员信息代码
    MODIFY_INFO("modify_info"),
    MODIFY_PWD("modify_pwd"),
    GET_USERINFO("get_userinfo"),
    GET_RECORD_LIST("get_record_list"),
    CHARGE_MONEY("charge_money"),
    GET_ADDERSS_LIST("get_addres_list"),
    MAKE_DEFAULT_ADDRESS("make_default_address"),
    DELETE_ADDRESS("delete_address"),
    MODIFY_ADDRESS("modify_address"),
    ADD_ADDRESS("add_address"),
    GET_ADDRESS_BY_ID("get_addres_by_id"),
    //分隔线
    
    
    
    
    ADD_NEW_USER("add_new_user"),
    GET_USER_LIST("get_user_list"),
    
    
    GET_ORDER_LIST_BY_SHOP_ID("get_order_list_by_shop_id"),
    //马蕾的代码
    GET_ORDER_LIST_BY_SHOP_ID_AND_KEYWORD("get_order_list_by_shop_id_and_keyword"),
    GET_ORDER_LIST_BY_SHOP_ID_AND_ORDER_STATE("get_order_list_by_shop_id_and_order_state"),
    GET_ORDER_BY_ID("get_orderby_id"),
    
    GET_GOODS_LIST_BY_SHOP_ID("get_goods_list_by_shop_id"),
    UPDAYE_ORDER_STATE_BY_ORDER_ID_AND_TARGET_STATE("update_order_state_by_order_id_and_target_state"),

    ADD_NEW_ORDER("add_new_order"),

    GET_EMPLOYER_LIST_BY_SHOP_ID_AND_KEYWORD("get_employer_list_by_shop_id_and_keyword"),

    
    //程君添加的代码
    UPDATA_GOODS_INFO_BY_GOODSID("updata_goods_info_by_goodsId"),
    GET_GOODS_WITH_PAGE("get_goods_with_page"),
    ADD_GOOD_TO_SHOP ("add_good_to_shop"),
    DELETE_GOODS_BY_GOODSID("delete_goods_by_goodsId"),
    GET_SHOP_INFO("get_shop_info"),
    UPDATA_SHOP_INFO("updata_shop_info"),
    //分割线
    
   //张雅南
    GET_USER_WITH_ADMIN("get_user_with_admin"),
    GET_USER_LIST_BY_KEYWORD("getUserListByKeyword"),
    GET_SHOP_LIST_BY_KEYWORD("get_Shop_List_By_Keyword"),
    GET_SHOP_WITH_ADMIN("get_All_Shops"),
    GET_SHOP_BY_ID("get_shop_by_id"),
    //
    UPLOAD("upload"),
    DELETE_UPLOADED_FILE("duf"),
    DOWNLOAD_MODEL("download_model"),
    DO_IMPORTING("do_importing"),
    GET_IMPORT_RATE("get_import_rate"),
    
    GET_NO_IMPORT_DATA_30_DAYS("get_no_import_data_30_days"), 
    ;
    
    
    private final String name;
    
    XYDWebOP(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static XYDWebOP valueOfName(String name) {
        for (XYDWebOP one : XYDWebOP.values()) {
            if (one.getName().equals(name))
                return one;
        }
        assert false : "wrong name"+name;
        return null;
    }
}
