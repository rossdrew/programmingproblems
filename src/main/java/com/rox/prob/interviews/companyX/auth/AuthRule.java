package com.rox.prob.interviews.companyX.auth;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
public interface AuthRule {
    boolean validates(String jsonString);
}
