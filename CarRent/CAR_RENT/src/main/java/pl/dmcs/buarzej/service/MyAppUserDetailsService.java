package pl.dmcs.buarzej.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.buarzej.domain.AppUserRole;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("myAppUserDetailsService")
public class MyAppUserDetailsService implements UserDetailsService {

    private AppUserService appUserService;

    //wstrzykiwanie zależości serwisu użytkownika, wyciąganie danych za pomocą metod serwisowych
    @Autowired
    public MyAppUserDetailsService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
        //użytkownik na podstawie naszych danych wykorzystywany przez spring security
        pl.dmcs.buarzej.domain.AppUser appUser = appUserService.findByLogin(login); //budowanie obiektu użytkownika na podstawie loginu
        List<GrantedAuthority> authorities = buildUserAuthority(appUser.getAppUserRole());  //budowa listy uwierzytelnień danego uzytkownika
        return buildUserForAuthentication(appUser, authorities);    //obiekt user details zwracany
    }

    // Converts AppUser user to org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(pl.dmcs.buarzej.domain.AppUser appUser, List<GrantedAuthority> authorities) {
//na podstawie przychodzących argumentow, appuser, lista ról -->budejmy obiekt konkretnego użytkownika springSecurity
        return new User(appUser.getLogin(), appUser.getPassword(), appUser.isEnabled(),
                true, true, true, authorities);
        //wskazanie userName, wskazanie hasła, czy użytkownik ma prawa człowieka
        //do wykorzystania przy rejestracji wtedy kiedy false to wysyła się maila z tokenem aktywującym
    }

    private List<GrantedAuthority> buildUserAuthority(Set<AppUserRole> appUserRoles) {
//
        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
        // Build user's authorities
        for (AppUserRole appUserRole : appUserRoles) {
            setAuths.add(new SimpleGrantedAuthority(appUserRole.getRole()));
        }
        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
        return result;
    }
}
