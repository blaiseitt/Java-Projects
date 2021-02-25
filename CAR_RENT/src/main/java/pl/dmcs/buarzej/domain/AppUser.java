package pl.dmcs.buarzej.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "appuser")
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "appuser_id")
    private long id;

    @NotNull
    @Column(name = "firstName", nullable = false)
    @Size(min = 2, max = 30, message = "{error.size.firstName}")
    private String firstName;

    @NotNull
    @Size(min = 2, max = 50, message = "{error.size.lastName}")
    private String lastName;

    @NotNull
    @Pattern(regexp = "^\\d{2}-\\d{2}-\\d{4}$")
    private String birthday;

    @NotNull(message = "{error.field.required}")
    private String email;

    @Pattern(regexp = "^\\+\\d{2}-\\d{3}-\\d{3}-\\d{3}$", message = "{error.phone.incorrect}")
    private String telephone;

    @NotNull
    @Size(min = 3, max = 15)
    @Column(unique = true)
    private String login;

    @JsonIgnore
    @NotNull(message = "{error.field.required}")
    private String password;

    @ColumnDefault("false")
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUserRole> appUserRole = new HashSet<AppUserRole>(0);

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private AppUserDocuments appUserDocuments;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
    private List<Order> orderList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public AppUserDocuments getAppUserDocuments() {
        return appUserDocuments;
    }

    public void setAppUserDocuments(AppUserDocuments appUserDocuments) {
        this.appUserDocuments = appUserDocuments;
    }

    public Set<AppUserRole> getAppUserRole() {
        return appUserRole;
    }

    public void setAppUserRole(Set<AppUserRole> appUserRole) {
        this.appUserRole = appUserRole;
    }

    public void setDocuments(AppUserDocuments appUserDocuments) {
        this.appUserDocuments = appUserDocuments;
    }

}
