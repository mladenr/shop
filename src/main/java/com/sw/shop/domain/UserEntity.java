package com.sw.shop.domain;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity(name = "users")
public class UserEntity extends BaseEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String username;

    @NotEmpty
    @Size(max = 20)
    private String password;

    @NotEmpty
    @Size(max = 20)
    private String firstName;

    @NotEmpty
    @Size(max = 20)
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(fetch = FetchType.EAGER)
    private List<HomeEntity> homes;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>();
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

    @Override
    public boolean isEnabled() {
        return true;
    }
}
