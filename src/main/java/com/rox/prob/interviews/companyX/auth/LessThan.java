package com.rox.prob.interviews.companyX.auth;

import org.json.JSONObject;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class LessThan implements AuthRule {
    private String key;
    private int lessThanValue;

    public LessThan(String key, int value) {
        this.key = key;
        this.lessThanValue = value;
    }

    @Override
    public boolean validates(String jsonString) {
        JSONObject json = new JSONObject(jsonString);

        Integer value = json.getInt(key);

        if (value.compareTo(lessThanValue) < 0)
            return true;

        return false;
    }
}
