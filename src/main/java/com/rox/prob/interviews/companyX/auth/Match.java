package com.rox.prob.interviews.companyX.auth;

import org.json.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class Match implements AuthRule {
    private String key;
    private Pattern matchExpression;

    public Match(String key, String matchExpression) {
        this.key = key;
        this.matchExpression = Pattern.compile(matchExpression);
    }

    @Override
    public boolean validates(String jsonString) {
        JSONObject json = new JSONObject(jsonString);
        String toMatch = json.getString(key);

        Matcher m = matchExpression.matcher(toMatch);
        return m.matches();
    }
}
