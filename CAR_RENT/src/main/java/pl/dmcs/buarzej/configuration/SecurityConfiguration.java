package pl.dmcs.buarzej.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.annotation.Resource;

@Configuration  //klasa konfiguracyjna
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
//zabezpieczenie uruchomienia poszczególnych metod
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Resource(name = "myAppUserDetailsService")
    //adnotacja resource odwołanie do serwisu zdefiniowanego już w kontekście aplikacji
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//dostarczenie menedżera uwierzytelniania
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "MANAGER", "USER");  //noop informacja dla modułu że hasło nie jest zaszyfrowane
        auth.inMemoryAuthentication().withUser("manager").password("{noop}manager").roles("MANAGER", "USER");
        auth.inMemoryAuthentication().withUser("user").password("{noop}user").roles("USER");

        //User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build();    //inny sposób tworzenia użytkownika domyślne kodowanie hasła
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();    //enkoder do szyfrowania hasła
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);   //budowa użytkownika w oparciu o user details service
        //dodane ponizej użytkownikow dodanych w pamięci, będą działały obie metody logowania
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//filtrowanie adresów URL, selekcja kto ma dostęp do jakiego adresu
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");    //kodowanie znaków dla filtru utf-8
        filter.setForceEncoding(true);
        http.addFilterBefore(filter, CsrfFilter.class);     //add filter before - kodowanie przed filtrowaniem

        http.authorizeRequests()
                .antMatchers("/appUsers*").access("hasRole('ADMIN') or hasRole('ROLE_MANAGER') or isAnonymous()")           //jeżeli pojawi się appUser + coś dalej to to zostanie sprawdzone
                // "hasRole('ADMIN')" is the same as "hasRole('ROLE_ADMIN')" and "hasAuthority('ROLE_ADMIN')"   //springexpressionLanguage jeżeli sprawdzamy kogoś konkretną role to są 3 sposoby
                //1wszy sposób "hasRole" "ROLE_Nazwaroli"    "hasAuthority" -->nadrzędna klasa
                // "hasRole('ADMIN')" is the same as "hasRole('ROLE_ADMIN')" and "hasAuthority('ROLE_ADMIN')" tylko administrator może dodawać role
                .antMatchers("/appUserRole*").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/carsManagement*").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                //.and().formLogin().permitAll(); // with default login page
                .and().formLogin().loginPage("/login").permitAll() //wskazanie na stronę logowania with custom login page, wszyscy użytkownicy mają dostęp do tego widoku permitAll
//
                .usernameParameter("login").passwordParameter("password")//tutaj ewentualnie później zrobi się opcję logowania za pomocą e-maila
                .failureForwardUrl("/login.html?error")//co się stanie gdy błędne dane logowania
                .and().logout().logoutSuccessUrl("/login.html?logout") //poprawne wylogowanie z aplikacji
                .and().exceptionHandling().accessDeniedPage("/accessDenied");
    }
}
