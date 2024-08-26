package org.group39fsworkingproject.dto.managerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ManagerCreateRequestDto {

    @NotBlank(message = "Manager name не должен быть пустой")
    @Size(min = 3, max = 15)
    private String managerName;
    private String password;
    @Email(message = "Некорректный формат email")
    private String email;

}
