package licenta.user.repository;


import licenta.user.entity.Specification;
import licenta.user.util.Priority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mariana on 11.09.2016.
 */
public interface SpecificationRepository extends JpaRepository<Specification, Long> {
    List<Specification> findByPriorityAndProjectId(Priority priority, Long projectId);
}
