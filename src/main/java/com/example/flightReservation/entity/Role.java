package com.example.flightReservation.entity;
import com.example.flightReservation.entity.common.AbstractEntity;
//import org.springframework.security.core.GrantedAuthority;
import javax.persistence.*;
import java.util.Set;

                                       //implements GrantedAuthority
@Entity
public class Role extends AbstractEntity  {
    private String name;
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String getAuthority() {
//        return name;
//    }
}
