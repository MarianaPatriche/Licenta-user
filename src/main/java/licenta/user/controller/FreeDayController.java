package licenta.user.controller;


import licenta.user.model.FreeDayModel;
import licenta.user.service.FreeDayService;
import licenta.user.util.FreeDayType;
import licenta.user.validator.VacationDayValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;

/**
 * Created by mariana on 04.06.2016.
 */
@Controller
@RequestMapping("/freeDay")
public class FreeDayController extends BaseController{

    @Autowired
    public FreeDayService freeDayService;

    @Autowired
    public VacationDayValidator vacationDayValidator;

    @RequestMapping("/form")
    public String form(Model model){
        model.addAttribute("freeDayModel", new FreeDayModel());
        model.addAttribute("dayType", Arrays.asList(FreeDayType.values()));

        return "freeDay/form";
    }

    @RequestMapping("/save")
    public String save(@Valid @ModelAttribute("freeDayModel") FreeDayModel freeDayModel,
                       BindingResult bindingResult, Model model){
        vacationDayValidator.validate(freeDayModel, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("freeDayModel", freeDayModel);
            model.addAttribute("dayType", Arrays.asList(FreeDayType.values()));
            return "freeDay/form";
        }
        freeDayService.save(freeDayModel);
        return "redirect:/freeDay/form";
    }

}
