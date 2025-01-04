package pl.dmcs.buarzej.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.buarzej.domain.AppUser;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RegistrationTokenRepository extends JpaRepository<RegistrationToken, Long> {
    RegistrationToken findByRegistrationToken(String registrationToken);

    RegistrationToken findByAppUser(AppUser appUser);
}
