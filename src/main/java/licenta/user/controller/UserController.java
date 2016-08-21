package licenta.user.controller;

import licenta.user.model.ProfileModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mariana on 20.08.2016.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("profile")
    public String getProfile(Model model){
        model.addAttribute("profile", new ProfileModel());

        return "profile/form";
    }
}
