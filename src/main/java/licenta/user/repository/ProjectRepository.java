package licenta.user.repository;


import licenta.user.entity.Project;
import licenta.user.util.ProjectStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mariana on 01.06.2016.
 */
public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByName(String name);

    List<Project> findByStatusNot(ProjectStatus status);
}