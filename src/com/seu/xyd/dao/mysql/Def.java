package com.seu.xyd.dao.mysql;



public class Def {
    public static final String T_USER = "T_user";
    public static final String T_ADMIN = "T_admin";
    public static final String T_GOODS = "T_goods";
    public static final String T_SHOP = "T_shop";
    public static final String T_EMPLOYER = "T_employer";
    public static final String T_ORDER = "T_order";
    public static final String T_ORDER_DETAIL = "T_order_detail";
    public static final String T_RECHARGE_RECORD = "T_recharge_record";
    public static final String T_CONSUMPTION = "T_consumption";
    public static final String T_RECEIVER_INFO = "T_receiver_info";
    public static final String T_GOODS_IMG = "T_goods_img";
    
    
 
    public static final String F_ID = "id";
    public static final String F_SHOP_ID = "shop_id";
    public static final String F_USER_ID = "user_id";
    public static final String F_GOODS_ID = "goods_id";
    public static final String F_ORDER_NUM = "order_num";
    public static final String F_ORDER_STATE = "order_state";
    
    public static final String[] USER_FIELDS = { "user_account", "user_pwd","user_email","user_phonenum",
    	"user_balance","user_bunus_flag","user_state","user_def_receiver_info_id"};
    
    public static final String[] ADMIN_FIELDS = {"adm_account","adm_name","adm_pwd"};
    
    public static final String[] GOODS_FIELDS = {"goods_name","shop_id","goods_price",
    	"goods_logo","goods_state"};
    
    public static final String[] SHOP_FIELDS = {"shop_name","shop_account","shop_pwd",
    	"shop_desc","shop_img","shop_addr_prov","shop_addr_city","shop_addr_area",
    	"shop_addr_desc","shop_coordinate_x","shop_coordinate_y","shop_phonenum","shop_state"};
    
    public static final String[] EMPLOYER_FIELDS = {"shop_id","employer_name",
    	"employer_sex","employer_birthday","employer_desc","employer_state"};
    
    public static final String[] ORDER_FIELDS = {"order_num","order_address","order_price_sum","order_createtime",
    	"user_id","shop_id","review_level","review_detail","review_flag","order_state"};
    
    public static final String[] ORDER_DETAIL_FIELDS = {"good_id","order_id","good_amount","order_detail_state"};
    
    public static final String[] RECHARGE_RECORD_FIELDS = {"user_id","recharge_date",
    	"recharge_amount","recharge_state"};
    
    public static final String[] CONSUMPTION_FIELDS = {"shop_id","consumption_name",
    	"consumption_amount","consumption_state"};
    
    public static final String[] RECEIVER_INFO_FIELDS = {"user_id","rec_name",
    	"rec_prov","rec_city","rec_area","rec_addr_detail","rec_phonenum","state"};
    
    public static final String[] GOODS_IMG_FIELDS = {"goods_id","img_url",
    	"img_desc","state"};
    
    
    
    public static String termSupportZero(String fieldName, long termValue) {
        if(termValue == 0) {
            return "1>0"; //一句不影响性能的废话条件
        } else {
            return fieldName + "=" + termValue;
        }
    }
    public static String termSupportMinusOne(String fieldName, long termValue) {
        if(termValue == -1) {
            return "1>0"; //一句不影响性能的废话条件
        } else {
            return fieldName + "=" + termValue;
        }
    }
    public static String termSupportZero(String fieldName, String termValue) {
        if(termValue.equals("-1")) {
            return "1>0"; //一句不影响性能的废话条件
        } else {
            return fieldName + "=" + termValue;
        }
    }

    
    
    public static String termLimits(int limits) {
        if (limits > 0)
            return "LIMIT " + limits;
        return "";
    }
}