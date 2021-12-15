package com.aws.proserve.mad.common.util;

import com.google.gson.Gson;

/**
 * JSON工具类；
 */
public class JsonUtils {
    public static String toJson(Object obj) {
        return new Gson().toJson(obj);
    }
}
