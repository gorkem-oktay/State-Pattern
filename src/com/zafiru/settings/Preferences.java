package com.zafiru.settings;

import java.util.HashMap;

public class Preferences {

    private static Preferences instance;
    private HashMap<String, Object> cache;

    private Preferences() {
        cache = new HashMap<>();
    }

    public static Preferences getInstance() {
        if (instance == null) {
            instance = new Preferences();
        }
        return instance;
    }

    public void set(String key, Object value){
        cache.put(key, value);
    }

    public Object get(String key) {
        return cache.get(key);
    }
}
