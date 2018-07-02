package com.techmust.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Basic Spring web service controller that handles all GET requests.
 */
@RestController
public class LoginController 
{
       @RequestMapping(value="/signIn", method = RequestMethod.POST)
        public String authenticate(@RequestParam(value = "username") String strUserName, @RequestParam(value = "password") String strPassword) 
        {
            return "User: Successfully logged in!";
        }
}