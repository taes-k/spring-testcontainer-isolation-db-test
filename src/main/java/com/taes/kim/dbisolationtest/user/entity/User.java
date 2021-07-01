package com.taes.kim.dbisolationtest.user.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Getter
@Setter
@Table(name = "user")
@Entity
public class User
{
    @Id
    @Column(length = 40)
    private String id;

    @Column(length = 400, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String name;
}
