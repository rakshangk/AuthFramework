package com.techmust.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController 
{

	@GetMapping ("/login")
	public String showMyLoginPage ()
	{
		return "Login";
	}
	
    /*
    @RequestMapping(value="/login/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity login(@RequestParam(value = "username", defaultValue = "World") String name) {
        return ResponseEntity.ok(createResponse(name));
    }*/
}
