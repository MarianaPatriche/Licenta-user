package licenta.user.repository;

import licenta.user.entity.WorkDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by mariana on 04.06.2016.
 */
public interface WorkDayRepository extends JpaRepository<WorkDay, Long> {
    List<WorkDay> findByEmployeeUserUsernameAndDayBetween(String username, LocalDate start, LocalDate end);
}
