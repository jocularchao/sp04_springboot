package com.example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Create with IntelliJ IDEA.
 *
 * @author JocularChao
 * @date 2023/11/9 18:26
 * @Description
 */
@Data
@AllArgsConstructor
public class User {

    @Length(min = 3)
    private String username;
    @Length(min = 10)
    private String password;
}
