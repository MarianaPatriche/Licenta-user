package licenta.user.repository;


import licenta.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by mariana on 01.06.2016.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByEnabledTrueAndUsernameContaining(String a);

    User findByUsername(String username);
}
