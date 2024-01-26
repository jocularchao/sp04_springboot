package com.example._02jpa.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/8 20:34
 * @Description
 */
@Data
@Entity
@Table(name = "user")
public class User {

    @Column(name = "username")
    @Id
    private String username;

    @Column(name = "password")
    private String password;


}
