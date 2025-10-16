package com.springbootapi.btvnbuoi34.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "khong de username trong")
    private String username;

    @Email(message = "Email khong hop le")
    @NotBlank(message = "Khong de email trong")
    private String email;

    @NotBlank(message = "Khong de mat khau trong")
    @Size(min = 6, message = "Mat khau phai co y nhat 6 ky tu")
    private String password;
}
