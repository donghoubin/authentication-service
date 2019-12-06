package com.mike.authentication.util;

import com.alibaba.fastjson.JSONObject;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/1 15:22.
 */
public class CacheJWT {
    private static ConcurrentHashMap<String, Object> cacheMap = new ConcurrentHashMap<>();

    /**
     * 获取缓存的对象
     *
     * @param account
     * @return
     */
    public static Object getCache(String account) {
        JSONObject jsonObject = new JSONObject();
        // 如果缓冲中有该账号，则返回value
        if (cacheMap.containsKey(account)) {
            jsonObject.put("state", 1);
            jsonObject.put("account", cacheMap.get(account));
        } else {
            jsonObject.put("state", 0);
        }
        return jsonObject;
    }

    /**
     * 设置缓存
     *
     * @param key
     */
    public static void setCache(String key, Object value) {
        // 一般是进行数据库查询，将查询的结果进行缓存
        cacheMap.put(key, value);
    }

    /**
     * 移除缓存信息
     *
     * @param account
     */
    public static void removeCache(String account) {
        cacheMap.remove(account);
    }
}
