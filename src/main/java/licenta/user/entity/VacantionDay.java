package licenta.user.entity;

import org.joda.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/**
 * Created by mariana on 31.05.2016.
 */
@Entity
@Table(name = "VACANTION_DAY")
public class VacantionDay {

    @Id
    @GeneratedValue(generator = "VACANTION_DAY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "VACANTION_DAY_SEQ_GEN", sequenceName = "VACANTION_DAY_SEQ")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    @Column(name = "day")
    private LocalDate day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
