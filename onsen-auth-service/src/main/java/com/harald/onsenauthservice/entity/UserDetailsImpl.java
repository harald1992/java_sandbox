package com.harald.onsenauthservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

//
// @Entity
// @Table(name = "users")
// // automatically adds quotes via application.properties because users is normally a default user db ->  globally_quoted_identifiers: true
// @Data
// @Builder
// @AllArgsConstructor
// @NoArgsConstructor
// public class User {
//
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     protected long id;
//
//     @Column(unique = true)  // only one allowed, otherwise throw UniqueConstraintViolation exception.
//     protected String username;
//
//     protected String password;
//
//     protected boolean enabled;
//
//
//     public List<UserRole> getRoles() {
//         return new ArrayList<>();
//     }
//
//     public void setRoles(List<UserRole> userRole) {
//         return;
//     }
// }
//
// // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
// // @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
// //         inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
// // private ArrayList<UserRole> roles = new ArrayList<>();
@Entity
@Data
@Table(name = "users")
public class UserDetailsImpl implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    // @Column(name = "account_verified")
    // private boolean accountVerified;
    //
    // @OneToMany(mappedBy = "user")
    // private Set<SecureToken> tokens;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ADMIN"))
                .toList();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // @Override
    // public boolean isEnabled() {
    //     return enabled;
    // }

}
