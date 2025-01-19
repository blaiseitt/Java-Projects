package pl.dmcs.buarzej.dao;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.buarzej.domain.AppUser;

@Transactional
//wszystkie metody tutaj zdefiniowane traktowane jako tranzakcyjne
@Repository
//adnotacja repostory (jedna z 3 głównych adnotacji obok Service i Controler), dziedziczy po klasie component
public interface AppUserRepository extends JpaRepository<AppUser, Long> {   //ponad 60 metod CRUD-owych dla bazy danych
    //możemy wykorzystać dynamiczne findery
    //obiekt typu AppUser, typ klucza - long
    List<AppUser> findByLastName(String lastName);

    AppUser findById(long id);

    AppUser findByLogin(String login);

    AppUser findByEmail(String email);
}           //zdefiniowane dynamiczne findery
