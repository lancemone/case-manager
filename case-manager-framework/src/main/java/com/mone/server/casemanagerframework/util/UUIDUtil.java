package com.mone.server.casemanagerframework.util;

import java.util.UUID;

/**
 * @Description
 * @Classname UUIDUtil
 * @auther motao
 * @create 2020-07-06 18:06
 */
public class UUIDUtil {

    public static String getUuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
}
