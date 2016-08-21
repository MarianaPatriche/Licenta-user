package licenta.user.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Created by mariana on 31.05.2016.
 */
@Entity
@Table(name = "work_day")
public class WorkDay {

    @Id
    @GeneratedValue(generator = "WORK_DAY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "WORK_DAY_SEQ_GEN", sequenceName = "WORK_DAY_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "PROJECT_ID")
    private Project project;

    @Column(name = "day")
    private LocalDate day;

    @Column(name = "hours")
    private Integer hours;

    @Column(name = "details")
    private String details;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
