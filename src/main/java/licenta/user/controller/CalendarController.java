package licenta.user.controller;

import licenta.user.model.ProjectCalendarModel;
import licenta.user.service.CalendarService;
import licenta.user.util.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by mariana on 04.06.2016.
 */
@Controller
@RequestMapping("/calendar")
public class CalendarController extends BaseController{

    @Autowired
    private CalendarService calendarService;

    @RequestMapping("/projects")
    public String getProjectCalendar(){
        return "calendar/userProject";
    }

    @RequestMapping("/projects/data")
    @ResponseBody
    public List<ProjectCalendarModel> getProjectCalendarData(@RequestParam(name = "date", required = false) String date) throws Exception{
        if(date != null) {
            if(date.length() < 10){
                date = date.substring(0,3) + "0" + date.substring(3, date.length());
            }
            return calendarService.getProjectCalendarForUser(DateUtils.toLocalDate(date));
        }
        return calendarService.getProjectCalendarForUser(LocalDate.now());
    }
}
