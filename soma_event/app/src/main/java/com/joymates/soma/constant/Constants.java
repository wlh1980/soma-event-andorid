package com.joymates.soma.constant;

import android.os.Environment;

import java.io.File;


public interface Constants {

    String PACKET_NAME = "com.soma.event";
    String SD_CARD_FOLDER_PATH = Environment.getExternalStorageDirectory()
            + File.separator + PACKET_NAME;// 在sd卡上建立的文件夹
    String IMAGE_CACHE_FOLDER = "/img_cache";// 图片缓存文
    String IMAGE_RES_FOLDER = "/img_res";// 图片资源文件
    String VIDEO_RES_DOWNLOAD = "/video";// 视频下载文件
    String INSTRUCTIONS_DOWNLOAD = "/book";// 说明书下载文件

    String VIDEO_COMPRESS_FILE = SD_CARD_FOLDER_PATH + "/compress";//压缩视频放置的位置

    String UPLOAD_PATH = SD_CARD_FOLDER_PATH + "/upload";

    // 数字+字母密码正则表达式
    String REGEX_PWD = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,15}";

    String NUMBER_STR_ZERO = "0";
    String NUMBER_STR_ONE = "1";

    int IS_PACKAGE = 1; // 套餐

    String SINGAPORE_CURRENCY = "s$"; // 新加坡货币符号

}
