package com.rox.prob.codingbat;

import java.util.Map;

/**
 * Basic Map get()/put(), no loops. See the Java Map Introduction for help.
 */
public class Map1 {
    /**
     * Modify and return the given map as follows: if the key "a" has a value, set the key "b" to
     * have that value, and set the key "a" to have the value "". Basically "b" is a bully, taking
     * the value of "a".
     *
     * mapBully({"b": "dirt", "a": "candy"}) → {"b": "candy", "a": ""}
     * mapBully({"a": "candy"}) → {"b": "candy", "a": ""}
     * mapBully({"b": "carrot", "c": "meh", "a": "candy"}) → {"b": "candy", "c": "meh", "a": ""}
     */
    public Map<String, String> mapBully(Map<String, String> map) {
        String a = map.get("a");

        if (a!=null && !a.isEmpty()){
            map.put("b", a);
            map.put("a", "");
        }

        return map;
    }

    /**
     * Modify and return the given map as follows: if the key "a" has a value, set the key "b" to
     * have that same value. In all cases remove the key "c", leaving the rest of the map unchanged.
     *
     * mapShare({"b": "bbb", "c": "ccc", "a": "aaa"}) → {"b": "aaa", "a": "aaa"}
     * mapShare({"b": "xyz", "c": "ccc"}) → {"b": "xyz"}
     * mapShare({"d": "hi", "c": "meh", "a": "aaa"}) → {"d": "hi", "b": "aaa", "a": "aaa"}
     */
    public Map<String, String> mapShare(Map<String, String> map) {
        String a = map.get("a");

        if (a!=null && !a.isEmpty()){
            map.put("b", a);
        }

        map.remove("c");
        return map;
    }

    /**
     * Modify and return the given map as follows: for this problem the map may or may
     * not contain the "a" and "b" keys. If both keys are present, append their 2 string
     * values together and store the result under the key "ab".
     *
     * mapAB({"b": "There", "a": "Hi"}) → {"b": "There", "a": "Hi", "ab": "HiThere"}
     * mapAB({"a": "Hi"}) → {"a": "Hi"}
     * mapAB({"b": "There"}) → {"b": "There"}
     */
    public Map<String, String> mapAB(Map<String, String> map) {
        return null; //TODO
    }


}
