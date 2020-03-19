package com.crowdfunding.dp.backend.model;

import com.crowdfunding.dp.backend.types.UserRoleEnum;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name="users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="userid")
    private Long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="firstname")
    private String firstName;

    @Column(name="lastname")
    private String lastName;

    @Column(name="userrole")
    private UserRoleEnum userRoleEnum;
}
