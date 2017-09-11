package com.rox.prob.interviews.companyX.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author rossdrew
 * @Created 12/07/16.
 */
@Controller
public class AuthController {
    @RequestMapping(value = "/authorise", method = RequestMethod.POST)
    public @ResponseBody String authorise(){
        return "TEST";
        //TODO
    }
}
