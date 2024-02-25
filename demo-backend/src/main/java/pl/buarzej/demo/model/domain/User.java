package pl.buarzej.demo.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

//import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    @Getter
    @Setter
    private String name;

    @Column(nullable = false)
    @Getter
    @Setter
    private String password;

    @Column(nullable = false)
    @JsonIgnore
    @Getter
    @Setter
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @Getter
    @Setter
    private Set<UserRole> userRole  = new HashSet<UserRole>(0);

    //private Date creationDate;

}
