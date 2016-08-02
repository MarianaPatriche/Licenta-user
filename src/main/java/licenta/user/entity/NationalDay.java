package licenta.user.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by mariana on 31.05.2016.
 */
@Entity
@Table(name = "national_day")
public class NationalDay extends AbstractAuditable{

    @Id
    @GeneratedValue(generator = "NATIONAL_DAY_SEQ_GEN", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "NATIONAL_DAY_SEQ_GEN", sequenceName = "NATIONAL_DAY_SEQ")
    private Long id;

    @Column(name = "day")
    private LocalDate day;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }
}
