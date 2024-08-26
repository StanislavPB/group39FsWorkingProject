package org.group39fsworkingproject.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.group39fsworkingproject.annotation.OurValidation;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Manager name must be not blank")
    @Size(min = 3, max = 15, message = "Manager name length must be between from 3 to 15 characters")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Manager name can contain only latin characters or digital")
    private String managerName;

    @OurValidation(message = "Пароль не соответствует критериям безопасности")
    private String password;

    @NotBlank
    @Email
    private String email;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    private List<Task> tasks;

}
