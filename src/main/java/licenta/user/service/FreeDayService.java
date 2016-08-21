package licenta.user.service;

import licenta.user.entity.Employee;
import licenta.user.entity.SickDay;
import licenta.user.entity.VacantionDay;
import licenta.user.model.FreeDayModel;
import licenta.user.repository.EmployeeRepository;
import licenta.user.repository.SickDayRepository;
import licenta.user.repository.VacantionDayRepository;
import licenta.user.util.Auth;
import licenta.user.util.DateUtils;
import licenta.user.util.FreeDayType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by mariana on 04.06.2016.
 */
@Service
@Transactional
public class FreeDayService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private VacantionDayRepository vacantionDayRepository;

    @Autowired
    private SickDayRepository sickDayRepository;

    public void save(FreeDayModel freeDayModel){
        if(freeDayModel.getType().equals(FreeDayType.SICK_DAY)){
            saveSickDay(freeDayModel);
        }
        else{
            saveVacationDay(freeDayModel);
        }
    }

    private void saveSickDay(FreeDayModel freeDayModel){
        Employee employee = employeeRepository.findByUserUsername(Auth.userLoggedIn());
        SickDay sickDay = new SickDay();
        sickDay.setDay(DateUtils.toLocalDate(freeDayModel.getDate()));
        sickDay.setEmployee(employee);

        employee.setSickDays(employee.getSickDays() - 1);
        employeeRepository.save(employee);

        sickDayRepository.save(sickDay);
    }

    private void saveVacationDay(FreeDayModel freeDayModel){
        Employee employee = employeeRepository.findByUserUsername(Auth.userLoggedIn());
        VacantionDay vacationDay = new VacantionDay();
        vacationDay.setDay(DateUtils.toLocalDate(freeDayModel.getDate()));
        vacationDay.setEmployee(employee);

        employee.setVacantionDays(employee.getVacantionDays() - 1);
        employeeRepository.save(employee);

        vacantionDayRepository.save(vacationDay);
    }
}
