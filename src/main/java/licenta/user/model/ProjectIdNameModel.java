package licenta.user.model;

/**
 * Created by mariana on 02.06.2016.
 */
public class ProjectIdNameModel {

    private Long id;

    private String name;

    public ProjectIdNameModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProjectIdNameModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
