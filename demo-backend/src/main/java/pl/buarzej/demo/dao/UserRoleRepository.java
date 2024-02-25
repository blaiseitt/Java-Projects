package pl.buarzej.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.buarzej.demo.model.domain.UserRole;

@Transactional
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
