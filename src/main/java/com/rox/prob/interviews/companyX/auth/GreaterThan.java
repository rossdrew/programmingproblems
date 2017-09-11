package com.rox.prob.interviews.companyX.auth;

import org.json.JSONObject;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class GreaterThan implements AuthRule {
    private String key;
    private int greaterThanValue;

    public GreaterThan(String key, int value) {
        this.key = key;
        this.greaterThanValue = value;
    }

    @Override
    public boolean validates(String jsonString) {
        JSONObject json = new JSONObject(jsonString);

        Integer value = json.getInt(key);

        if (value.compareTo(greaterThanValue) > 0)
            return true;

        return false;
    }
}
