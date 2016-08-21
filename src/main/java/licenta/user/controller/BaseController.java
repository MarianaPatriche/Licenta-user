package licenta.user.controller;


import licenta.user.util.Auth;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Created by mariana on 01.06.2016.
 */
public class BaseController {

    @ModelAttribute("userLoggedIn")
    public String getUserLoggedIn(){
        return Auth.userLoggedIn();
    }
}
