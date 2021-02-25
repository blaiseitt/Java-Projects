package pl.dmcs.buarzej.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private long id;

    private int version;

    @NotNull
    private int days;

    @ManyToOne
    @JoinColumn(name = "appuser_id", nullable = false)
    private AppUser appUser;

    @OneToMany
    private Set<CarOwned> carOwnedSet;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Set<CarOwned> getCarOwnedSet() {
        return carOwnedSet;
    }

    public void setCarOwnedSet(Set<CarOwned> carOwnedSet) {
        this.carOwnedSet = carOwnedSet;
    }
}
