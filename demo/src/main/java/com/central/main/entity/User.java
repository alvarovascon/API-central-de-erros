package com.central.main.entity;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Email
    @NotNull
    @NotBlank(message = "Email can't be blank")
    private String email;

    @Column
    @NotNull
    @NotBlank
    private String password;
}
