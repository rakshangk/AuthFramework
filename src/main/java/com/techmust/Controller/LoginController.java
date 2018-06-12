package com.techmust.Controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController 
{

	@GetMapping ("/login")
	public String showMyLoginPage ()
	{
		return "Login";
	}
	
    
    @RequestMapping(value="/loginReturn/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity login(@RequestParam(value = "username", defaultValue = "World") String name) {
        return ResponseEntity.ok(createResponse(name));
    }
    
    private String createResponse(String name) {
        return new JSONObject().put("Output", String.format(name)).toString();
    }
}
