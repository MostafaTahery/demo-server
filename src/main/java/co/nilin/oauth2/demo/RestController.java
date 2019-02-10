package co.nilin.oauth2.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.web.bind.annotation.RestController
public class RestController {

    @RequestMapping(value = "/login",method = RequestMethod.GET,params = {"clientId","username","password"},produces = "application/json",consumes = "application/json")
    public String login(@RequestParam("clientId") String clientId, @RequestParam("username") String username,@RequestParam("password") String password){


        return "";
    }
}
