package com.seu.xyd.system;

import com.tn17.logger.Logger;
import com.tn17.util.CommonUtil;

public class XYD {
    public final static Logger logger = Logger.getInstance("xyd", "com.seu.xyd.config.LoggerSetting");
    
    public final static String CONFIG_FILE = "com.seu.xyd.config.config";
    public final static String user = CommonUtil.getPropertyValue("host_user", CONFIG_FILE);
    public final static String root = CommonUtil.getPropertyValue("folder_" + user, CONFIG_FILE);
    
    public final static String ROOT_FOLDER = CommonUtil.getPropertyValue("folder_" + user, CONFIG_FILE);
    //public final static String IMG_FOLDER = ROOT_FOLDER + "portraits/";
    public final static String DOWNLOAD_FOLDER = ROOT_FOLDER +"download/";
    public final static String UP_FOLDER = ROOT_FOLDER +"upload/";
}
