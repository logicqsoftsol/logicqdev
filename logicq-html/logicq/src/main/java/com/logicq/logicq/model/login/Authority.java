package com.logicq.logicq.model.login;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.logicq.logicq.common.ConvertClass;

import java.util.List;

@Entity
@Table(name = "AUTHORITY")
@ConvertClass
public class Authority {

    @Id
    @Column(name = "ID",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<Login> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public List<Login> getUsers() {
        return users;
    }

    public void setUsers(List<Login> users) {
        this.users = users;
    }
}