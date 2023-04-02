package com.parkingcontrol.parkingcontrol.models;

import com.parkingcontrol.parkingcontrol.enums.RoleName;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TBG_ROLE")
public class Role implements GrantedAuthority, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idRole;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private RoleName roleName;

    public Role() {
    }


    public Role(UUID idRole, RoleName roleName) {
        this.idRole = idRole;
        this.roleName = roleName;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return this.roleName.toString();
    }
}
