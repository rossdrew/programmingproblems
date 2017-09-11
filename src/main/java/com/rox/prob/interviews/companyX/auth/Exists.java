package com.rox.prob.interviews.companyX.auth;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public class Exists implements AuthRule {
    private String requiredKey = "";

    public Exists(String requiredKey){
        this.requiredKey = requiredKey;
    }

    public boolean validates(String jsonString){
        JSONObject json = new JSONObject(jsonString);
        JSONArray names = json.names();

        for (int i=0; i< names.length(); i++){
            if (names.getString(i).compareTo(requiredKey)==0) {
                return true;
            }
        }

        return false;
    }
}
