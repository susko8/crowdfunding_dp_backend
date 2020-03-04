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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="userid")
    Long id;

    @Column(name="login")
    String login;

    @Column(name="password")
    String password;

    @Column(name="firstname")
    String firstName;

    @Column(name="lastname")
    String lastName;

    @Column(name="userrole")
    UserRoleEnum userRoleEnum;
}
